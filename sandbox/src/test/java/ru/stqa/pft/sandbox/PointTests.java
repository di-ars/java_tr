package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistanceToMyself() {
        Point p = new Point(10.0, 10.0);
        Assert.assertEquals(p.distance(p), 0.0, "Unexpected distance to the same point: ");
    }

    @Test
    public void testDistanceToPoint() {
        Point p1 = new Point(-1.0, -1.0);
        Point p2 = new Point(2.0, -5.0);
        Assert.assertEquals(p1.distance(p2), 5.0, "Unexpected distance from point " + getPointCoordsInLine(p1) + " to point " + getPointCoordsInLine(p2) + ":");
    }

    @Test
    public void testDistanceToZeroPoint() {
        Point p1 = new Point(3.0, 4.0);
        Point p2 = new Point(0.0, 0.0);
        Assert.assertEquals(p1.distance(p2), 5.0, "Unexpected distance from point " + getPointCoordsInLine(p1) + " to point " + getPointCoordsInLine(p2) + ":");
    }

    private String getPointCoordsInLine(Point p) {
        return "(" + p.x + "; " + p.y + ")";
    }
}
