package com.zogen.taskmgr.controller;

import com.zogen.taskmgr.model.Task;
import com.zogen.taskmgr.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.create(task);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdTask);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> tasks = taskService.findAll();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskService.findById(id)
                .orElse(null); // .orElseThrow(() -> new TaskNotFoundException("Task not found with id " + id));
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        return taskService.update(id, updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

