package com.prueba.proyectofinal.analizadorLexico;

public enum Alfabeto {
    LETRAS,
    DIGITOS,
    SIMBOLOS_UNITARIOS(new Character[]{'+','*','=','(',')'}),
    SIMBOLOS_LITERALES(new Character[]{'<', '>', '\'', ':', ',', ';', '/'}),
    ESPECIAL(new Character[]{'\n','\r','\t','\f','\s'});
        
    private final Character[] caracteres;
    
    private Alfabeto(){
        this.caracteres = new Character[]{' '};
    }
    private Alfabeto(Character[] caracteres){
        this.caracteres = caracteres;
    }
    
    public Character[] getCaracteres() {
        return caracteres;
    }
}
