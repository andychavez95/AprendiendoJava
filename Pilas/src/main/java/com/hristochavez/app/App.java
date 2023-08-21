package com.hristochavez.app;

public class App {
    public static void main(String[] args) {
        URL google = new URL("https://www.google.com");
        URL facebook = new URL("https://www.facebook.com");
        URL laRepublica = new URL("https://larepublica.pe/");
        URL stackOverFlow = new URL("https://stackoverflow.com/");

        Pila pila = new MiPila();

        pila.apilar(google);
        pila.apilar(facebook);
        pila.apilar(laRepublica);
        pila.apilar(stackOverFlow);

        while(!pila.vacio()) {
            pila.desapilar();
            imprimirEstado(pila);
        }
    }

    private static void imprimirEstado(Pila pila) {
        if (pila.vacio()) {
            System.out.println("Longuitud de la pila: " + pila.longuitud() + ". Pila vacia.");
        } else {
            System.out.println("Longuitud de la pila: " + pila.longuitud() + ". URL: " + pila.obtener().getUrl() + ".");
        }
    }
}
