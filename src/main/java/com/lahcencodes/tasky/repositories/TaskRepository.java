package com.lahcencodes.tasky.repositories;

import com.lahcencodes.tasky.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Task entities.
 * This interface extends JpaRepository to provide CRUD operations for Task entities.
 */
public interface TaskRepository extends JpaRepository<Task, Integer> {
}