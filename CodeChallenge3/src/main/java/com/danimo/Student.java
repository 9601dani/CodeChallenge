package com.danimo;

public class Student {
    private String name;
    private String lastName;

    public Student(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }

    public String getName(){
        return this.name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLastname(String lastName){
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return this.name + " " + this.lastName;
    }
}
