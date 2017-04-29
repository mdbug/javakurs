package java.blatt07;

/**
 * Created by micha on 24.11.2016.
 */
public class Sekantenverfahren implements Verfahren {

    @Override
    public double getNullstelle(Funktion f, double xMin, double xMax) {
        double x1 = xMin;
        double x2 = xMax;
        double xm = (x1*f.getY(x2) - x2*f.getY(x1)) / (f.getY(x2) - f.getY(x1));
        while (x2-x1 > 1E-10) {
            if (Math.abs(f.getY(xm)) < 1E-10)
                return xm;
            if (f.getY(x1)*f.getY(xm) < 0)
                x2 = xm;
            if (f.getY(x2)*f.getY(xm) < 0)
                x1 = xm;

            xm = (x1*f.getY(x2) - x2*f.getY(x1)) / (f.getY(x2) - f.getY(x1));
        }
        return xm;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
