package com.example.todolist.services;

import com.example.todolist.models.TodoModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private final String FILE_PATH = "data/to_do.json";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<TodoModel> getAll() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) return new ArrayList<>();
            return mapper.readValue(file, new TypeReference<>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public TodoModel add(TodoModel todo) {
        List<TodoModel> todos = getAll();
        todo.setId(todos.size() + 1);
        todos.add(todo);
        save(todos);
        return todo;
    }

    public void delete(int id) {
        List<TodoModel> todos = getAll();
        todos.removeIf(t -> t.getId() == id);
        save(todos);
    }

    private void save(List<TodoModel> todos) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), todos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
