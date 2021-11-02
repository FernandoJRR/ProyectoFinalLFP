/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.proyectofinal.analizadorSintactico;

import java.util.ArrayList;
import java.util.Stack;

import com.prueba.proyectofinal.analizadorLexico.Token;

/**
 *
 * @author fernanrod
 */
public class AutomataPila {
    private static Stack<String> pila;
    private static Stack<Nodo> pilaRecorrido;
    private static Arbol arbolSintactico;
    private static Nodo nodoActual;
    private static Token tokenActual;
    
    public static Arbol parse(ArrayList<Token> tokens) throws ParsingException {
        tokens.add(new Token("", "", tokens.get(tokens.size()-1).posicion())); //Se agrega el token de terminacion del programa $
        AutomataPila.arbolSintactico = new Arbol(new Nodo(gramatica.getProduccionInicial()));
        AutomataPila.pila = new Stack<>();
        AutomataPila.pilaRecorrido = new Stack<>();
        AutomataPila.pila.push(gramatica.getProduccionInicial());
        AutomataPila.nodoActual = arbolSintactico.getNodoInicial();
        AutomataPila.pilaRecorrido.push(nodoActual);
        AutomataPila.tokenActual = tokens.remove(0);

        while (!pila.empty()) {
            if (gramatica.esTerminal(pila.peek())) {
                if (pila.peek().equals(tokenActual.tipoToken())||pila.peek().equals(tokenActual.lexema())) {
                    reduce();
                    AutomataPila.tokenActual = tokens.remove(0);
                } else {
                    throw new ParsingException("Error Sintactico en "+tokenActual.posicion()[0]+":"+tokenActual.posicion()[1]+":"+
                                               "Token esperado \'"+pila.peek()+"\', token obtenido \'"+tokenActual.lexema()+"\'");
                }
            } else {
                String[] produccionPrimera = AutomataPila.gramatica.encontrarPrimero(tokenActual, pila.peek());
                if (produccionPrimera!=null) {
                    shift(produccionPrimera);
                } else {
                    throw new ParsingException("Error Sintactico en "+tokenActual.posicion()[0]+":"+tokenActual.posicion()[1]+":"+
                                               "Token esperado \'"+pila.peek()+"\', token obtenido \'"+tokenActual.lexema()+"\'");
                }
            }
        }
        
        return AutomataPila.arbolSintactico;
    }
    
    public static void shift(String[] producciones) {
        if (producciones[0].equals("")) { //Se comprueba si la produccion es epsilon
            AutomataPila.nodoActual.add(new Nodo("e"));
            AutomataPila.pila.pop();
            AutomataPila.pilaRecorrido.pop();
        } else {
            AutomataPila.pila.pop();
            AutomataPila.pilaRecorrido.pop();
            for (int i = producciones.length-1; i >= 0; i--) {
                Nodo nodoProduccion = new Nodo(producciones[i]);
                AutomataPila.pila.push(producciones[i]);
                AutomataPila.pilaRecorrido.push(nodoProduccion);
            }
            for (int i = 0; i < producciones.length; i++) {
                Nodo nodoProduccion = AutomataPila.pilaRecorrido.elementAt(pilaRecorrido.size()-1-i);
                AutomataPila.nodoActual.add(nodoProduccion);
            }
        }
        if (!AutomataPila.pilaRecorrido.empty()) {
            AutomataPila.nodoActual = AutomataPila.pilaRecorrido.peek();
        }
    }
    
    public static void reduce() {
        //Si el lexema NO es palabra reservada y es contenedor de mas informacion se agregara un nodo hoja con la informacion
        if (!AutomataPila.gramatica.esPalabraReservada(tokenActual.lexema())&&AutomataPila.gramatica.esPlaceholder(tokenActual.tipoToken())) {
            AutomataPila.nodoActual.add(new Nodo(AutomataPila.tokenActual.lexema()));
        } 
        AutomataPila.pila.pop();
        AutomataPila.pilaRecorrido.pop();
        AutomataPila.nodoActual = AutomataPila.pilaRecorrido.peek();
    }
    
