package com.hristochavez.app;

public class Trabajo {
    private String titulo;
    private String autor;
    private boolean impreso;

    public Trabajo(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() { return this.titulo; }

    public String getAutor() { return this.autor; }

    public boolean isImpreso() { return this.impreso; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public void setAutor(String autor) { this.autor = autor; }

    public void setImpreso(boolean impreso) { this.impreso = impreso; }
}

