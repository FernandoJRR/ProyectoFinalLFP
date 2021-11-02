/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.proyectofinal.modeloAnalisis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.prueba.proyectofinal.analizadorLexico.Token;
import com.prueba.proyectofinal.analizadorLexico.Tokenizador;
import com.prueba.proyectofinal.analizadorSintactico.Arbol;
import com.prueba.proyectofinal.analizadorSintactico.AutomataPila;
import com.prueba.proyectofinal.analizadorSintactico.ParsingException;
import com.prueba.proyectofinal.interprete.Interprete;
import com.prueba.proyectofinal.interprete.LoopBoundInvalidoException;
import com.prueba.proyectofinal.interprete.SimboloNoEncontradoException;

/**
 *
 * @author fernanrod
 */
public class ModelAnalizador {
    private static ArrayList<Token> tokens = new ArrayList<>();
    private static Arbol arbolSintactico;
    
    private static boolean analisisLexicoRealizado = false;
    private static boolean erroresLexicos = false;
    private static boolean cambioTexto = false;
    
    private static String pathArchivoActual = null;
    
    public static ArrayList<Token> getTokens() {
        return tokens;
    }
    public static ArrayList<Token> getTokensError() {
        ArrayList<Token> tokensError = new ArrayList<>();
        for (Token token : tokens) {
            if (token.tipoToken().equals("ERROR")) {
                tokensError.add(token);
            }
        }
        return tokensError;
    }
    public static void setTokens(ArrayList<Token> tokens) {
        ModelAnalizador.tokens = tokens;
    }
    public static void tokenizar(String statement) {
        ModelAnalizador.tokens = Tokenizador.tokenizar(statement);
        comprobarErroresLexicos();
    }
    
    public static void comprobarErroresLexicos() {
        erroresLexicos = false;
        for (Token token : tokens) {
            if (token.tipoToken().equals("ERROR")) {
                erroresLexicos = true;
                break;
            }
        }
    }
    
    public static boolean getErroresLexicos() {
        return ModelAnalizador.erroresLexicos;
    }

    public static void setSizeTabulador(int tabulador) {
        Tokenizador.setSizeTabulador(tabulador);
    }
    
    public static ArrayList<String> parse() {
        try {
            arbolSintactico = AutomataPila.parse(tokens);
            return arbolSintactico.getNodoInicial().recorrerHijos(0);
        } catch (ParsingException e) {
            ArrayList<String> textoConError = AutomataPila.getArbolSintactico().getNodoInicial().recorrerHijos(0);
            textoConError.add(e.getMessage());
            textoConError.add("");
            return textoConError;
        }
    }
    
    public static void interpretar() throws SimboloNoEncontradoException, LoopBoundInvalidoException {
        Interprete.reset();
        Interprete.interpretar(arbolSintactico.getNodoInicial());
    }
    
    public static void guardar(String texto) throws IOException {
        String str = texto;
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathArchivoActual));
        writer.write(str);
        
        writer.close();
    }
    
    public static void guardarComo(String texto, String archivo) throws IOException {
        String str = texto;
        BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
        writer.write(str);
        
        writer.close();
    }
    
    public static ArrayList<String> abrir(File archivo) throws IOException {
        ArrayList<String> lineas = new ArrayList<>();

        File file = archivo;
 
        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)
 
        // Creating an object of BuffferedReader class
        BufferedReader br = new BufferedReader(new FileReader(file));
 
        // Declaring a string variable
        String st;
        // Consition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null) {
            lineas.add(st);
        }
        
        pathArchivoActual = file.getPath();

        return lineas;
    }
    
    public static void setErroresLexicos(boolean erroresLexicos) {
        ModelAnalizador.erroresLexicos = erroresLexicos;
    }
    public static void setAnalisisLexicoRealizado(boolean analisisLexicoRealizado) {
        ModelAnalizador.analisisLexicoRealizado = analisisLexicoRealizado;
    }
    public static boolean getAnalisisLexicoRealizado() {
        return ModelAnalizador.analisisLexicoRealizado;
    }
    public static void setCambioTexto(boolean cambioTexto) {
        ModelAnalizador.cambioTexto = cambioTexto;
    }
    public static boolean getCambioTexto() {
        return ModelAnalizador.cambioTexto;
    }
}
