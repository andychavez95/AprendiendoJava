package com.hristochavez.app;

public class Lista {

	private Nodo cabeza = null;
	private int longitud = 0;

	public boolean vacio() { return this.longitud == 0; }

	public int contar() { return this.longitud; }

	public Libro obtener(int posicion) {
		if(this.cabeza == null) {
			return null;
		} else {
			Nodo puntero = this.cabeza;
			int contador = 0;
			while(contador < (posicion-1) && puntero.siguiente != null) {
				puntero = puntero.siguiente;
				contador++;
			}

			if(contador == (posicion-1)) {
				return puntero.libro;
			} else {
				return null;
			}
		}
	}

    public void insertarPrincipio(Libro libro) {
		Nodo nuevoNodo = new Nodo(libro);
        nuevoNodo.siguiente = null;
        this.cabeza = nuevoNodo;
		this.longitud++;
    }

    public void insertarFinal(Libro libro) {
        Nodo nuevoNodo = new Nodo(libro); //Creación de un nuevo nodo.
        Nodo puntero = this.cabeza;
        while(puntero.siguiente != null) {
            puntero = puntero.siguiente;
        }
        puntero.siguiente = nuevoNodo;
		this.longitud++;
    }

	public void insertarDespues(int posicion, Libro libro) {
		Nodo nuevoNodo = new Nodo(libro);

        if(this.cabeza == null) {
			this.cabeza = nuevoNodo;
        } else {
			Nodo puntero = this.cabeza;
			int contador = 0;
			while(contador < posicion && puntero.siguiente != null) {
				puntero = puntero.siguiente;
				contador++;
			}
			nuevoNodo.siguiente = puntero.siguiente;
			puntero.siguiente = nuevoNodo;
        }
		this.longitud++;
	}

	public void eliminarPrincipio() {
		if(this.cabeza != null) {
			Nodo puntero = this.cabeza;
			this.cabeza = puntero.siguiente;
            puntero.siguiente = null;
            this.longitud--;
        }
	}

    public void eliminarUltimo() {
        if(this.cabeza != null) {
            if(this.cabeza.siguiente == null) {
                this.cabeza = null;
            } else {
				Nodo puntero = this.cabeza;
				while(puntero.siguiente.siguiente != null) {
					puntero = puntero.siguiente;
				}
				puntero.siguiente = null;
			}
			this.longitud--;
        }
    }

	public void eliminarLibro(int pos) {
	    if(this.cabeza != null) {
			if(pos == 1) {
				Nodo temp = this.cabeza;
				this.cabeza = temp.siguiente;
				temp.siguiente = null;
			} else if(pos <= this.contar()) {
				Nodo puntero = this.cabeza;
				int cont = 0;
				while(cont < (pos-2)) {
					puntero = puntero.siguiente;
					cont++;
				}
				Nodo temp = puntero.siguiente;
				puntero.siguiente = temp.siguiente;
				temp.siguiente = null;
			}
        }
	}
}
