package com.example.calcualdora;

public enum Operador {
    SUMA("+",1),
    RESTA("-", 1),
    MULTIPLICACION("*",2),
    DIVISON("/", 2);

    private final String simbolo;
    private final  int jerarquia;

    Operador(String simbolo, int jerarquia){
        this.simbolo = simbolo;
        this.jerarquia = jerarquia;
    }

    public int getJerarquia(){
        return jerarquia;
    }
    public String getSimbolo(){
        return simbolo;
    }
}
