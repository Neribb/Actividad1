package com.example.calculadora;

public interface ICalculadora {
    double realizarOperacion(double a, double b, Operador op);
    double resolverExpresion(String expresion);
}