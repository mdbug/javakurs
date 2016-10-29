package la;

import java.util.Arrays;
/**
 * Die Klasse symbolisiert einen Vektor im R^n
 * @author Michael von Bothmer
 *
 */
public class VectorRn {
    private double[] v;

    /**
     * Gibt die Dimension des Vektors zurueck
     * @return
     */
    public int getDimension() {
        return v.length;
    }

    /**
     * Setzt den Wert der angegebenen Koordinate
     * @param i die Koordinate
     * @param value der Wert
     */
    public void set(int i, double value) {
        v[i] = value;
    }

    /**
     * Gibt den Wert der angegebenen Koordinate zurueck
     * @param die Koordinate des Vektors
     * @return den Wert der angegebenen Koordinate
     */
    public double get(int i) {
        return v[i];
    }

    /**
     * Konstruiert einen Nullvektor im R^n
     * @param n die Dimension des Vektors
     */
    public VectorRn(int n) {
        this.v = new double[n];
    }

    /**
     * Konstruiert einen neuen Vektor
     * @param v die Koordinaten des Vektors
     */
    public VectorRn(double...v) {
        this.v = v.clone();
    }

    /**
     * Addiert den angegebenen Vektor zu diesem Vektor
     * @param v2 der Vektor der addiert werden soll
     * @return das Ergebnis der Vektoraddition
     */
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
     * @return die Standardnorm des Vektors
     */
    public double getNorm() {
        return Math.sqrt(scalarProd(this, this));
    }
    
    /**
     * Prueft ob dieser Vektor und der Vektor v2 parallel zueinander sind
     * @return die Standardnorm des Vektors
     */
    public boolean isParallel(VectorRn v2) {
        // Maximaler relativer Fehler der beim Double-Vergleich toleriert wird
        final double EPSILON = 1e-5;
        
        if (v2.getDimension() != this.getDimension())
            throw new RuntimeException("Inkompatible Dimensionen");
        
        // Zwei Vektoren v1 und v2 sind parallel, falls ein reelles lambda existiert, sodass
        // v1 = lambda * v2
        double lambda = this.get(0) / v2.get(0);
        for(int i = 1; i < this.getDimension(); i++) {
           double relativeError = Math.abs(((this.get(i) / v2.get(i)) - lambda) / lambda);
           if ( relativeError > EPSILON)
               return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return Arrays.toString(v).replace("[", "(").replace("]", ")") + "^T";
    }
}
