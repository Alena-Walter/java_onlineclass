package distance;

import java.lang.Math;
public class DistanceTwoPoints {
    public static void main(String arg[]) {
        int x1,x2,y1,y2;
        double d;
        x1=2;
        x2=6;
        y1=4;
        y2=8;
        d = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        System.out.println(d);
    }
}
