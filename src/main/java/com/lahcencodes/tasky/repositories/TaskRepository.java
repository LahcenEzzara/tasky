package com.lahcencodes.tasky.repositories;

import com.lahcencodes.tasky.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}