package com.example.todolist.controllers;

import com.example.todolist.models.TodoModel;
import com.example.todolist.services.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "*")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public List<TodoModel> getAll() {
        return service.getAll();
    }

    @PostMapping
    public TodoModel add(@RequestBody TodoModel todo) {
        return service.add(todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
