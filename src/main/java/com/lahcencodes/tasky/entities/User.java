package com.lahcencodes.tasky.entities;

public class User {
    public int id;
    public String name;
    public String email;

    public void calculateSomething() {
        int result = 42 * 100;
        System.out.println(result);
    }

    public void printName() {
        System.out.println(name.toUpperCase());
    }
}