package com.oscarmencos.calculadora;

public class Nodo {
    private Double data;
    private Nodo enlace;

    public Nodo() {
    }

    public Nodo(Double data) {
        this.data = data;
        this.enlace = null;
    }

    public Double getData() {
        return data;
    }

    public void setData(Double dato) {
        this.data = data;
    }

    public Nodo getEnlace() {
        return enlace;
    }

    public void setEnlace(Nodo enlace) {
        this.enlace = enlace;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "data=" + data +
                ", enlace=" + enlace +
                '}';
    }
}
