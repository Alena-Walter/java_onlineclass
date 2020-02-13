package ru.java.sandbox;

import distance.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTest {

    @Test
    public void testDistance(){
        Point p = new Point(2,6,4,8);
        Assert.assertEquals(p.distance(), 6);
    }
}
