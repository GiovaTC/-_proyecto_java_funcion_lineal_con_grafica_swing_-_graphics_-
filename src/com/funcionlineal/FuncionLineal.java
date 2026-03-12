package com.funcionlineal;

public class FuncionLineal {

    private double a;
    private double b;

    public FuncionLineal(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double calcular(double x) {
        return a * x + b;
    }
}
