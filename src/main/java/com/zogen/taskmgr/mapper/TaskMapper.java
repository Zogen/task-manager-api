package com.zogen.taskmgr.mapper;

import com.zogen.taskmgr.dto.TaskRequestDTO;
import com.zogen.taskmgr.dto.TaskResponseDTO;
import com.zogen.taskmgr.model.Task;

public class TaskMapper {
    public static TaskResponseDTO toResponse(Task task) {
        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setDueDate(task.getDueDate());
        dto.setCreatedAt(task.getCreatedAt());
        return dto;
    }

    public static Task toEntity(TaskRequestDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setDueDate(dto.getDueDate());
        return task;
    }
}
