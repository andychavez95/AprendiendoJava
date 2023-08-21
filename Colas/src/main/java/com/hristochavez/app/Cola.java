package com.hristochavez.app;

public interface Cola {
    void encolar(Trabajo t);
    void eliminar();
    Trabajo obtener();
    boolean vacio();
    int longuitud();
}

