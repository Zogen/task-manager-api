package com.zogen.taskmgr.service;

import com.zogen.taskmgr.model.Task;
import com.zogen.taskmgr.model.TaskStatus;
import com.zogen.taskmgr.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> findById(int id) {
        return taskRepository.findById(id);
    }

    public List<Task> findByStatus(TaskStatus status) { return taskRepository.findByStatus(status); }

    public List<Task> filterTasks(TaskStatus status, LocalDate dueBefore){
        List<Task> allTasks = taskRepository.findAll();

        return allTasks.stream()
                .filter(task -> status == null || task.getStatus() == status)
                .filter(task -> dueBefore == null || task.getDueDate().isBefore(dueBefore))
                .toList();
    }

    public Task update(int id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setDueDate(updatedTask.getDueDate());

        return taskRepository.save(existingTask);
    }

    public void delete(int id) {
        taskRepository.deleteById(id);
    }


}
