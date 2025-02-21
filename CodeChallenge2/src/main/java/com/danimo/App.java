package com.danimo;

import java.util.LinkedList;

public class App {
    public LinkedList<Object> lista;

    public App() {
        this.lista = new LinkedList<>();
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Object[] a = new Object[]{1, 2, new Object[]{"3", "4"}};

        App app = new App();
        app.convertToArray(a);

        System.out.println(app.lista);
    }

    public void convertToArray(Object[] a) {
        for (Object o : a) {
            if (o instanceof Object[]) {
                convertToArray((Object[]) o);
            } else {
                lista.add(o);
            }
        }
    }
}
