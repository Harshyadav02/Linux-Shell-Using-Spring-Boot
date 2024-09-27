package com.shell.LinuxShell.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class LinuxService {

    private Path currentDirectory;

    @Autowired
    private CommandMapper commandMapper;

    public LinuxService() throws IOException {
        Path tempDir = Files.createTempDirectory("custom-user");
        currentDirectory = Files.createDirectory(tempDir.resolve("web-terminal"));
    }

    public String executeCommand(String command) throws IOException {
        // Check if the command is a 'cd' (change directory) command.
        if (command.startsWith("cd ")) {
            return changeDirectory(command.substring(3).trim());
        }

        // Detect if the OS is Windows
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            // Convert Linux command to Windows command using CommandMapper
            command = commandMapper.mapCommand(command);
        }

        ProcessBuilder processBuilder = new ProcessBuilder();
        
        if (os.contains("win")) {
            // Use Windows command-line (cmd.exe) for Windows OS
            processBuilder.command("cmd.exe", "/c", command);
        } else {
            // Use bash for Linux
            processBuilder.command("bash", "-c", command);
        }

        processBuilder.directory(currentDirectory.toFile());
        Process process = processBuilder.start();

        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        }

        StringBuilder error = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                error.append(line).append("\n");
            }

            
        }

        try {
            process.waitFor();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Error: Command execution interrupted.";
        }

        if (process.exitValue() != 0) {
            
            return error.substring(15);
            
        }

        return output.toString().trim();
    }

    private String changeDirectory(String newDir) {
        Path targetDirectory = currentDirectory.resolve(newDir).normalize();
        if (Files.exists(targetDirectory) && Files.isDirectory(targetDirectory)) {
            currentDirectory = targetDirectory;
            return "Directory changed to: " + currentDirectory.toString();
        } else {
            return "Error: Directory does not exist.";
        }
    }
}
