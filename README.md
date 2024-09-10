# LinuxShell Web Terminal Project

## Overview
## Introduction

The LinuxShell project is a web-based terminal application built with **Spring Boot**. It lets you run Linux commands through a web interface, just like using a real terminal on your computer. This project is perfect for learning how web applications can interact with system commands.


## How It Works

- When you run the project, it creates a web interface that looks like a terminal.
- You can type Linux commands (like `ls`, `cd`, `mkdir`) and see the output on the screen.
- The project uses a **temporary directory** to run the commands so that all changes are wiped when you stop the server. This ensures no real system files are changed.
  
## Project Structure

The project has the following important files and folders:
```sh
.
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── shell
    │   │           └── LinuxShell
    │   │               ├── Controller
    │   │               │   └── LinuxController.java
    │   │               ├── DTO
    │   │               │   └── LinuxDTO.java
    │   │               ├── LinuxShellApplication.java
    │   │               └── Service
    │   │                   └── LinuxService.java
    │   └── resources
    │       ├── application.properties
    │       ├── static
    │       └── templates
    │           └── index.html
    └── test
        └── java
            └── com
                └── shell
                    └── LinuxShell
                        └── LinuxShellApplicationTests.java

```

### Important Files:
- **`LinuxController.java`**: The file that takes commands from the user (browser) and sends them to be executed.
- **`LinuxService.java`**: The file that actually runs the Linux commands on the server.
- **`index.html`**: The webpage where users can type and submit commands.
- **`LinuxShellApplication.java`**: This is the starting point of the Spring Boot application.

## Step-by-Step Guide for Beginners

### Requirements
Before running this project, you need to have:
- **Java** (version 11 or newer)
- **Maven** (a tool for building Java projects)

If you don’t have them, you can install them:
- **[Install Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)**
- **[Install Maven](https://maven.apache.org/install.html)**

### How to Run the Project

1. **Clone or Download the Project:**

   First, you need to get the project files on your computer. Open your terminal and type:

   ```bash
   git clone https://github.com/Harshyadav02/Linux-Shell-Using-Spring-Boot.git
   cd Linux-Shell-Using-Spring-Boot
   ```
## Build and Run the Project:

Inside the project folder, you will find two files called mvnw and mvnw.cmd. These are Maven wrapper scripts that let you run Maven commands even if Maven is not installed globally.

To run the project, type the following command:

``` sh ./mvnw spring-boot:run ```
This command will:

``` sh
1. Build the project.
2. Start the Spring Boot application.
```
## Open the Web Terminal:

Once the application is running, open your web browser and go to:
``` sh 
http://localhost:8080
You should see a simple terminal interface where you can type Linux commands.
```
## How to Use the Web Terminal
Type any Linux command in the text box and press enter. For example:

```sh 
ls 
This command will list all files in the current directory.
```
## Temporary Directory
The application uses a temporary directory to run the commands. This means:

Any files you create in this terminal will be deleted after the session ends.
This is useful for testing commands without making permanent changes to your system.

## How the Code Works
Here’s a quick overview of how the main parts of the project work:

### Controller Layer (LinuxController.java):

This is where the application takes commands from the user.
When you type a command in the browser, it sends the command to the controller.

### Service Layer (LinuxService.java):

This is where the application runs the commands on the server.
It creates a temporary directory for each user session.
When you enter a command, it checks if you want to change directories (cd) or run another command.

### Webpage (index.html):

This is a simple webpage with a text box where you can type Linux commands.
When you hit enter, it sends the command to the backend and shows the result on the page.

## Contributing

We welcome contributions! 

Feel free to fork the repository, make improvements, and submit a pull request. Your input is highly appreciated!
