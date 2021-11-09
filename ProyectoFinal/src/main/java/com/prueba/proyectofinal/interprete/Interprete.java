/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.proyectofinal.interprete;

import java.util.ArrayList;
import java.util.HashMap;

import com.prueba.proyectofinal.analizadorSintactico.Nodo;

/**
 *
 * @author fernanrod
 */
public class Interprete {
    private static HashMap<String, Integer> tablaSimbolos = new HashMap<>(); //Guarda variables en pares Identificador-Valor
    private static ArrayList<String> outputString = new ArrayList<>();
    
    public static ArrayList<String> getOutputString() {
        return outputString;
    }

    public static Object interpretar(Nodo nodoInicial) throws SimboloNoEncontradoException, LoopBoundInvalidoException {
        switch (nodoInicial.getInformacion()) {
            case "ESTRUCTURA":
                if (!nodoInicial.getNodo(0).getInformacion().equals("e")) {
                    interpretar(nodoInicial.getNodo(0));
                    interpretar(nodoInicial.getNodo(1));
                }
                break;
            case "ESCRITURA":
                Nodo nodoDato = nodoInicial.getNodo(1).getNodo(0);
                String tipoDato = nodoDato.getInformacion();
                switch (tipoDato) {
                    case "LITERAL":
                        String literal = nodoDato.getNodo(0).getInformacion();
                        outputString.add(literal.substring(1, literal.length()-1));
                        break;
                    case "ENTERO":
                        outputString.add(nodoDato.getNodo(0).getInformacion());
                        break;
                    case "IDENTIFICADOR":
                        try {
                            String valorIdentificador = tablaSimbolos.get(nodoDato.getNodo(0).getInformacion()).toString();
                            outputString.add(valorIdentificador);
                        } catch (NullPointerException e) {
                            throw new SimboloNoEncontradoException("Error, la variable: \'"+nodoDato.getNodo(0).getInformacion()+"\' no ha sido inicializada");
                        }
                }
                break;
            case "E_REPETIR":
                Nodo nodoInformacion = nodoInicial.getNodo(1);
                Integer repeticiones = 0;
                String tipoRepeticiones = nodoInformacion.getNodo(0).getInformacion();
                switch (tipoRepeticiones) {
                    case "ENTERO":
                        repeticiones = Integer.parseInt(nodoInformacion.getNodo(0).getNodo(0).getInformacion());
                        if (repeticiones <= 0) {
                            throw new LoopBoundInvalidoException();
                        }
                        break;
                    case "IDENTIFICADOR":
                        try {
                            String valorIdentificador = tablaSimbolos.get(nodoInformacion.getNodo(0).getNodo(0).toString()).toString();
                            repeticiones = Integer.valueOf(valorIdentificador);
                            if (repeticiones <= 0) {
                                throw new LoopBoundInvalidoException();
                            }
                        } catch (NullPointerException e) {
                            throw new SimboloNoEncontradoException("Error, la variable: \'"+nodoInformacion.getNodo(0).getNodo(0).getInformacion()+"\' no ha sido inicializada");
                        }
                        break;
                }
                for (int i = 0; i < repeticiones; i++) {
                    interpretar(nodoInformacion.getNodo(2));
                }
                break;
            case "CONDICIONAL":
                Nodo nodoCondiciones = nodoInicial.getNodo(1);
                String booleano = nodoCondiciones.getNodo(0).getInformacion();
                if (booleano.equals("VERDADERO")) {
                    Nodo nodoAccion = nodoCondiciones.getNodo(2);
                    if (!nodoAccion.getNodo(0).getInformacion().equals("e")) {
                        interpretar(nodoAccion.getNodo(0));
                    }
                }
                break;
            case "E_MATEMATICA":
                String nombreVariable = null;
                Integer datoVariable = null;
                if (nodoInicial.getNodo(0).getInformacion().equals("IDENTIFICADOR")) {
                    Nodo nodoMatematica = nodoInicial.getNodo(1);
                    if (nodoMatematica.getNodo(0).getInformacion().equals("=")) {
                        Nodo nodoVariable = nodoInicial.getNodo(0);
                        nombreVariable = nodoVariable.getNodo(0).getInformacion();
                        datoVariable = (Integer) interpretar(nodoMatematica.getNodo(1));
                        
                        tablaSimbolos.put(nombreVariable, datoVariable);
                    }
                }
                break;

            case "RDD":
                if (!nodoInicial.getNodo(0).getInformacion().equals("e")) {
                    interpretar(nodoInicial.getNodo(0));
                    interpretar(nodoInicial.getNodo(1));
                }
                break;
            case "EXPRESION":
                if (!nodoInicial.getNodo(1).getNodo(0).getInformacion().equals("e")) {
                    return (Integer) interpretar(nodoInicial.getNodo(0)) + (Integer) interpretar(nodoInicial.getNodo(1));
                } else {
                    return (Integer) interpretar(nodoInicial.getNodo(0));
                }
            case "EXPRESIOND":
                return (Integer) interpretar(nodoInicial.getNodo(1));
            case "MEDIO":
                if (!nodoInicial.getNodo(1).getNodo(0).getInformacion().equals("e")) {
                    return (Integer) interpretar(nodoInicial.getNodo(0)) * (Integer) interpretar(nodoInicial.getNodo(1));
                } else {
                    return (Integer) interpretar(nodoInicial.getNodo(0));
                }
            case "MEDIOD":
                return (Integer) interpretar(nodoInicial.getNodo(1));
            case "TERMINO":
                String tipoTermino = nodoInicial.getNodo(0).getInformacion();
                switch (tipoTermino) {
                    case "IDENTIFICADOR":
                        try {
                            String valorIdentificador = tablaSimbolos.get(nodoInicial.getNodo(0).getNodo(0).getInformacion()).toString();
                            return Integer.valueOf(valorIdentificador);
                        } catch (NullPointerException e) {
                            throw new SimboloNoEncontradoException("Error, la variable: \'"+nodoInicial.getNodo(0).getNodo(0).getInformacion()+"\' no ha sido inicializada");
                        }
                    case "ENTERO":
                        return Integer.valueOf(nodoInicial.getNodo(0).getNodo(0).getInformacion());
                    case "(":
                        return (Integer) interpretar(nodoInicial.getNodo(1));
                        
                    default:
                        break;
                }
                break;

            default:
                break;
        }
        return null;
    }
    
    public static void reset() {
        tablaSimbolos = new HashMap<>();
        outputString = new ArrayList<>();
    }
}
