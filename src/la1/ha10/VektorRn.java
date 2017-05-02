package la1.ha10;

/**
 * Klasse zur Darstellung von Vektoren aus dem n-dimensionalen Raum
 *
 * @author M.Mathieu
 *
 */
public class VektorRn {

	/**
	 * Speichert die Elemente des Vektors und gibt durch die Gr��e die Dimension
	 * vor
	 */
	private double[] elemente;
	
	/**
	 * Konstruktor zur Erstellung eines Nullvektors mit entsprechender Dimension
	 * 
	 * @param dim
	 *            Dimension des Vektors
	 */
	public VektorRn(int dim) {
		if (dim < 1){
			throw new RuntimeException("Die Dimension des Vektors muss positiv sein.");
		}
		elemente = new double[dim];
	}

	/**
	 * Konstruktor zur Erstellung eines Vektors mit vorgegebenen Elementen
	 * 
	 * @param elemente
	 *            Array mit allen Elementen des Vektors
	 */
	public VektorRn(double[] elemente) {
		if (elemente == null || elemente.length == 0) {
			throw new RuntimeException("Die Dimension des Vektors muss positiv sein.");
		}
		else {
			this.elemente = elemente.clone();
		}
	}
	
	/**
	 * Copy-Konstruktor
	 * 
	 * @param v
	 *            Vektor, der kopiert werden soll
	 */
	public VektorRn(VektorRn v) {
		elemente = v.elemente.clone();
	}

	/**
	 * Getter der Vektor-Komponenten
	 * @return Array der Vektor-Komponenten
	 */
	public double[] getElements () {
		return elemente;
	}
	
	/**
	 * Getter einer bestimmten Vektor-Komponente
	 * @param komponente 
	 * 				Index der Komponente, die zur�ckgegeben werden soll (beginnend bei 0)
	 * @return gew�nschte Komponente
	 */
	public double getElement (int komponente) {
		if (komponente < elemente.length && komponente > -1) {
			return elemente[komponente];
		}
		else throw new RuntimeException("Diese Komponente existiert nicht");
	}
	
	/**
	 * Setter einer bestimmten Vektor-Komponente
	 * @param komponente 
	 * 				Index der Komponente, die ver�ndert werden soll
	 * @param wert Wert, denn die Komponente annehmen soll
	 */
	public void setElement (int komponente, double wert) {
		if (komponente < elemente.length && komponente > -1) {
			elemente[komponente] = wert;
		}
		else throw new RuntimeException("Diese Komponente existiert nicht");
	}

	/**
	 * Addiert auf den this-Vektor den Vektor v2
	 * 
	 * @param v
	 *            Vektor der mit dem this-Vektor addiert wird
	 * @return neuer Vektor, der das Ergebnis aus this+v2 ist
	 */
	public VektorRn add(VektorRn v) {
		// Stimmen die Dimensionen ueberein?
		if (this.elemente.length != v.elemente.length) {
			throw new RuntimeException("Die Dimensionen der Vektoren sind nicht identisch.");
		}
		// lege Ergebnisvektor als Kopie des this-Vektors an
		VektorRn ergVec = new VektorRn(this);
		// Addition der Vektoren
		for (int i = 0; i < this.elemente.length; i++) {
			ergVec.elemente[i] += v.elemente[i];
		}
		return ergVec;		
	}

	/**
	 * Multipliziert den this-Vektor mit einem Skalar
	 * 
	 * @param d
	 *            Skalar aus R, das auf den this-Vektor mutlipliziert wird
	 * @return neuer Vektor, der das Ergebnis der Multiplikation ist
	 */
	public VektorRn mult(double d) {
		// lege Ergebnisvektor als Kopie des this-Vektors an
		VektorRn ergVec = new VektorRn(this);
		// Multiplikation des Vektors mit einem Skalar
		for (int i = 0; i < this.elemente.length; i++) {
			ergVec.elemente[i] *= d;
		}
		return ergVec;		
	}

	/**
	 * Formatierte Ausgabe: Vektors als Zeile
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// erstellen der Ausgabe
		sb.append("(");
		for (int i = 0; i < this.elemente.length - 1; i++) {
			sb.append(elemente[i] + ", ");
		}
		sb.append(elemente[this.elemente.length - 1] + ")");
		return sb.toString();		
	}

	/**
	 * Berechnet das Standardskalarprodukt f�r 2 Vektoren
	 * 
	 * @param v1
	 *            Erste Vektor des Skalarproduktes
	 * @param v2
	 *            Zweite Vektor des Skalarproduktes
	 * @return liefert das Ergebnis oder -1, wenn das Skalarprodukt nicht
	 *         berechnet werden kann
	 */
	public static double scalarProd(VektorRn v1, VektorRn v2) {
		double erg = 0;
		if (v1.elemente.length != v2.elemente.length) {
			throw new RuntimeException("Die Vektoren haben unterschiedliche Dimensionen.");
		}
		// Berechnung des Skalarproduktes
		for (int i = 0; i < v1.elemente.length; i++) {
			erg += v1.elemente[i] * v2.elemente[i];
		}
		return erg;
	}

	/**
	 * Berechnet die Norm eines Vektors
	 * 
	 * @return Norm des this-Vektors
	 */
	public double getNorm() {
		// Wurzel kann direkt gezogen werden, da keine negativen Zahlen
		// auftreten k�nnen!
		return Math.sqrt(scalarProd(this, this));		
	}

	/**
	 * Berechnet den Winkel zwischen Vektor v1 und v2 (Ausgabe im Bogenma�)
	 * 
	 * @param v1
	 *            Erster Vektor f�r den Winkel
	 * @param v2
	 *            Zweiter Vektor f�r den Winkel
	 * @return Winkel zwischen v1 und v2
	 */
	public static double getWinkel(VektorRn v1, VektorRn v2) {
		return Math.acos(scalarProd(v1, v2) / (v1.getNorm() * v2.getNorm()));	
	}

	/**
	 * Bildet die Projektion von v in Richtung this-Vektor
	 * @param v
	 */
	public void projiziereAuf(VektorRn v) {
		this.mult(scalarProd(v, this) / scalarProd(this, this));				
	}
}
