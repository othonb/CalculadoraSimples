package com.othonbatista.calculadora;

/**
 * Created by admin on 07/04/17.
 */

public class CalculadoraCerebro {

    private double operando1;
    private double operando2;

    public CalculadoraCerebro (double operando1, double operando2) {
        this.operando1 = operando1;
        this.operando2 = operando2;
    }

    public double getOperando1() {
        return operando1;
    }

    public void setOperando1(double operando1) {
        this.operando1 = operando1;
    }

    public double getOperando2() {
        return operando2;
    }

    public void setOperando2(double operando2) {
        this.operando2 = operando2;
    }

    public double executaOperacao (char tipoOperacao) {

        double resultado = 0.0;

        switch (tipoOperacao) {
            case '+' :
                resultado = operando1 + operando2;
                break;
            case '-' :
                resultado = operando1 - operando2;
                break;
            case '*' :
                resultado = operando1 * operando2;
                break;
            case '/' :
                resultado = operando1 / operando2;
                break;
        }

        return resultado;
    }

}
