package algo.blatt13;

import java.util.ArrayList;
import java.util.Comparator;

public class InsertionSort implements Verfahren {
    @Override
    public void sortiere(ArrayList<String> liste, Comparator<String> kriterium) {
        for (int i = 1; i < liste.size(); i++) {
            String tmp = liste.get(i);
            int j = i;
            while (j > 0 && kriterium.compare(liste.get(j - 1), tmp) > 0) {
                liste.set(j, liste.get(j - 1));
                j--;
            }
            liste.set(j, tmp);
        }
    }
}
