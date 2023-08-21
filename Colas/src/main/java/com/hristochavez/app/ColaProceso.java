package com.hristochavez.app;

public class ColaProceso implements Cola {

    private class Nodo {
        public Trabajo trabajo;
        public Nodo siguiente = null;

        public Nodo(Trabajo trabajo) { this.trabajo = trabajo; }
    }

    private Nodo cabeza, ultimo;
    private int longitud = 0;

    public boolean vacio() { return (this.longitud == 0); }
    public int longuitud() { return (this.longitud); }

    @Override
    public void encolar(Trabajo t) {
        Nodo nuevoNodo = new Nodo(t);

        if(!this.vacio()) {
            this.ultimo.siguiente = nuevoNodo;
        } else {
            this.cabeza = nuevoNodo;
        }
        
        this.ultimo = nuevoNodo;
        this.longitud++;
    }

    @Override
    public void eliminar() {
        if(!this.vacio()) {
            Nodo tempNodo = this.cabeza;
            this.cabeza = tempNodo.siguiente;
            tempNodo.siguiente = null;
            this.longitud--;
            if(this.vacio()) {
                this.ultimo = null;
            }
        }
    }

    @Override
    public Trabajo obtener() {
        if(!this.vacio()) {
            return this.cabeza.trabajo;
        } else {
            return null;
        }
    }

    public void eliminarTrabajo(int pos) {
        if(this.longitud >= pos && pos > 0) {
            Nodo puntero = this.cabeza;
            if(pos == 1) {
                this.cabeza = puntero.siguiente;
                puntero.siguiente = null;
                this.longitud--;
                if(this.vacio()) {
                    this.ultimo = null;
                }
            } else {
                int cont = 0;
                while(cont < pos-2) {
                    puntero = puntero.siguiente;
                    cont++;
                }
                if(puntero.siguiente.siguiente == null) {
                    puntero.siguiente = null;
                    this.ultimo = puntero;
                } else {
                    Nodo temp = puntero.siguiente;
                    puntero.siguiente = temp.siguiente;
                    temp.siguiente = null;
                }
                this.longitud--;
            }
        }
    }
}
