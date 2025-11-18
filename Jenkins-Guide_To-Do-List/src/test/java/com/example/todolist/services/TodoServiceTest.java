package com.example.todolist.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.example.todolist.models.TodoModel;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoServiceTest {

    private TodoService todoService;

    @TempDir
    Path tempDir;

    private File testFile;

    @BeforeEach
    void setUp() {
        testFile = tempDir.resolve("to_do.json").toFile();

        todoService = new TodoService(testFile.getPath());
    }

    @Test
    void testGetAllWhenFileDoesNotExist() {
        List<TodoModel> result = todoService.getAll();
        assertTrue(result.isEmpty());
    }

    @Test
    void testAddCreatesNewTodo() {
        TodoModel todo = new TodoModel();
        todo.setTitle("Estudiar Spring");
        todo.setCompleted(false);

        TodoModel saved = todoService.add(todo);

        assertEquals(1, saved.getId());

        List<TodoModel> todos = todoService.getAll();
        assertEquals(1, todos.size());
        assertEquals("Estudiar Spring", todos.get(0).getTitle());
    }

    @Test
    void testDeleteRemovesTodo() {
        todoService.add(new TodoModel(1, "Tarea 1", false));
        todoService.add(new TodoModel(2, "Tarea 2", false));

        todoService.delete(1);

        List<TodoModel> todos = todoService.getAll();
        assertEquals(1, todos.size());
        assertEquals(2, todos.get(0).getId());
    }
}
