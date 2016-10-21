package blatt01z;

import java.util.Arrays;

public class VectorRn {
	private double[] v;
	
	public int getDimension() {
		return v.length;
	}
	public void set(int i, double value) {
		v[i] = value;
	}
	public double get(int i) {
		return v[i];
	}
	
	public VectorRn(int n) {
		this.v = new double[n];
	}
	
	public VectorRn(double...v) {
		this.v = v.clone();
	}
	
	public VectorRn add(VectorRn v2) {
		if (v2.getDimension() != this.getDimension())
			throw new RuntimeException("Inkompatible Dimensionen");
		VectorRn vResult = new VectorRn(this.getDimension());
		for (int i = 0; i < this.getDimension(); i++) {
			vResult.set(i,this.get(i) + v2.get(i));
		}
		return vResult;
	}
	
	/**
	 * Multipliziert den Vektor mit einem Skalar
	 * @param ein Skalar mit dem der Vektor multipliziert 
	 * @return
	 */
	public VectorRn mult(double d) {
		VectorRn vResult = new VectorRn(this.getDimension());
		for (int i = 0; i < this.getDimension(); i++) {
			vResult.set(i, this.get(i) * d);
		}
		return vResult;
	}
	
	/**
	 * Berechnet das Standard-Skalarprodukt zweier Vektoren
	 * @param v1 der erste Vektor
	 * @param v2 der zweite Vektor
	 * @return das Standardskalarprodukt der Vektoren v1 und v2
	 */
	public static double scalarProd(VectorRn v1, VectorRn v2) {
		if (v1.getDimension() != v2.getDimension())
			throw new RuntimeException("Inkompatible Dimensionen");
		double sum = 0;
		for (int i=0; i<v1.getDimension(); i++) {
			sum += v1.get(i) * v2.get(i);
		}
		return sum;
	}
	
	/**
	 * Berechnet die Standardnorm des Vektors
	 * @return die Standardnorm des Vektors zurueck
	 */
	public double getNorm() {
		return Math.sqrt(scalarProd(this, this));
	}
	
	public String toString() {
		return Arrays.toString(v).replace("[", "(").replace("]", ")") + "^T";
	}
}
