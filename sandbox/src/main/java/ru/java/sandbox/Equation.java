package ru.java.sandbox;

public class Equation {

    private double a;
    private double b;
    private double c;

    //Attribute for number of solution (0, 1 or 2)
    private int n;

    //Create constructor with 3 parameters
    public Equation (double a, double b, double c) {

        //assign parameters to the same fields
        this.a = a;
        this.b = b;
        this.c = c;

        //Formula of discriminant
        double d = b * b - 4 * a * c;


        //Validate conditions
        if (d > 0) {
            n = 2;
        } else {
            if (d == 0) {
                n = 1;
            } else {
                n = 0;
            }
        }
    }
    //Method for getting attribute value
    public int rootNumber() {
        return n;
    }
}