    public final static Gramatica gramatica =
    new Gramatica(
        //Se declara la produccion inicial
        "ESTRUCTURA",
        //Se declaran los terminales 
        new String[]{"IDENTIFICADOR","ENTERO","LITERAL","(",")","=","+","*","FIN","ESCRIBIR","REPETIR","INICIAR","SI","VERDADERO","FALSO","ENTONCES",""}, 
        //Se declaran las palabras reservadas
        new String[]{"FIN","ESCRIBIR","REPETIR","INICIAR","SI","VERDADERO","FALSO","ENTONCES"},
        //Se declaran los placeholder
        new String[]{"IDENTIFICADOR","ENTERO","LITERAL"},
        new ReglaProduccion[]{
            new ReglaProduccion(
                "ESTRUCTURA", 
                new String[][]{
                    {"ESCRITURA","ESTRUCTURA"},
                    {"E_REPETIR", "ESTRUCTURA"},
                    {"CONDICIONAL", "ESTRUCTURA"},
                    {"E_MATEMATICA", "ESTRUCTURA"},
                    {""}
                }
            ),
            new ReglaProduccion(
                "ESCRITURA",
                new String[][]{
                    {"ESCRIBIR", "ED","FIN"}
                } 
            ),
            new ReglaProduccion(
                "ED", 
                new String[][]{
                    {"LITERAL"},
                    {"ENTERO"},
                    {"IDENTIFICADOR"}
                }
            ),
            new ReglaProduccion(
                "E_REPETIR", 
                new String[][]{
                    {"REPETIR","RD","FIN"}
                }
            ),
            new ReglaProduccion(
                "RD", 
                new String[][]{
                    {"ENTERO","INICIAR","RDD"},
                    {"IDENTIFICADOR","INICIAR","RDD"}
                }
            ),
            new ReglaProduccion(
                "RDD", 
                new String[][]{
                    {"ESCRITURA","RDD"},
                    {""}
                }
            ),
            new ReglaProduccion(
                "CONDICIONAL", 
                new String[][]{
                    {"SI","CD","FIN"}
                }
            ),
            new ReglaProduccion(
                "CD", 
                new String[][]{
                    {"VERDADERO","ENTONCES","CDD"},
                    {"FALSO","ENTONCES","CDD"},
                }
            ),
            new ReglaProduccion(
                "CDD", 
                new String[][]{
                    {"ESCRITURA"},
                    {""}
                }
            ),
            new ReglaProduccion(
                "E_MATEMATICA", 
                new String[][]{
                    {"IDENTIFICADOR","PARTE","FIN"},
                    {"EXPRESION_I","FIN"}
                }
            ),
            new ReglaProduccion(
                "PARTE", 
                new String[][]{
                    {"=","EXPRESION"},
                    {"+","EXPRESION"},
                    {"*","EXPRESION"},
                }
            ),
            new ReglaProduccion(
                "ASIGNACION", 
                new String[][]{
                    {"EXPRESION"},
                }
            ),
            new ReglaProduccion(
                "EXPRESION", 
                new String[][]{
                    {"MEDIO","EXPRESIOND"},
                }
            ),
            new ReglaProduccion(
                "EXPRESIOND", 
                new String[][]{
                    {"+","MEDIO"},
                    {""}
                }
            ),
            new ReglaProduccion(
                "MEDIO", 
                new String[][]{
                    {"TERMINO","MEDIOD"},
                    {""}
                }
            ),
            new ReglaProduccion(
                "MEDIOD", 
                new String[][]{
                    {"*","TERMINO"},
                    {""}
                }
            ),
            new ReglaProduccion(
                "TERMINO", 
                new String[][]{
                    {"IDENTIFICADOR"},
                    {"ENTERO"},
                    {"(","EXPRESION",")"}
                }
            ),
            new ReglaProduccion(
                "EXPRESION_I", 
                new String[][]{
                    {"MEDIO_I","EXPRESION_ID"}
                }
            ),
            new ReglaProduccion(
                "EXPRESION_ID", 
                new String[][]{
                    {"+","MEDIO_I"},
                    {""}
                }
            ),
            new ReglaProduccion(
                "MEDIO_I", 
                new String[][]{
                    {"TERMINO_I","MEDIO_ID"}
                }
            ),
            new ReglaProduccion(
                "MEDIO_ID", 
                new String[][]{
                    {"*","TERMINO_I"},
                    {""}
                }
            ),
            new ReglaProduccion(
                "TERMINO_I", 
                new String[][]{
                    {"ENTERO"},
                    {"(","EXPRESION",")"}
                }
            ),
        }
    );
    
    public static Arbol getArbolSintactico() {
        return arbolSintactico;
    }
}
