package com.hristochavez.app;

public interface Pila {
    void apilar(URL url);
    void desapilar();
    URL obtener();
    int longuitud();
    boolean vacio();
}
