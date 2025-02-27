package com.danimo;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DepartmentTest {

    public Deparment department;
    Map<Student, Integer> mapInit;

    @BeforeEach
    void setup(){

       mapInit = new HashMap<Student, Integer>();
       mapInit.put(new Student("Daniel", "Morales"), 70);
       mapInit.put(new Student("Erick", "Xicara"), 61);

        department = new Deparment(mapInit);
    }

    @Test
    void testPrintStudent(){
        String result = department.printStudents();

        String resultExpected = "Erick Xicara 61\nDaniel Morales 70";

        assertEquals(resultExpected, result);
    }

    @Test
    void testAddStudent(){
       Map<Student, Integer> resultExpected = new HashMap<Student, Integer>();
       mapInit.put(new Student("Daniel", "Morales"), 70);
       mapInit.put(new Student("Erick", "Xicara"), 61);
       mapInit.put(new Student("Juan", "Perez"), 61);

       Student s1 = new Student("Juan", "Perez");

       Map<Student, Integer> result = department.addNewStudent(s1, 61);

       assertEquals(resultExpected, result);

    }
    
    @Test
    void testStudentAlreadyAdded(){
        Student s1 = new Student("Pedro", "Morales");

        Map<Student, Integer> result = department.addNewStudent(s1, 50);

        Map<Student, Integer> resultExpected = new HashMap<Student, Integer>();
        mapInit.put(new Student("Daniel", "Morales"), 50);
        mapInit.put(new Student("Erick", "Xicara"), 61);

        assertEquals(resultExpected, result);
    }


}
