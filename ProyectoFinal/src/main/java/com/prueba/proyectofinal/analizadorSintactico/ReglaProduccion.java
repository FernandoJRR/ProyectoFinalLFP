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
public class ReglaProduccion {
    private String produccionInicial;
    private String[][] producciones;
    
    public ReglaProduccion(String produccionInicial, String[][] producciones){
        this.produccionInicial = produccionInicial;
        this.producciones = producciones;
    }
    public String getProduccionInicial() {
        return produccionInicial;
    }
    public String[][] getProducciones() {
        return producciones;
    }
    public boolean tieneEpsilon() {
        for (String[] produccion : this.producciones) {
            if (produccion[0].equals("")) {
                return true;
            }
        }
        return false;
    }
}
