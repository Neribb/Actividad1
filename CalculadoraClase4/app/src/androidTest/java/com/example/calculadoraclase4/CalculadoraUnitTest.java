package com.example.calculadoraclase4;

import org.junit.Assert;
import org.junit.Test;

public class CalculadoraUnitTest {
    @Test
    public void testOperacionesSuma(){

        ICalculadora calculadora = new Calculadora();
        Double resultado = calculadora.suma(5, 5);
        Assert.assertEquals(10,resultado,0);
    }

}
