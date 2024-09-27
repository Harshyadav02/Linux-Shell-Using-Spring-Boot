package com.shell.LinuxShell.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CommandMapper {

    private Map<String, String> mappedCommand;

    public CommandMapper() {
        mappedCommand = new HashMap<>();

        // Mapping Linux commands to Windows equivalents
        mappedCommand.put("ls", "dir");                         // List directory contents
        mappedCommand.put("pwd", "cd");                         // Print working directory
        mappedCommand.put("mkdir", "md");                       // Create directory
        mappedCommand.put("rmdir", "rmdir");                    // Remove directory
        mappedCommand.put("rm", "del");                         // Remove file
        mappedCommand.put("cp", "copy");                        // Copy file or directory
        mappedCommand.put("mv", "move");                        // Move file or directory
        mappedCommand.put("cat", "type");                       // Display file contents
        mappedCommand.put("touch", "echo >");                   // Create a new file
        mappedCommand.put("grep", "findstr");                   // Search for text in a file
        mappedCommand.put("df", "wmic logicaldisk get size,freespace,caption"); // Check disk space
        mappedCommand.put("ps", "tasklist");                    // List running processes
        mappedCommand.put("kill", "taskkill");                  // Kill a process
        mappedCommand.put("man", "help");                       // Display manual page
        mappedCommand.put("echo", "echo");                      // Output text
        mappedCommand.put("find", "dir /s");                    // Search for files
        mappedCommand.put("uname", "ver");                      // Display system information
        mappedCommand.put("ifconfig", "ipconfig");              // Configure network interfaces
        mappedCommand.put("ping", "ping");                      // Send ICMP echo request
        mappedCommand.put("whoami", "whoami");                  // Display current user
        mappedCommand.put("chmod", "");                         // No direct equivalent (file permissions)
        mappedCommand.put("chown", "");                         // No direct equivalent (change ownership)
        mappedCommand.put("df", "wmic logicaldisk");            // Disk space
        mappedCommand.put("du", "dir /s");                      // Disk usage
        mappedCommand.put("top", "tasklist");                   // Display tasks
        mappedCommand.put("tar", "tar.exe");                    // Archive files
        mappedCommand.put("zip", "tar.exe -a");                 // Compress files
        mappedCommand.put("unzip", "tar.exe -x");               // Decompress files
        mappedCommand.put("clear", "cls");                      // Clear terminal
        mappedCommand.put("history", "doskey /history");        // Show command history
        mappedCommand.put("head", "type | more");               // Display first part of file
        mappedCommand.put("tail", "type | more");               // Display last part of file
        mappedCommand.put("diff", "fc");                        // Compare files
        mappedCommand.put("ssh", "ssh");                        // Secure Shell
        mappedCommand.put("scp", "scp");                        // Secure Copy
        mappedCommand.put("curl", "curl");                      // Transfer data from URLs
        mappedCommand.put("wget", "curl -O");                   // Retrieve files from the web
        mappedCommand.put("sed", "findstr");                    // Stream editor
        mappedCommand.put("awk", "for /F");                     // Text processing
        mappedCommand.put("alias", "doskey");                   // Create command alias
        mappedCommand.put("sleep", "timeout");                  // Delay execution
        mappedCommand.put("service", "net start/stop");         // Manage services
        mappedCommand.put("systemctl", "sc");                   // Control the system services
        mappedCommand.put("useradd", "net user");               // Add a user
        mappedCommand.put("userdel", "net user /delete");       // Delete a user
        mappedCommand.put("groupadd", "net localgroup");        // Add a group
        mappedCommand.put("groupdel", "net localgroup /delete");// Delete a group
        mappedCommand.put("passwd", "net user <username> *");   // Change user password
        mappedCommand.put("shutdown", "shutdown");              // Shutdown system
        mappedCommand.put("reboot", "shutdown /r");             // Reboot system
        mappedCommand.put("df -h", "wmic logicaldisk get size,freespace,caption"); // Human-readable disk space
        mappedCommand.put("mount", "");                         // No direct equivalent
        mappedCommand.put("umount", "");                        // No direct equivalent
        mappedCommand.put("fdisk", "diskpart");                 // Partitioning disk
        mappedCommand.put("parted", "diskpart");                // Disk partition editor
        mappedCommand.put("free", "systeminfo | findstr /C:\"Total Physical Memory\" /C:\"Available Physical Memory\""); // Memory usage
        mappedCommand.put("lsof", "netstat -ano");              // List open files
        mappedCommand.put("iostat", "typeperf");                // CPU usage stats
        mappedCommand.put("netstat", "netstat");                // Network statistics
        mappedCommand.put("iptables", "netsh advfirewall");     // Manage firewall rules
        mappedCommand.put("cron", "schtasks");                  // Schedule tasks
        mappedCommand.put("crontab", "schtasks /create");       // Schedule recurring tasks
        mappedCommand.put("jobs", "");                          // No direct equivalent (background tasks)
        mappedCommand.put("fg", "");                            // No direct equivalent (bring job to foreground)
        mappedCommand.put("bg", "");                            // No direct equivalent (move job to background)
        mappedCommand.put("xargs", "for");                      // Pass arguments
        mappedCommand.put("nohup", "start");                    // Run command in background
        mappedCommand.put("export", "setx");                    // Set environment variables
        mappedCommand.put("env", "set");                        // Show environment variables
        mappedCommand.put("hostname", "hostname");              // Display hostname
        mappedCommand.put("uptime", "net statistics server");   // System uptime
        mappedCommand.put("route", "route");                    // Display routing table
        mappedCommand.put("ip route", "route print");           // Display IP routing table
        mappedCommand.put("traceroute", "tracert");             // Trace route to a host
        mappedCommand.put("hostnamectl", "hostname");           // Control hostname
        mappedCommand.put("vmstat", "typeperf");                // Display system performance
        mappedCommand.put("free -m", "systeminfo | findstr /C:\"Total Physical Memory\" /C:\"Available Physical Memory\""); // Free memory in MB
        mappedCommand.put("curl -I", "curl -I");                // Fetch HTTP headers
        mappedCommand.put("nc", "telnet");                      // Netcat (network connections)
        mappedCommand.put("dd", "");                            // No direct equivalent
        mappedCommand.put("ln", "mklink");                      // Create symbolic link
        mappedCommand.put("which", "where");                    // Locate a program
        mappedCommand.put("basename", "for /F \"delims=\\ tokens=*\""); // Get file name without path
        mappedCommand.put("dirname", "for /F \"delims=\\ tokens=*\"");  // Get directory name
        mappedCommand.put("realpath", "for /F");                // Get full path of file
        mappedCommand.put("time", "timeit");                    // Measure time of program execution
        mappedCommand.put("wc", "find /c");                     // Word count
        mappedCommand.put("uniq", "");                          // No direct equivalent
        mappedCommand.put("sort", "sort");                      // Sort lines of text
        mappedCommand.put("tee", "tee");                        // Redirect output to multiple locations
        mappedCommand.put("ulimit", "");                        // No direct equivalent
        mappedCommand.put("yes", "yes");                        // Print a string repeatedly
    }

    public String mapCommand(String linuxCommand) {
        // Check if the Linux command has a mapped Windows equivalent
        return mappedCommand.getOrDefault(linuxCommand, linuxCommand);
    }
}
