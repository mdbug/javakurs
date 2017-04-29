package java.blatt10;

/**
 * Created by micha on 15.12.2016.
 */
public class Summe implements Funktion {
    private Funktion f1;
    private Funktion f2;

    private Summe(Funktion f1, Funktion f2) {
        this.f1 = f1;
        this.f2 = f2;
    }

    public static Funktion get(Funktion f1, Funktion f2) {
        if (f1 instanceof Null)
            return f2;
        else if (f2 instanceof Null)
            return f1;
        else
            return new Summe(f1, f2);
    }

    @Override
    public double getY(double d) {
        return f1.getY(d) + f2.getY(d);
    }

    @Override
    public Funktion getAbleitung() {
        return Summe.get(f1.getAbleitung(), f2.getAbleitung());
    }

    public String toString() {
        return f1.toString() + " + " + f2.toString();
    }
}
