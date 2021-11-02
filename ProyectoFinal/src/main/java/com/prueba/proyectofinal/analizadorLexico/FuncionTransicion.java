package com.prueba.proyectofinal.analizadorLexico;

public class FuncionTransicion {
    static Character[] estados = {'A','B','C','D','E','F','G','H','I','X'};
    static Character[] estadosAceptacion = {'B','D','E','G','J'};
    
    static Transicion[][] transiciones = {
      {new Transicion('A','B',Alfabeto.DIGITOS,AccionesEnum.AGREGAR),
      new Transicion('A','D',Alfabeto.LETRAS,AccionesEnum.AGREGAR),
      new Transicion('A','H','"',AccionesEnum.AGREGAR),
      new Transicion('A','F','/',AccionesEnum.AGREGAR),
      new Transicion('A','D','_',AccionesEnum.AGREGAR),
      new Transicion('A','C','-',AccionesEnum.AGREGAR),
      new Transicion('A','E',Alfabeto.SIMBOLOS_UNITARIOS,new AccionesEnum[]{AccionesEnum.AGREGAR,AccionesEnum.GUARDAR}),
      new Transicion('A','X',Alfabeto.SIMBOLOS_LITERALES,AccionesEnum.AGREGAR),
      new Transicion('A','A',Alfabeto.ESPECIAL,new AccionesEnum[]{})},

      {new Transicion('B','B',Alfabeto.DIGITOS,AccionesEnum.AGREGAR),
      new Transicion('B','X',Alfabeto.LETRAS,AccionesEnum.AGREGAR),
      new Transicion('B','H','"',new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR}),
      new Transicion('B','F','/',new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR}),
      new Transicion('B','X','_',AccionesEnum.AGREGAR),
      new Transicion('B','X','-',AccionesEnum.AGREGAR),
      new Transicion('B','E',Alfabeto.SIMBOLOS_UNITARIOS,new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR,AccionesEnum.GUARDAR}),
      new Transicion('B','X',Alfabeto.SIMBOLOS_LITERALES,AccionesEnum.AGREGAR),
      new Transicion('B','A',Alfabeto.ESPECIAL,AccionesEnum.GUARDAR)},
      
      {new Transicion('C','B',Alfabeto.DIGITOS,AccionesEnum.AGREGAR),
      new Transicion('C','X',Alfabeto.LETRAS,AccionesEnum.AGREGAR),
      new Transicion('C','H','"',new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR}),
      new Transicion('C','F','/',new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR}),
      new Transicion('C','X','_',AccionesEnum.AGREGAR),
      new Transicion('C','X','-',AccionesEnum.AGREGAR),
      new Transicion('C','E',Alfabeto.SIMBOLOS_UNITARIOS,new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR,AccionesEnum.GUARDAR}),
      new Transicion('C','X',Alfabeto.SIMBOLOS_LITERALES,AccionesEnum.AGREGAR),
      new Transicion('C','A',Alfabeto.ESPECIAL,AccionesEnum.GUARDAR)},

      {new Transicion('D','D',Alfabeto.DIGITOS,AccionesEnum.AGREGAR),
      new Transicion('D','D',Alfabeto.LETRAS,AccionesEnum.AGREGAR),
      new Transicion('D','H','"',new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR}),
      new Transicion('D','F','/',new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR}),
      new Transicion('D','D','_',AccionesEnum.AGREGAR),
      new Transicion('D','D','-',AccionesEnum.AGREGAR),
      new Transicion('D','E',Alfabeto.SIMBOLOS_UNITARIOS,new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR,AccionesEnum.GUARDAR}),
      new Transicion('D','X',Alfabeto.SIMBOLOS_LITERALES,AccionesEnum.AGREGAR),
      new Transicion('D','A',Alfabeto.ESPECIAL,AccionesEnum.GUARDAR)},

      {new Transicion('E','B',Alfabeto.DIGITOS,AccionesEnum.AGREGAR),
      new Transicion('E','D',Alfabeto.LETRAS,AccionesEnum.AGREGAR),
      new Transicion('E','H','"',AccionesEnum.AGREGAR),
      new Transicion('E','F','/',AccionesEnum.AGREGAR),
      new Transicion('E','D','_',AccionesEnum.AGREGAR),
      new Transicion('E','C','-',AccionesEnum.AGREGAR),
      new Transicion('E','E',Alfabeto.SIMBOLOS_UNITARIOS,new AccionesEnum[]{AccionesEnum.AGREGAR,AccionesEnum.GUARDAR}),
      new Transicion('E','X',Alfabeto.SIMBOLOS_LITERALES,AccionesEnum.AGREGAR),
      new Transicion('E','A',Alfabeto.ESPECIAL,new AccionesEnum[]{})},

      {new Transicion('F','X',Alfabeto.DIGITOS,AccionesEnum.AGREGAR),
      new Transicion('F','X',Alfabeto.LETRAS,AccionesEnum.AGREGAR),
      new Transicion('F','X','"',AccionesEnum.AGREGAR),
      new Transicion('F','G','/',AccionesEnum.AGREGAR),
      new Transicion('F','X','_',AccionesEnum.AGREGAR),
      new Transicion('F','X','-',AccionesEnum.AGREGAR),
      new Transicion('F','X',Alfabeto.SIMBOLOS_UNITARIOS,new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR,AccionesEnum.GUARDAR}),
      new Transicion('F','X',Alfabeto.SIMBOLOS_LITERALES,AccionesEnum.AGREGAR),
      new Transicion('F','A',Alfabeto.ESPECIAL,AccionesEnum.GUARDAR)},

      {new Transicion('G','G',Alfabeto.DIGITOS,AccionesEnum.AGREGAR),
      new Transicion('G','G',Alfabeto.LETRAS,AccionesEnum.AGREGAR),
      new Transicion('G','G','"',AccionesEnum.AGREGAR),
      new Transicion('G','G','/',AccionesEnum.AGREGAR),
      new Transicion('G','G','_',AccionesEnum.AGREGAR),
      new Transicion('G','G','-',AccionesEnum.AGREGAR),
      new Transicion('G','G',Alfabeto.SIMBOLOS_UNITARIOS,AccionesEnum.AGREGAR),
      new Transicion('G','X',Alfabeto.SIMBOLOS_LITERALES,AccionesEnum.AGREGAR),
      new Transicion('G','G',new Character[]{'\s','\t','\r','\f'},AccionesEnum.VACIAR),
      new Transicion('G','A','\n',AccionesEnum.VACIAR)},

      {new Transicion('H','I',Alfabeto.DIGITOS,AccionesEnum.AGREGAR),
      new Transicion('H','I',Alfabeto.LETRAS,AccionesEnum.AGREGAR),
      new Transicion('H','I','"',AccionesEnum.AGREGAR),
      new Transicion('H','I','/',AccionesEnum.AGREGAR),
      new Transicion('H','I','_',AccionesEnum.AGREGAR),
      new Transicion('H','I','-',AccionesEnum.AGREGAR),
      new Transicion('H','I',Alfabeto.SIMBOLOS_UNITARIOS,AccionesEnum.AGREGAR),
      new Transicion('H','I',Alfabeto.SIMBOLOS_LITERALES,AccionesEnum.AGREGAR),
      new Transicion('H','I',new Character[]{'\s','\t','\r','\f'},AccionesEnum.GUARDAR),
      new Transicion('H','A','\n',AccionesEnum.GUARDAR)},

      {new Transicion('I','I',Alfabeto.DIGITOS,AccionesEnum.AGREGAR),
      new Transicion('I','I',Alfabeto.LETRAS,AccionesEnum.AGREGAR),
      new Transicion('I','J','"',AccionesEnum.AGREGAR),
      new Transicion('I','I','/',AccionesEnum.AGREGAR),
      new Transicion('I','I','_',AccionesEnum.AGREGAR),
      new Transicion('I','I','-',AccionesEnum.AGREGAR),
      new Transicion('I','I',Alfabeto.SIMBOLOS_UNITARIOS,AccionesEnum.AGREGAR),
      new Transicion('I','I',Alfabeto.SIMBOLOS_LITERALES,AccionesEnum.AGREGAR),
      new Transicion('I','I',new Character[]{'\s','\t','\r','\f'},AccionesEnum.AGREGAR),
      new Transicion('I','A','\n',AccionesEnum.GUARDAR)},

      {new Transicion('J','B',Alfabeto.DIGITOS,new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR}),
      new Transicion('J','D',Alfabeto.LETRAS,new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR}),
      new Transicion('J','H','"',new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR}),
      new Transicion('J','F','/',new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR}),
      new Transicion('J','D','_',new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR}),
      new Transicion('J','C','-',new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR}),
      new Transicion('J','E',Alfabeto.SIMBOLOS_UNITARIOS,new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR,AccionesEnum.GUARDAR}),
      new Transicion('J','X',Alfabeto.SIMBOLOS_LITERALES,new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR}),
      new Transicion('J','A',Alfabeto.ESPECIAL,AccionesEnum.GUARDAR)},

      {new Transicion('X','X',Alfabeto.DIGITOS,AccionesEnum.AGREGAR),
      new Transicion('X','X',Alfabeto.LETRAS,AccionesEnum.AGREGAR),
      new Transicion('X','H','"',new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR}),
      new Transicion('X','F','/',new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR}),
      new Transicion('X','X','_',AccionesEnum.AGREGAR),
      new Transicion('X','X','-',AccionesEnum.AGREGAR),
      new Transicion('X','E',Alfabeto.SIMBOLOS_UNITARIOS,new AccionesEnum[]{AccionesEnum.GUARDAR,AccionesEnum.AGREGAR,AccionesEnum.GUARDAR}),
      new Transicion('X','X',Alfabeto.SIMBOLOS_LITERALES,AccionesEnum.AGREGAR),
      new Transicion('X','A',Alfabeto.ESPECIAL,AccionesEnum.GUARDAR)},
    };

    static Character estadoInicial = 'A';
    
    public static String getTipoToken(Transicion transicion, char caracter){
      if (esDeAlfabeto(caracter, Alfabeto.SIMBOLOS_UNITARIOS.getCaracteres())) {
        return String.valueOf(caracter);
      } else if(estadoAceptacion(transicion.getEstadoInicial())){
        switch (transicion.getEstadoInicial()) {
          case 'A':
            break;
          case 'B':
            return "ENTERO";
          case 'D':
            return "IDENTIFICADOR";
          case 'G':
            return "COMENTARIO";
          case 'J':
            return "LITERAL";
          default:
            return "ERROR";
        }
      } else {
        return "ERROR";
      }
      return "ERROR";
    }

    public static boolean esDeAlfabeto(char caracter, Character[] alfabeto){
        for (Character simbolo : alfabeto) {
            if (simbolo.equals(caracter)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean estadoAceptacion(char estadoActual){
        for (char estado : estadosAceptacion) {
            if (estado == estadoActual) {
                return true;
            }
        }
        return false;
    }
}



