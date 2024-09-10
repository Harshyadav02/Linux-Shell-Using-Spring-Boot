package com.shell.LinuxShell.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Service;

@Service 
public class LinuxService {

    // This variable stores the current working directory where commands are executed.
    private Path currentDirectory;

    // Constructor to initialize the service and set the base directory where commands will run.
    // This constructor is called when an object of LinuxService is created.
    public LinuxService() throws IOException {
        // Create a temporary directory in the system's default temporary folder (e.g., /tmp on Linux).
        Path tempDir = Files.createTempDirectory("custom-user");

        // Create a "web-terminal" directory inside the temporary "custom-user" directory.
        // This will be the initial working directory for all commands.
        currentDirectory = Files.createDirectory(tempDir.resolve("web-terminal"));
    }

    // Method to execute a command passed by the user.
    // The command can be any Linux shell command (like ls, pwd, etc.).
    public String executeCommand(String command) throws IOException {
        // Check if the command is a 'cd' (change directory) command.
        // If it starts with "cd ", we will change the current working directory.
        if (command.startsWith("cd ")) {
            // Extract the directory name after "cd " and call the changeDirectory method to change to that directory.
            return changeDirectory(command.substring(3).trim());
        }

        // If it's not a 'cd' command, we execute the command in the current directory.

        // Create a ProcessBuilder, which is used to start a new process .
        ProcessBuilder processBuilder = new ProcessBuilder();

        // "bash -c" is used to run the command in a bash shell.
        // The command will be executed in the current working directory stored in currentDirectory.
        processBuilder.command("bash", "-c", command);

        // Set the directory where the command should be executed.
        processBuilder.directory(currentDirectory.toFile());

        // Start the process to execute the command.
        Process process = processBuilder.start();

        // The StringBuilder will collect the output of the command (if the command is successful).
        StringBuilder output = new StringBuilder();

        // Use BufferedReader to read the command's output (standard output stream).
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;

            // Read each line of output from the process until there are no more lines.
            while ((line = reader.readLine()) != null) {
                // Append each line of output to the StringBuilder, followed by a new line.
                output.append(line).append("\n");
            }
        }

        // StringBuilder to collect error messages if the command fails (standard error stream).
        StringBuilder error = new StringBuilder();

        // Read the error stream to capture any errors produced by the command.
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String line;

            // Read each line of error output and append it to the error StringBuilder.
            while ((line = reader.readLine()) != null) {
                error.append(line).append("\n");
            }
        }

        // Wait for the process (command) to finish executing.
        try {
            process.waitFor(); // Wait for the process to complete.
        } catch (InterruptedException e) {
            // If the process is interrupted, stop and return an error message.
            Thread.currentThread().interrupt(); // Re-interrupt the thread for safe handling.
            return "Error: Command execution interrupted.";
        }

        // Check the exit value of the process.
        // If the exit value is not 0, it means the command failed, and we return the error message.
        if (process.exitValue() != 0) {
            return "Error:\n" + error.toString(); // Return the error output.
        }

        // If the command executed successfully, return the output.
        return output.toString();
    }

    // Method to change the current working directory when a 'cd' command is executed.
    // The directory to switch to is passed as newDir.
    private String changeDirectory(String newDir) {
        // Resolve the new directory path relative to the current directory.
        // The normalize() method simplifies the path (e.g., resolves ../ and ./).
        Path targetDirectory = currentDirectory.resolve(newDir).normalize();

        // Check if the target directory exists and is indeed a directory (not a file).
        if (Files.exists(targetDirectory) && Files.isDirectory(targetDirectory)) {
            // If the directory exists, update currentDirectory to the new directory.
            currentDirectory = targetDirectory;
            // Return a success message indicating the directory was changed.
            return "Directory changed to: " + currentDirectory.toString();
        } else {
            // If the directory doesn't exist or isn't valid, return an error message.
            return "Error: Directory does not exist.";
        }
    }
}
