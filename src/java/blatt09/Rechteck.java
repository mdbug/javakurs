package java.blatt09;

import java.awt.Point;

/**
 * Created by micha on 08.12.2016.
 */
public class Rechteck extends Figur {
    private Point mittelpunkt;

    public Rechteck(Point p1, Point p2) {
        Point p3 = new Point();
        p3.setLocation(p1.getX(), p2.getY());
        Point p4 = new Point();
        p4.setLocation(p2.getX(), p1.getY());
        punkte.add(p1);
        punkte.add(p3);
        punkte.add(p2);
        punkte.add(p4);
        punkte.add(p1);
        mittelpunkt = new Point();
        mittelpunkt.setLocation((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
    }

    public Rechteck(Rechteck r) {
        for (int i = 0; i < 4; ++i) {
            this.punkte.add(new Point(r.punkte.get(i)));
        }
        this.punkte.add(punkte.get(0));

        mittelpunkt = new Point();
        Point p1 = punkte.get(0);
        Point p2 = punkte.get(2);
        mittelpunkt.setLocation((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2);
    }

    public void skaliere(double d) {
        for (int i = 0; i < 4; ++i) {
            Point p = punkte.get(i);
            p.translate((int)((mittelpunkt.getX() - p.getX()) * d),
                                    (int)((mittelpunkt.getY() - p.getY()) * d));
        }
    }

    public Rechteck vereinige(Rechteck r) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i = 0; i < 4; ++i) {
            Point p1 = r.punkte.get(i);
            Point p2 = this.punkte.get(i);
            int p1x = (int) p1.getX();
            int p1y = (int) p1.getY();
            int p2x = (int) p2.getX();
            int p2y = (int) p2.getY();
            minX = Math.min(p1x, minX);
            minX = Math.min(p2x, minX);
            maxX = Math.max(p1x, maxX);
            maxX = Math.max(p2x, maxX);
            minY = Math.min(p1y, minY);
            minY = Math.min(p2y, minY);
            maxY = Math.max(p1y, maxY);
            maxY = Math.max(p2y, maxY);
        }

        return new Rechteck(new Point(minX, minY), new Point(maxX, maxY));
    }

}
