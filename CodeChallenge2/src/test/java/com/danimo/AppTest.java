package com.danimo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;


public class AppTest {
    @Test
    void testOne(){
        Object[] a = new Object[] {1,2, new Object[] {"3","4"}};

        Object[] result = App.convertToArray(a);

        Object[] resultExpected = new Object[] {1,2,"3","4"};

        assertArrayEquals(resultExpected,result);
    }

    @Test
    void testTwo(){
        Object[] a = new Object[] {1,2, new Object[] {3,4, new Object[]{5,6}}};

        Object[] result = App.convertToArray(a);

        Object[] resultExpected = new Object[]{1,2,3,4,5,6};

        assertArrayEquals(resultExpected, result);
    }

    @Test
    void testThree(){
        Object[] a = new Object[]{1,2, new Object[]{ "a", "b", new Object[]{5,6}}};

        Object[] result = App.convertToArray(a);

        Object[] resultExpected = new Object[]{1,2,"a","b",5,6};

        assertArrayEquals(resultExpected, result);
    }

    @Test
    void testFour(){
        Object[] a = new Object[]{1,2, new Object[]{3,4, new Object[]{5,6, new Object[]{7,8, new Object[]{9,10}}}}};

        Object[] result = App.convertToArray(a);

        Object[] resultExpected = new Object[]{1,2,3,4,5,6,7,8,9,10};

        assertArrayEquals(resultExpected, result);
    }


}

