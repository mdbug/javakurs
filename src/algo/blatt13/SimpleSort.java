package algo.blatt13;

import java.util.ArrayList;
import java.util.Comparator;

public class SimpleSort implements Verfahren {
    @Override
    public void sortiere(ArrayList<String> liste, Comparator<String> kriterium) {
        for (int i = 0; i < liste.size(); i++) {
            for (int j = i; j < liste.size(); j++) {
                if (kriterium.compare(liste.get(i), liste.get(j)) > 0) {
                    String tmp = liste.get(j);
                    liste.set(j, liste.get(i));
                    liste.set(i, tmp);
                }
            }
        }
    }
}
