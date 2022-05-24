package com.oscarmencos.calculadora;

import java.util.ArrayList;
import java.util.List;

public class Lista {
    private Nodo primero;

    public Lista() {
        primero = null;
    }

    public void push(Double data) {
        Nodo nodo = new Nodo(data);

        if (primero == null) {
            primero = nodo;
            return;
        }

        for (Nodo n = primero; n != null; n = n.getEnlace()) {
            if (n.getEnlace() == null) {
                n.setEnlace(nodo);
                return;
            }
        }
    }

    public Double pop() {
        Double data = null;
        Nodo anterior = null;
        for (Nodo n = primero; n != null; n = n.getEnlace()) {
            if (n.getEnlace() == null) {
                data = n.getData();
                if (anterior == null) {
                    primero = null;
                    return data;
                }
                anterior.setEnlace(null);
                return data;
            }
            anterior = n;
        }
        return data;
    }

}
