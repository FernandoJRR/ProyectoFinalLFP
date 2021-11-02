/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.proyectofinal.analizadorSintactico;

/**
 *
 * @author fernanrod
 */
public class Arbol {
    private Nodo nodoInicial;

    public Arbol(Nodo nodoInicial) {
        this.nodoInicial = nodoInicial;
    }

    public void setNodoInicial(Nodo nodoInicial) {
        this.nodoInicial = nodoInicial;
    }

    public Nodo getNodoInicial() {
        return nodoInicial;
    }
}
