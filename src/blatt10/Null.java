package blatt10;

/**
 * Created by micha on 15.12.2016.
 */
public class Null implements Funktion {
    private static final Null n = new Null();

    private Null() {}

    public static Null get() {
        return n;
    }

    @Override
    public double getY(double d) {
        return 0;
    }

    @Override
    public Funktion getAbleitung() {
        return Null.get();
    }

    public String toString() {
        return "0";
    }
}
