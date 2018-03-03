package ru.stqa.pft.sandbox;

public class Distance {

    public static void main(String[] args) {
        Point p1 = new Point(2, 4);
        Point p2 = new Point(5, 10);

        System.out.println("Distance between points (" + p1.x + "; " + p1.y + ") and (" + p2.x + "; " + p2.y + ") is: " + distance(p1, p2));
        System.out.println("Distance between points (" + p1.x + "; " + p1.y + ") and (" + p2.x + "; " + p2.y + ") is: " + p1.distance(p2));
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }
}
