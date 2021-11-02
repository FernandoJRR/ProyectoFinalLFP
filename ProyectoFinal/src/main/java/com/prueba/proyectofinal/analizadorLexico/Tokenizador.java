package com.prueba.proyectofinal.analizadorLexico;

import java.util.ArrayList;
import java.util.HashMap;

public class Tokenizador {
    private static ArrayList<Token> tokens = new ArrayList<>();
    private static String bufferTokenActual = "";
    private static int[] posicion = new int[2];
    private static int sizeTabulador = 0;
    private static char estadoActual = FuncionTransicion.estadoInicial;
    private static char caracterActual;

    public static ArrayList<Token> tokenizar(String statement){
        statement += "\n";
        char[] arrayStatement = statement.toCharArray();
        tokens = new ArrayList<>();
        bufferTokenActual = "";
        posicion[0] = 1; //Posicion Fila
        posicion[1] = 0; //Posicion Columna
        for (int i = 0; i < arrayStatement.length; i++) {
            caracterActual = arrayStatement[i];
            cambiarEstado();
            if (arrayStatement[i]=='\t') {
              posicion[1] += sizeTabulador;
            } else if (arrayStatement[i]=='\n' && i != arrayStatement.length-1) {
              posicion[0]++;
              posicion[1]=0;
            } else {
              posicion[1]++;
            }
        }
        return tokens;
    }
    
    public static void setSizeTabulador(int sizeTabulador) {
        Tokenizador.sizeTabulador = sizeTabulador;
    }

    public static HashMap<String, Integer> recuentoTokens(ArrayList<Token> tokens){
        HashMap<String, Integer> recuento = new HashMap<>();
        
        for (Token token : tokens) {
            
            //Si el lexema ya existe se aumentara en uno la cantidad de dicho lexema caso contrario se agregara con valor 1
            if (recuento.containsKey(token.lexema())) {
                recuento.put(token.lexema(), recuento.get(token.lexema())+1);
            } else {
                recuento.put(token.lexema(), 1);
            }
        }
        
        return recuento;
    }

    public static void cambiarEstado() {
        Transicion[][] transiciones = FuncionTransicion.transiciones;
        Transicion transicion = null;
        for(int i=0; i < transiciones.length; i++){
          for(int j=0; j < transiciones[i].length; j++){
            //Comprobamos si el estado de la transicion es igual a nuestro estado actual
            if(transiciones[i][j].getEstadoInicial().equals(estadoActual)){
              //Comprobamos si el caracter para transicionar al siguiente estado es igual a nuestro caracter actual 
              if(transiciones[i][j].caracterDeTransicion(caracterActual)){
                transicion = transiciones[i][j];
                break;
              }
            }
          }
        }
        if(transicion == null){
          bufferTokenActual += caracterActual;
          estadoActual = 'X';
        } else {
          accionesTransicion(transicion, caracterActual);
          estadoActual = transicion.getEstadoSiguiente();
        }
    }

    public static void accionesTransicion(Transicion transicionActual, Character caracterActual){
        AccionesEnum[] acciones = transicionActual.getAccionesTransicion();

        for(AccionesEnum accion: acciones){
            switch (accion) {
              case GUARDAR:
                String tipoToken = FuncionTransicion.getTipoToken(transicionActual, bufferTokenActual.charAt(bufferTokenActual.length()-1));
                String lexema = bufferTokenActual;
                tokens.add(new Token(tipoToken,lexema,new int[]{posicion[0],posicion[1]}));
                bufferTokenActual = "";
                break;
              case AGREGAR:
                bufferTokenActual += caracterActual;
                break;
              case VACIAR:
                bufferTokenActual = "";
                break;
            }
        }
    }
}
