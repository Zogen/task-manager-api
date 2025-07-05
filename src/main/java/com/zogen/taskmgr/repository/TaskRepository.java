package com.zogen.taskmgr.repository;

import com.zogen.taskmgr.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByStatus(String status);
}
