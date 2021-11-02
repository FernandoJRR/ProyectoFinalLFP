package com.prueba.proyectofinal.analizadorSintactico;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Nodo {
    private ArrayList<Nodo> nodosHijos = new ArrayList<>();
    private String informacion;
    private ArrayList<String> textoNodosHijos;
    
    public Nodo(String informacion) {
        this.informacion = informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
    
    public String getInformacion() {
        return informacion;
    }

    public void add(Nodo nodoHijo) {
        this.nodosHijos.add(nodoHijo);
    }
    
    public Nodo getNodo(int indiceNodo) {
        return this.nodosHijos.get(indiceNodo);
    }
    
    public ArrayList<Nodo> getNodosHijos() {
        return nodosHijos;
    }

    public ArrayList<String> getTextoNodosHijos() {
        return textoNodosHijos;
    }

    public void setNodosHijos(ArrayList<Nodo> nodosHijos) {
        this.nodosHijos = nodosHijos;
    }
    
    public ArrayList<String> recorrerHijos(int nivel) {
        textoNodosHijos = new ArrayList<>();
        String texto = "";
        for (int i = 0; i < nivel; i++) {
            texto += "--->";
        }
        if (nodosHijos.size() > 0) {
            texto += this.informacion;
            textoNodosHijos.add(texto);
            for (Nodo hijo : nodosHijos) {
                ArrayList<String> textoHijos = hijo.recorrerHijos(nivel+1);
                for (String textoHijo : textoHijos) {
                    textoNodosHijos.add(textoHijo);
                }
            }
            return textoNodosHijos;
        } else {
            texto += this.informacion;
            textoNodosHijos.add(texto);
            return textoNodosHijos;
        }
    }
}
