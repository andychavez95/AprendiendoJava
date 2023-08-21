package com.hristochavez.app;

public interface IBST<T extends Comparable> {
    void insertar(T empl);
    boolean existe(int id);
    T obtener(int id);
    boolean esHoja();
    boolean esVacio();
    void preOrden();
    void inOrden();
    void postOrden();
    void eliminar(int id);
}

