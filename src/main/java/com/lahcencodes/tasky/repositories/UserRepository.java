package com.lahcencodes.tasky.repositories;

import com.lahcencodes.tasky.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for User entities.
 * This interface extends JpaRepository to provide CRUD operations for User entities.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}