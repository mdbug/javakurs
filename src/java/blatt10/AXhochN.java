package java.blatt10;

/**
 * Created by micha on 15.12.2016.
 */
public class AXhochN implements Funktion {
    private double a;
    private double n;

    private AXhochN(double a, double n) {
        this.a = a;
        this.n = n;
    }

    public static Funktion get(double a, double n) {
        if (a == 0)
            return Null.get();
        else
            return new AXhochN(a, n);
    }

    @Override
    public double getY(double d) {
        return a * Math.pow(d, n);
    }

    @Override
    public Funktion getAbleitung() {
        if (n == 0)
            return Null.get();
        else
            return AXhochN.get(a*n, n-1);
    }

    public String toString() {
        if (n==0)
            return String.valueOf(a);

        StringBuilder sb = new StringBuilder();
        if (a != 0)
            sb.append(a);
        sb.append("x");
        if (n != 1.0)
            sb.append("^" + n);
        return sb.toString();
    }
}
