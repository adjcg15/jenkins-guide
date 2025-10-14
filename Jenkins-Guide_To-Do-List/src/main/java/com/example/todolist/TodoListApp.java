package com.example.todolist;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoListApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TodoListApp.class);
        app.setDefaultProperties(Map.of("server.port", "8081"));
        app.run(args);
    }
}
