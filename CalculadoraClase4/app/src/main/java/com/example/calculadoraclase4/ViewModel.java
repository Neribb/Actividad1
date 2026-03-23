package com.example.calculadoraclase4;

public class ViewModel {


    ICalculadora calculadora = new Calculadora();
    ViewModel(){

    }
    Double suma(double x, double y){
        return calculadora.suma(x, y);
    }

    Double resta(double x, double y){
        return calculadora.resta(x, y);
    }

    Double multiplicacion(double x, double y){
        return calculadora.multiplicacion(x, y);
    }

    Double division(double x, double y){
        return calculadora.division(x, y);
    }

}
