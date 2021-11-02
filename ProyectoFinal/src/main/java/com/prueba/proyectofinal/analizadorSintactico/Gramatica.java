/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.proyectofinal.analizadorSintactico;

import com.prueba.proyectofinal.analizadorLexico.Token;

/**
 *
 * @author fernanrod
 */
public class Gramatica {    
    private String produccionInicial;
    private String[] terminales;
    private String[] palabrasReservadas;
    private String[] simbolosPlaceholder;
    private ReglaProduccion[] reglasDeProduccion;
    
    public Gramatica(String produccionInicial, String[] terminales, String[] palabrasReservadas, String[] simbolosPlaceholder, ReglaProduccion[] reglasDeProduccion) {
        this.produccionInicial = produccionInicial;
        this.terminales = terminales;
        this.palabrasReservadas = palabrasReservadas;
        this.simbolosPlaceholder = simbolosPlaceholder;
        this.reglasDeProduccion = reglasDeProduccion;
    }
    public String getProduccionInicial() {
        return produccionInicial;
    }
    public String[] getTerminales() {
        return terminales;
    }
    public String[] getSimbolosPlaceholder() {
        return simbolosPlaceholder;
    }
    public ReglaProduccion[] getReglasDeProduccion() {
        return reglasDeProduccion;
    }
    /**
     * 
     * @param token
     * @param produccionActual
     * @return La produccion para la que el token es el Primero
     */
    public String[] encontrarPrimero(Token token, String produccionActual) {
        ReglaProduccion reglaActual = obtenerProduccion(produccionActual);
        for (String[] produccion : reglaActual.getProducciones()) {
            String primerSimbolo = produccion[0];
            if (esTerminal(primerSimbolo)) {
                if (primerSimbolo.equals(token.tipoToken())||primerSimbolo.equals(token.lexema())) {
                    return produccion;
                }
            } else {
                if (encontrarPrimero(token, primerSimbolo)!=null) {
                    return produccion;
                }
            }
        }
        if (reglaActual.tieneEpsilon()) {
            return new String[]{""};
        }
        return null;
    }
    public ReglaProduccion obtenerProduccion(String produccion) {
        for (ReglaProduccion reglaProduccion : reglasDeProduccion) {
            if (reglaProduccion.getProduccionInicial().equals(produccion)) {
                return reglaProduccion;
            }
        }
        return null;
    }
    public boolean esPalabraReservada(String simbolo) {
        for (String palabra : palabrasReservadas) {
            if (simbolo.equals(palabra)) {
                return true;
            }
        }
        return false;
    }
    public boolean esPlaceholder(String simbolo) {
        for (String termino : simbolosPlaceholder) {
            if (simbolo.equals(termino)) {
                return true;
            }
        }
        return false;
    }
    public boolean esTerminal(String simbolo) {
        for (String terminal : terminales) {
            if (simbolo.equals(terminal)) {
                return true;
            }
        }
        return false;
    }
}
