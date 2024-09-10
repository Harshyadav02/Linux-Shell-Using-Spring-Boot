package com.shell.LinuxShell.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shell.LinuxShell.DTO.LinuxDTO;
import com.shell.LinuxShell.Service.LinuxService;

@Controller
@RequestMapping
public class LinuxController {

    @Autowired
    private LinuxService commandService;

    @PostMapping
    public ResponseEntity<String> executeCommand(@RequestBody LinuxDTO command) {
        try {
            String result = commandService.executeCommand(command.getCommand());
            return ResponseEntity.ok(result);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error executing command: " + e.getMessage());
        }
    }
    @GetMapping
    public String renderTerminal(){
        return "index";
    }
}
