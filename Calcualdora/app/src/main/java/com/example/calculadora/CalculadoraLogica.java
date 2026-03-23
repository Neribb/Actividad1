package com.example.calcualdora;
import java.util.Stack;

public class CalculadoraLogica implements ICalculadora {

    @Override
    public double realizarOperacion(double a, double b, Operador op) {
        switch (op) {
            case SUMA: return a + b;
            case RESTA: return a - b;
            case MULTIPLICACION: return a * b;
            case DIVISION: return b != 0 ? a / b : 0;
            default: return 0;
        }
    }

    @Override
    public double resolverExpresion(String expresion) {
        Stack<Double> valores = new Stack<>();
        Stack<Operador> operadores = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < expresion.length() && (Character.isDigit(expresion.charAt(i)) || expresion.charAt(i) == '.')) {
                    sb.append(expresion.charAt(i++));
                }
                valores.push(Double.parseDouble(sb.toString()));
                i--;
            } else {
                Operador opActual = (c == '+') ? Operador.SUMA : (c == '-') ? Operador.RESTA :
                        (c == '*') ? Operador.MULTIPLICACION : Operador.DIVISION;

                while (!operadores.isEmpty() && operadores.peek().getJerarquia() >= opActual.getJerarquia()) {
                    double b = valores.pop();
                    double a = valores.pop();
                    valores.push(realizarOperacion(a, b, operadores.pop()));
                }
                operadores.push(opActual);
            }
        }
        while (!operadores.isEmpty()) {
            double b = valores.pop();
            double a = valores.pop();
            valores.push(realizarOperacion(a, b, operadores.pop()));
        }
        return valores.pop();
    }
}