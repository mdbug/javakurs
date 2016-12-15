package blatt10;

/**
 * Created by micha on 15.12.2016.
 */
public class Ableitungstest {

    public static void main(String[] args) {
        Funktion f1 = AXhochN.get(3, 2);
        Funktion f2 = AXhochN.get(7, 1);
        Funktion f = Summe.get(f1, f2);
        test(f);

    }

    public static void test(Funktion f) {
        for (int i = 0; i < 4; i++) {
            System.out.println(i + ". Ableitung: " + f);
            System.out.println("f(2) = " + f.getY(2));
            f = f.getAbleitung();
        }
        System.out.println("==============");

    }

}
