package la;

import java.util.Arrays;

/**
 * Die Klasse symbolisiert einen Vektor im R^n
 *
 * @author Michael von Bothmer
 */
public class VectorRn {
    private double[] v;

    /**
     * Gibt die Dimension des Vektors zurueck
     */
    public int getDimension() {
        return v.length;
    }

    /**
     * Setzt den Wert der angegebenen Koordinate
     *
     * @param i     die Koordinate
     * @param value der Wert
     */
    public void set(int i, double value) {
        v[i] = value;
    }

    /**
     * Gibt den Wert der angegebenen Koordinate zurueck
     *
     * @param i die Koordinate des Vektors
     * @return den Wert der angegebenen Koordinate
     */
    public double get(int i) {
        return v[i];
    }

    /**
     * Konstruiert einen Nullvektor im R^n
     *
     * @param n die Dimension des Vektors
     */
    public VectorRn(int n) {
        this.v = new double[n];
    }

    /**
     * Konstruiert einen neuen Vektor
     *
     * @param v die Koordinaten des Vektors
     */
    public VectorRn(double... v) {
        this.v = v.clone();
    }

    /**
     * Copy-Konstruktor
     *
     * @param vector die Koordinaten des Vektors
     */
    public VectorRn(VectorRn vector) {
        this.v = vector.v.clone();
    }

    /**
     * Addiert den angegebenen Vektor zu diesem Vektor
     *
     * @param v2 der Vektor der addiert werden soll
     * @return das Ergebnis der Vektoraddition
     */
    public VectorRn add(VectorRn v2) {
        if (v2.getDimension() != this.getDimension())
            throw new RuntimeException("Inkompatible Dimensionen");
        VectorRn vResult = new VectorRn(this.getDimension());
        for (int i = 0; i < this.getDimension(); i++) {
            vResult.set(i, this.get(i) + v2.get(i));
        }
        return vResult;
    }

    /**
     * Multipliziert den Vektor mit einem Skalar
     *
     * @param d ein Skalar mit dem der Vektor multipliziert
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
     *
     * @param v1 der erste Vektor
     * @param v2 der zweite Vektor
     * @return das Standardskalarprodukt der Vektoren v1 und v2
     */
    public static double scalarProd(VectorRn v1, VectorRn v2) {
        if (v1.getDimension() != v2.getDimension())
            throw new RuntimeException("Inkompatible Dimensionen");
        double sum = 0;
        for (int i = 0; i < v1.getDimension(); i++) {
            sum += v1.get(i) * v2.get(i);
        }
        return sum;
    }

    /**
     * Berechnet die Standardnorm des Vektors
     *
     * @return die Standardnorm des Vektors
     */
    public double getNorm() {
        return Math.sqrt(scalarProd(this, this));
    }

    /**
     * Prueft ob dieser Vektor und der Vektor v2 parallel zueinander sind
     *
     * @param v2 der zu pruefende Vektor
     * @return true, falls dieser Vektor und v2 parallel zueinander sind. false, sonst.
     */
    public boolean isParallel(VectorRn v2) {
        // Maximaler relativer Fehler der beim Double-Vergleich toleriert wird
        final double EPSILON = 1e-5;

        if (v2.getDimension() != this.getDimension())
            throw new RuntimeException("Inkompatible Dimensionen");

        // Zwei Vektoren v1 und v2 sind parallel, falls ein reelles lambda existiert, sodass
        // v1 = lambda * v2
        double lambda = 0;
        boolean lambdaFound = false;

        for (int i = 0; i < this.getDimension(); i++) {
            double xi = this.get(i);
            double yi = v2.get(i);
            if (xi != 0 && yi != 0) {
                if (!lambdaFound) {
                    lambda = xi / yi;
                    lambdaFound = true;
                } else {
                    double relativeError = Math.abs(((xi / yi) - lambda) / lambda);
                    if (relativeError > EPSILON) {
                        return false;
                    }
                }
            } else if (xi != yi) {
                return false;
            }
        }
        return true;
    }

    /**
     * Berechnet den Winkel zwischen v1 und v2 im Bogenmass
     *
     * @param v1 ein Vektor
     * @param v2 der andere Vektor
     * @return Gibt den Winkel zwischen den Vektoren im Bogenmass zurueck
     */
    public static double getWinkel(VectorRn v1, VectorRn v2) {
        if (v1.getDimension() != v2.getDimension())
            throw new RuntimeException("Inkompatible Dimensionen");
        if (v1.getNorm() == 0.0 || v2.getNorm() == 0)
            throw new RuntimeException("Kein Vektor darf 0 sein");

        return Math.acos(scalarProd(v1, v2) / (v1.getNorm() * v2.getNorm()));
    }

    /**
     * Berechnet die orthogonale Projektion von v1 auf v2
     *
     * @param v1 der Vektor der projiziert werden soll
     * @param v2 der Vektor auf den projiziert werden soll
     * @return die orthogonale Projektion von v1 auf v2
     */
    public static VectorRn projiziereV1AufV2(VectorRn v1, VectorRn v2) {
        if (v1.getDimension() != v2.getDimension())
            throw new RuntimeException("Inkompatible Dimensionen");
        if (v1.getNorm() == 0 || v2.getNorm() == 0)
            throw new RuntimeException("Kein Vektor darf 0 sein");

        return v2.mult(scalarProd(v1, v2) / scalarProd(v2, v2));
    }

    /**
     * Gibt n-1 zu diesem Vektor senkrechte Vektoren zurueck.
     *
     * @return Gibt ein Array mit zu diesem Vektor senkrechten Vektoren zurueck
     */
    public VectorRn[] bestimmeSenkrechteVektoren() {
        if (this.getDimension() == 1)
            throw new RuntimeException();
        if (this.isNull())
            throw new RuntimeException("Vektor ist 0");

        VectorRn[] vektoren = new VectorRn[this.getDimension()-1];
        int ersteKoordinateUngleichNull = -1;
        for (int i = 0; i < this.getDimension(); i++) {
            if (this.get(i) != 0) {
                ersteKoordinateUngleichNull = i;
                break;
            }
        }
        int tauschKoordinate = 0;
        for (int i = 0; i < this.getDimension() - 1; i++) {
            vektoren[i] = new VectorRn(this);
            if (tauschKoordinate == ersteKoordinateUngleichNull) {
                tauschKoordinate++;
            }
            vektoren[i].swap(ersteKoordinateUngleichNull, tauschKoordinate);
            tauschKoordinate++;
        }

        return vektoren;
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return Arrays.toString(v).replace("[", "(").replace("]", ")") + "^T";
    }

    /**
     * Tauscht die Koordinaten, aendert das Vorzeichen der ersten Koordinaten und setzt alle
     * anderen Koordinaten auf 0
     *
     * @param a die erste Koordinate
     * @param b die zweite Koordinate
     */
    private void swap(int a, int b) {
        double vNegativeA = v[a] * -1;
        v[a] = v[b];
        v[b] = vNegativeA;
        for (int i = 0; i < this.getDimension(); i++) {
            if (i != a && i != b) {
                v[i] = 0;
            }
        }
    }

    private boolean isNull() {
        for (double x : v) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }
}
