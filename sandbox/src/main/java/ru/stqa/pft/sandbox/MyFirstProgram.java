package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        System.out.println("Hello");

        Square s = new Square(5);
        System.out.println("Area of square with side length equal to " + s.l + " is: " + s.area());

        Rectangle r = new Rectangle(5, 6);
        System.out.println("Area of rectangle with side lengths equal to " + r.a + " and " + r.b + " is: " + r.area());
    }


}