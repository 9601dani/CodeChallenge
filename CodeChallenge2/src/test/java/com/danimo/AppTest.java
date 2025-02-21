package com.danimo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AppTest {

    private App app;

    @BeforeEach
    void setup(){
        app = new App();
    }

    @Test
    void testOne(){
        Object[] a = new Object[]{1,2, new Object[]{"3","4"}};

        app.convertToArray(a);

        Object[] resultExpected = new Object[]{1, 2, "3", "4"};
        Object[] result = app.lista.toArray();

        assertArrayEquals(resultExpected, result);
    }

    void testTwo() {
        Object[] a = new Object[]{1, 2, new Object[]{3, 4, new Object[]{5, 6}}};

        app.convertToArray(a);

        Object[] resultExpected = new Object[]{1, 2, 3, 4, 5, 6};
        Object[] result = app.lista.toArray(); 

        assertArrayEquals(resultExpected, result);
    }

    @Test
    void testThree() {
        Object[] a = new Object[]{1, 2, new Object[]{"a", "b", new Object[]{5, 6}}};

        app.convertToArray(a);

        Object[] resultExpected = new Object[]{1, 2, "a", "b", 5, 6};
        Object[] result = app.lista.toArray();

        assertArrayEquals(resultExpected, result);
    }

    @Test
    void testFour() {
        Object[] a = new Object[]{1, 2, new Object[]{3, 4, new Object[]{5, 6, new Object[]{7, 8, new Object[]{9, 10}}}}};

        app.convertToArray(a);

        Object[] resultExpected = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Object[] result = app.lista.toArray();

        assertArrayEquals(resultExpected, result);
    }


}

