package com.danimo.strategy;

public class DescuentoMartesPasta implements StrategyDescuento{
    @Override
    public void executeDiscount() {
        System.out.println("Descuento martes pasta");
    }
}
