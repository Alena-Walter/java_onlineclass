package Selenium.java.sandbox;

public class myFirstProgram {
    public static void main(String[] args) {
        hello("Lena");
        hello("User");

        double l = 5.0;
        System.out.println("square area with side " + l + " = " + area(l));

        double a = 4;
        double b = 5;
        System.out.println("rectangle area with sides " +a+ " and " +b+ " = " + area(a,b));
    }


   public static void hello(String somebody) {
        System.out.println("Hello " + somebody);
    }

    public static double area (double len) {
        return len * len;
    }

    public static double area (double a, double b) {
        return a*b;
        }



}