package com.lahcencodes.tasky.repositories;

import com.lahcencodes.tasky.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}