package com.lahcencodes.tasky.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Represents a User entity in the Task Management Application.
 * This class is mapped to the database table using JPA annotations.
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
}