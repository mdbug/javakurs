package blatt09;

import java.awt.Point;

//Linie zwischen zwei Punkte
public class Linie extends Figur {
	public Linie(Point x1, Point x2) {
		punkte.add(x1);
		punkte.add(x2);
	}
}

