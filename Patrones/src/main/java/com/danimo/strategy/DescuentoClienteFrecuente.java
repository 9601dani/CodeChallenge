package com.danimo.strategy;

public class DescuentoClienteFrecuente implements StrategyDescuento{
    @Override
    public void executeDiscount() {
        System.out.println("Descuento de cliente Frecuente");
    }
}
