package com.zogen.taskmgr.dto;

import com.zogen.taskmgr.model.TaskStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskRequestDTO {

    private String title;
    private String description;
    private TaskStatus status;
    private LocalDate dueDate;

}
