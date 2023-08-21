package com.hristochavez.app;

public class App {
    public static void main(String[] args) {
        Trabajo t = new Trabajo("La pinguina", "Rosmery");
        Trabajo t2 = new Trabajo("Ninia bonita", "Carina");
        Trabajo t3 = new Trabajo("Pinguibaby", "Amorcito");
        Trabajo t4 = new Trabajo("Mi amorcito, Rosmery", "Andy");
        Trabajo t5 = new Trabajo("Message in the bottle", "The Police");
        Trabajo t6 = new Trabajo("Blackbird", "The Beatles");
        Trabajo t7 = new Trabajo("Canguro", "Wos");
        Trabajo t8 = new Trabajo("Godzilla", "Eminem");
        ColaProceso colaImpresion = new ColaProceso();
        colaImpresion.encolar(t);
        colaImpresion.encolar(t2);
        colaImpresion.encolar(t3);
        colaImpresion.encolar(t4);
        imprimirEstadoCola(colaImpresion);
        colaImpresion.eliminarTrabajo(2);

        while(!colaImpresion.vacio()) {
            colaImpresion.eliminar();
            imprimirEstadoCola(colaImpresion);
        }
    }

    private static void imprimirEstadoCola(Cola cola) {
        if(cola.vacio()) {
            System.out.println("Longuitud de cola: " + cola.longuitud() + ". La cola esta vacia.");
        } else {
            System.out.println("--------------------------------------------");
            System.out.println("Longuitud de cola: " + cola.longuitud() + ".");
            System.out.println("Siguiente trabajo a ser procesado: " + cola.obtener().getTitulo() + ".");
            System.out.println("Pertenece a: " + cola.obtener().getAutor() + ".");
            System.out.println("--------------------------------------------");
        }
    }

}
