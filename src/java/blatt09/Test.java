package java.blatt09;

import java.awt.Point;

public class Test {
	public static void main(String[] args) { 
		Grafik g = new Grafik(300, 300); // Groesse der Grafik

		// Linie von (10/10) nach (200/100)
		// Der Koordinatenursprung ist links oben
		Linie l = new Linie(new Point(10, 10), new Point(200, 100));
		Rechteck r1 = new Rechteck(new Point(20, 20), new Point(250, 250));
        Rechteck r2 = new Rechteck(r1);
        Rechteck r3 = new Rechteck(new Point(20,20), new Point(100, 200));
        r2.skaliere(0.5);
        Rechteck r4 = r2.vereinige(r3);
		//g.add(l);
		//g.add(r1);
        g.add(r2);
        g.add(r3);
        g.add(r4);
		g.aktualisiere(0);
	    
	  }
}
