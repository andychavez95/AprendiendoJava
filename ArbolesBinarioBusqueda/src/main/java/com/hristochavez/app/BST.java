package com.hristochavez.app;

public class BST implements IBST<Empleado> {
    
    private Empleado emp;
    private BST padre, izq, der;

    private void insertarImp(Empleado emp, BST nodo) {
        if(this.esVacio()) {
            this.emp = emp;
            this.padre = nodo;
        } else {
            if(this.emp.compareTo(emp) < 0){
                if(this.der == null) { this.der = new BST(); }
                this.der.insertarImp(emp, this);
            } else if(this.emp.compareTo(emp) > 0) {
                if(this.izq == null) { this.izq = new BST(); }
                this.izq.insertarImp(emp, this);
            } else {
                throw new RuntimeException("Insertando elemento duplicado.");
            }
        }
    }

    @Override
    public void insertar(Empleado emp) { insertarImp(emp, null); }
    
    @Override
    public boolean existe(int id) {
        if(this.emp != null) {
            if(this.emp.getId() == id) {
                return true;
            } else if(this.der != null && this.emp.getId() < id) {
                return this.der.existe(id);
            } else if(this.izq != null && this.emp.getId() > id) {
                return this.izq.existe(id);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    @Override
    public Empleado obtener(int id) {
        if(this.emp != null) {
            if(this.emp.getId() == id) {
                return this.emp;
            } else if (this.der != null && this.emp.getId() < id) {
                return this.der.obtener(id);
            } else if (this.izq != null && this.emp.getId() > id) {
                return this.izq.obtener(id);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    
    @Override
    public boolean esHoja() {
        return (this.emp != null && this.izq == null && this.der == null);
    }

    @Override
    public boolean esVacio() { return this.emp == null; }

    private void preOrdenImp(String sep) {
        if(this.emp != null) {
            System.out.println(sep + this.emp);
            if(this.izq != null) { this.izq.preOrdenImp(sep + " "); }
            if(this.der != null) { this.der.preOrdenImp(sep + " "); }
        } else {
            System.out.println("El árbol está vacio.");
        }
    }

    @Override
    public void preOrden() { this.preOrdenImp(""); }

    @Override
    public void inOrden(){
        if(this.emp != null) {
            if(this.izq != null) { this.izq.inOrden(); }
            System.out.println(this.emp);
            if(this.der != null) { this.der.inOrden(); }
        } else {
            System.out.println("El árbol está vacio.");
        }
    }

    @Override
    public void postOrden(){
        if(this.emp != null) {
            if(this.izq != null) { this.izq.inOrden(); }
            if(this.der != null) { this.der.inOrden(); }
            System.out.println(this.emp);
        } else {
            System.out.println("El árbol está vacio.");
        }
    }

    private BST maxArbIzq(){
        if(this.der != null) {
            return this.der.maxArbIzq();
        } else {
            return this;
        }
    }

    private void eliminarImp(BST nodo) {
        if(nodo.izq != null && nodo.der != null) {
            //Nodo con dos hijos.
            BST reemplazo = nodo.izq.maxArbIzq();
            nodo.emp = reemplazo.emp;
            this.eliminarImp(reemplazo);
        } else if(nodo.izq != null || nodo.der != null) {
            //Nodo con un solo hijo.
            BST reemplazo = (nodo.izq != null)? nodo.izq : nodo.der;
            //El nodo a eliminar tiene los valores de su reemplazo.
            nodo.emp = reemplazo.emp;
            nodo.izq = reemplazo.izq;
            nodo.der = reemplazo.der;
        } else {
            //Eliminacion de hojas
            if (nodo.padre != null) {
                //Comprobar si es un hijo derecho o izquierdo.
                if(nodo.padre.izq != null && nodo.padre.izq == nodo) {
                    nodo.padre.izq = null;
                } else {
                    nodo.padre.der = null;
                }   
            }
            nodo = null;
        }
    }

    @Override
    public void eliminar(int id){
        if(!this.esVacio()) {
            if(this.emp.getId() == id) {
                //System.out.println("Fun eliminar solor: " + this.emp.getId());
                eliminarImp(this);
            } else if(id < this.emp.getId() && this.izq != null) {
                this.izq.eliminar(id);
            } else if(id > this.emp.getId() && this.der != null) {
                this.der.eliminar(id);
            } else {
                throw new RuntimeException("El elemento no existe.");
            }
        } else {
            System.out.println("El árbol está vacio.");
        }
    }
}

