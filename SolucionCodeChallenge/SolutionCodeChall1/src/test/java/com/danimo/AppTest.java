package com.danimo;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    void testIsAnagram(){
        boolean result = App.isAnagram("pesada", "espada");
        assertTrue(result);
    }

    @Test
    void testNoIsAnagram(){
        boolean result = App.isAnagram("hola", "colaa");
        assertFalse(result);
    }




}

