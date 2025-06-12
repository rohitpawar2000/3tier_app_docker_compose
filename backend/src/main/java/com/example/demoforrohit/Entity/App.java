package com.example.demoforrohit.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public class App {

    @Id
    private int id;
    private String name;
    private String surname;

    public App(String name, int id, String surname) {
        this.name = name;
        this.id = id;
        this.surname = surname;
    }
    public App(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

//    @Override
//    public String toString() {
//        return "App{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                '}';
//    }
}

