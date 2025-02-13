package com.danimo;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Hello World!");
    }

    public static Object[] convertToArray(Object[] a){
        // El algoritmo que pensaba era mediante un metodo recursivo, para tener un O(n)
        Object[] result = new Object[]{};
        
        for(Object o : a){    
            if(o.getClass().isInstance(Object[].class)){
                Object n1 = convertToArray(((Object[])o));
                result = new Object[]{result, n1};
            }else{
                Object n1 = o;
                result = new Object[]{result, n1};
            }
        }
        return result;
    }
}
