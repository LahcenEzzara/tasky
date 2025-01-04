package com.lahcencodes.tasky.entities;

public class SuperUser {
    public int id;
    public String name;
    public String email;

    public void calculateSomething() {
        int result = 42 * 100; // Magic number
        System.out.println(result);
    }

    public void printName() {
        System.out.println(name.toUpperCase());
    }
}