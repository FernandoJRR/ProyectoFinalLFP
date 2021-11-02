/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.proyectofinal.analizadorLexico;


/**
 *
 * @author fernanrod
 */
public class Transicion {
    private Character estadoInicial;
    private Character estadoSiguiente;
    private Character[] caracteresTransicion;

    private AccionesEnum[] accionesTransicion;
    
    public Transicion(Character estadoInicial, Character estadoSiguiente, Alfabeto caracteresTransicion, AccionesEnum[] accionesTransicion) {
        this.estadoInicial = estadoInicial;
        this.estadoSiguiente = estadoSiguiente;
        switch (caracteresTransicion) {
          case LETRAS:
            this.caracteresTransicion =  "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".chars().mapToObj(c -> (char)c).toArray(Character[]::new);
            break;
          case DIGITOS:
            this.caracteresTransicion =  "0123456789".chars().mapToObj(c -> (char)c).toArray(Character[]::new);
            break;
          default:
            this.caracteresTransicion = caracteresTransicion.getCaracteres();
            break;
        }
        this.accionesTransicion = accionesTransicion;
    }

    public Transicion(Character estadoInicial, Character estadoSiguiente, Character caracterTransicion, AccionesEnum[] accionesTransicion) {
        this.estadoInicial = estadoInicial;
        this.estadoSiguiente = estadoSiguiente;
        this.caracteresTransicion = new Character[]{caracterTransicion};
        this.accionesTransicion = accionesTransicion;
    }

    public Transicion(Character estadoInicial, Character estadoSiguiente, Character[] caracteresTransicion, AccionesEnum[] accionesTransicion) {
        this.estadoInicial = estadoInicial;
        this.estadoSiguiente = estadoSiguiente;
        this.caracteresTransicion = caracteresTransicion;
        this.accionesTransicion = accionesTransicion;
    }

    public Transicion(Character estadoInicial, Character estadoSiguiente, Alfabeto caracteresTransicion, AccionesEnum accionesTransicion) {
        this.estadoInicial = estadoInicial;
        this.estadoSiguiente = estadoSiguiente;
        switch (caracteresTransicion) {
          case LETRAS:
            this.caracteresTransicion =  "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".chars().mapToObj(c -> (char)c).toArray(Character[]::new);
            break;
          case DIGITOS:
            this.caracteresTransicion =  "0123456789".chars().mapToObj(c -> (char)c).toArray(Character[]::new);
            break;
          default:
            this.caracteresTransicion = caracteresTransicion.getCaracteres();
            break;
        }
        this.accionesTransicion = new AccionesEnum[]{accionesTransicion};
    }

    public Transicion(Character estadoInicial, Character estadoSiguiente, Character caracteresTransicion, AccionesEnum accionesTransicion) {
        this.estadoInicial = estadoInicial;
        this.estadoSiguiente = estadoSiguiente;
        this.caracteresTransicion = new Character[]{caracteresTransicion};
        this.accionesTransicion = new AccionesEnum[]{accionesTransicion};
    }

    public Transicion(Character estadoInicial, Character estadoSiguiente, Character[] caracteresTransicion, AccionesEnum accionesTransicion) {
        this.estadoInicial = estadoInicial;
        this.estadoSiguiente = estadoSiguiente;
        this.caracteresTransicion = caracteresTransicion;
        this.accionesTransicion = new AccionesEnum[]{accionesTransicion};
    }

    public Character getEstadoInicial() {
        return estadoInicial;
    }
    public Character getEstadoSiguiente() {
        return estadoSiguiente;
    }
    public Character[] getCaracteresTransicion() {
        return caracteresTransicion;
    }
    public AccionesEnum[] getAccionesTransicion() {
        return accionesTransicion;
    }
    
    public boolean caracterDeTransicion(Character caracter){
        for (Character simbolo : caracteresTransicion) {
            if (caracter.equals(simbolo)) {
                return true;
            }
        }
        return false;
    }
}

