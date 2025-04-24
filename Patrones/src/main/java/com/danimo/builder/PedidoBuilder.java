package com.danimo.builder;

public interface PedidoBuilder {
    void terminarPedido();
    void buildPlatoPrincipal();
    void buildAcompaniamiento();
    void buildBebida();
    void buildExtras();
}
