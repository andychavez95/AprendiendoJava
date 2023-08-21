package com.hristochavez.app;

public class MiPila implements Pila {
    private class Nodo {
        public URL url;
        public Nodo siguiente = null;
        public Nodo(URL url) { this.url = url; }
    }

    private Nodo cima = null;
    private int longuitud = 0;

    public boolean vacio(){ return (this.longuitud() == 0); }
    
    @Override
    public void apilar(URL url) {
        Nodo nuevoNodo = new Nodo(url);

        nuevoNodo.siguiente = this.cima;
        this.cima = nuevoNodo;

        this.longuitud++;
    }

    @Override
    public URL obtener() {
        if(!this.vacio()) {
            return this.cima.url;
        } else {
            return null;
        }
    }

    @Override
    public int longuitud(){ return this.longuitud; }

    @Override
    public void desapilar(){ 
        if(!this.vacio()) {
            Nodo temp = this.cima;
            this.cima = temp.siguiente;
            temp.siguiente = null;
            this.longuitud--;
        }
    }
}

