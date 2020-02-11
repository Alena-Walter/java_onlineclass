package ru.java.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        hello("Lena");
        hello("User");
        hello("Andreas");

        Square s = new Square();
        s.l = 5.0;
        System.out.println("square area with side " + s.l + " = " + area(s));

        Rectangle r = new Rectangle();
        r.a = 4;
        r.b = 6;
        System.out.println("rectangle area with sides " +r.a+ " and " +r.b+ " = " + area(r));
    }


   public static void hello(String somebody) {
        System.out.println("Hello " + somebody);
    }

    public static double area (Square s) {
        return s.l * s.l;
    }

    public static double area (Rectangle r) {
        return r.a*r.b;
        }



}