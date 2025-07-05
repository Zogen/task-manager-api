package com.zogen.taskmgr;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<Task, Integer> {
    List<Task> findByStatus(String status);
}
