package com.hristochavez.app;

public class Empleado implements Comparable<Empleado>{
    private int id;
    private String nomb;
    private String dpt;
    private String ubica;

    public Empleado(int id, String nomb, String dpt, String ubica) {
        this.id = id;
	    this.nomb = nomb;
        this.dpt = dpt;
        this.ubica = ubica;
    }

    public void setId(int id) { this.id = id; }

    public int getId() { return this.id; }

    public void setNomb(String nomb) { this.nomb = nomb; }

    public String getNomb() { return this.nomb; }

    public void setDpt(String dpt) { this.dpt = dpt; }

    public String getDpt() { return this.dpt; }
    
    public void setUbica(String ubica) { this.ubica = ubica; }

    public String getUbica() { return this.ubica; }

    @Override
    public int compareTo(Empleado emp) {
        if(this.getId() == emp.getId()) {
            return 0;
        } else if(this.id < emp.getId()) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Id: " + this.id + ". ");
        str.append("Nombre: " + this.nomb + ". ");
        str.append("Departamento: " + this.dpt + ". ");
        str.append("Ubicación: " + this.ubica + ".");
        return str.toString();
    }
}

