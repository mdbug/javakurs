package java.blatt07;

/**
 * Created by micha on 24.11.2016.
 */
public class Test {
    public static void main(String[] args) {
        Funktion[] f = new Funktion[4];
        f[0] = (x) -> Math.exp(x)-4;
        f[1] = (x) -> Math.log(Math.abs(x+1)) - Math.sin(2*x) - 0.5;
        f[2] = (x) -> x*x - Math.sin(x) - 1;
        f[3] = (x) -> x*x*x*x + x*x*x - 5;

        Verfahren[] verfahren = new Verfahren[2];
        verfahren[0] = new Bisektionsverfahren();
        verfahren[1] = new Sekantenverfahren();


        for (int i = 0; i < f.length; i++) {
            System.out.println("Funktion f" + i);
            for (Verfahren v : verfahren) {
                System.out.println("  Nullstelle: " + v.getNullstelle(f[i], 0.0, 10.0) + " (" + v + ")");
            }
        }
    }
}
