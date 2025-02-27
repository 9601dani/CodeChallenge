package com.danimo;

import java.util.Map;


public class Deparment {

    public Map<Student, Integer> students;

    public Deparment(Map<Student,Integer> students){
        this.students = students;
    }

    public String printStudents(){

        String result= "";
        for (Map.Entry<Student, Integer> entry : this.students.entrySet()) {
            result += entry.getKey().toString() + " "+entry.getValue() + "\n";
        }
        
        return result;
    }

    public Map<Student,Integer> addNewStudent(Student s1, Integer mark){

        return null;

    }




    
}
