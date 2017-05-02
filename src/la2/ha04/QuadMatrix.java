package la2.ha04;

/**
 * Die Klasse symbolisiert eine quadratische Matrix ueber dem Koerper derreellen Zahlen
 */
public class QuadMatrix {
    private double[][] a;

    /**
     * Konstruktor, der aus einem entsprechenden Array eine QuadMatrix erstellt
     * @param a 2-Dimensionales Array mit Koeffizienten
     */
    public QuadMatrix(double[][] a) {
        if (a == null) {
            throw new IllegalArgumentException("Die Matrix darf nich null sein");
        }
        this.a = new double[a.length][a.length];
        for (int i = 0; i < a.length; ++i) {
            if (a[i].length != a.length) {
                throw new IllegalArgumentException("Die Matrix muss Quadratisch sein");
            }
            System.arraycopy(a[i], 0, this.a[i], 0, a[i].length);
        }
    }

    /**
     * Copy-Konstuktor
     * @param m QuadMatrix
     */
    public QuadMatrix(QuadMatrix m) {
        this(m.a);
    }

    /**
     * Gibt die Zeilen bzw. Spaltenzahl dieser Matrix zurueck
     * @return Zeilen bzw. Spaltenzahl dieser Matrix
     */
    public int getDim() {
        return a.length;
    }

    /**
     * Gibt die Matrix in Form eines String zurueck
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("(");
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < a.length; ++j) {
                s.append(a[i][j]);
                if (j < a.length - j) {
                    s.append(" ");
                }
            }
            if (i < a.length - 1) {
                s.append(";");
            }
        }
        s.append(")");
        return s.toString();
    }

    /**
     * Die Methode addiert zum this-Objekt eine Matrix, veraendert das this Objekt jedoch nicht
     * @param qm Matrix, die addiert werden soll
     * @return Ergebnis der Addition
     */
    public QuadMatrix addiere(QuadMatrix qm) {
        if (qm.getDim() != this.getDim()) {
            throw new QuadMatrix.DimensionMismatchException();
        }
        QuadMatrix summe = new QuadMatrix(this);
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < a.length; ++j) {
                summe.a[i][j] += qm.a[i][j];
            }
        }
        return summe;
    }

    /**
     * Die Methode addiert multipliziert ein Skalar mit dem this-Objekt, veraendert das this Objekt jedoch nicht
     * @param lambda Skalar
     * @return Ergebnis
     */
    public QuadMatrix multipliziere(double lambda) {
        QuadMatrix result = new QuadMatrix(this);
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < a.length; ++j) {
                result.a[i][j] *= lambda;
            }
        }

        return result;
    }

    /**
     * Die Exception wird geworfen falls die Operation nicht moeglich ist, weil die Dimensionen der Matrizen nicht passen
     */
    public static class DimensionMismatchException extends RuntimeException {
        public DimensionMismatchException() {
            super("Dimensionen passen nicht!");
        }
    }
}
