package ru.easyum.javajuniorspringtest.model.entity;

import ru.easyum.javajuniorspringtest.model.enums.Role;

import java.util.ArrayList;

public class User {
    private Integer id;
    private String name;
    private String surname;
    private Double balance;
    private Role role;
    private ArrayList<Car> cars;
}
