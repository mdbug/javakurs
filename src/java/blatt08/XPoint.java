package java.blatt08;

import java.awt.*;

/**
 * Created by micha on 01.12.2016.
 */
public class XPoint extends Point {

    public XPoint(double x, double y) {
        this.setLocation(x, y);
    }

    public void swap(Point p) {
        double tmpX = this.getX();
        double tmpY = this.getY();

        this.setLocation(p.getX(), p.getY());
        p.setLocation(tmpX, tmpY);
    }

    public boolean isOnLine(Point p1, Point p2) {
        double aX = this.getX();
        double aY = this.getY();
        double bX = p1.getX();
        double bY = p1.getY();
        double cX = p2.getX();
        double cY = p2.getY();
        // Testen ob das Volumen des Parallelogramms 0 ist
        double volume =  ( aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY) );
        return (volume > -1E-10 && volume < 1E-10);
    }

    public double getR() {
        return this.distance(0, 0);
    }

    public double getPhi() {
        double phi = Math.atan2(getY(), getX());
        return phi < 0 ? 2*Math.PI + phi : phi;
    }

    public static void main(String[] args) {
        XPoint p1 = new XPoint(-3.0, -3.0);
        XPoint p2 = new XPoint(5.0, 4.0);
        XPoint p3 = new XPoint(7.0, 5.0);

        System.out.println(p1.isOnLine(p2, p3));
        System.out.println(p1.getR());
        System.out.println(p1.getPhi());
    }
}
