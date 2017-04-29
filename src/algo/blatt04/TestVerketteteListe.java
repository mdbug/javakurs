package algo.blatt04;

/**
 * Created by micha on 25.04.2017.
 */
public class TestVerketteteListe {
    public static void main(String[] args) {
        VerketteteListe liste = new VerketteteListe();
        liste.insertAt(0, 1);
        liste.insertAt(1, 2);
        liste.insertAt(2, 3);
        liste.insertAt(0, 4);
        liste.insertAt(2, 5);
        liste.insertAt(3, 6);
        liste.insertAt(0, 7);

        System.out.println(liste);
    }
}
