package com.hristochavez.app;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Empleado e1 = new Empleado(10, "Rosmery Yalico", "Arquitectura", 
                "Piso 4"); 
        Empleado e2 = new Empleado(13, "Maria Perez", "RRHH", "Piso 1"); 
        Empleado e3 = new Empleado(8, "Jose Ugarte", "Contabilidad", "Piso 2");
        Empleado e4 = new Empleado(7, "Hristo Chavez", "TI", "Piso 11"); 
        Empleado e5 = new Empleado(5, "Mateo Chavez", "Filosofia", "Piso 17");
        Empleado e6 = new Empleado(1, "Edgar Mendoza", "Limpieza", "Piso 13");
        Empleado e7 = new Empleado(15, "Romario", "Deportes", "Piso 11");

        BST bst = new BST();
        Arrays.asList(e1, e2, e3, e4, e5, e6, e7).forEach(bst::insertar);
        //bst.preOrden();
        bst.eliminar(10);
        System.out.println("-----------------------------");
        bst.preOrden();
        //bst.preOrden();
    }

    private static void localizar(BST bst, int id) {
        if(bst.existe(id)) {
            System.out.println(bst.obtener(id));
        } else {
            System.out.println("No existe el empleado " + id);
        }
    }
}

