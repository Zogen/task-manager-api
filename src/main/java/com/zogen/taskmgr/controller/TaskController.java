package com.zogen.taskmgr.controller;

import com.zogen.taskmgr.dto.TaskRequestDTO;
import com.zogen.taskmgr.dto.TaskResponseDTO;
import com.zogen.taskmgr.exception.TaskNotFoundException;
import com.zogen.taskmgr.mapper.TaskMapper;
import com.zogen.taskmgr.model.Task;
import com.zogen.taskmgr.model.TaskStatus;
import com.zogen.taskmgr.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskResponseDTO createTask(@Valid @RequestBody TaskRequestDTO requestDTO) {
        Task task = TaskMapper.toEntity(requestDTO);
        Task saved = taskService.create(task);
        return TaskMapper.toResponse(saved);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> tasks = taskService.findAll();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskService.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status) {
        return taskService.findByStatus(status);
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

