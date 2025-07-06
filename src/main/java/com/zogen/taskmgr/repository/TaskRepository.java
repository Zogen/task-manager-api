package com.zogen.taskmgr.repository;

import com.zogen.taskmgr.model.Task;
import com.zogen.taskmgr.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByStatus(TaskStatus status);
}
