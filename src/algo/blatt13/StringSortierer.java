package algo.blatt13;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class StringSortierer {
    public static void sortiere(ArrayList<String> liste, Verfahren v, Comparator<String> kriterium) {
        v.sortiere(liste, kriterium);
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Dies");
        list.add("ist");
        list.add("eine");
        list.add("sehr");
        list.add("gute");
        list.add("Aufgabe");
        list.add("zum");
        list.add("Üben");

        HashMap<String, Comparator<String>> kriterien = new HashMap<>();
        kriterien.put("Alphabetische Reihenfolge", Collator.getInstance()::compare);
        kriterien.put("Erster Buchstabe", Comparator.comparingInt(a -> a.charAt(0)));
        kriterien.put("Länge des Strings", Comparator.comparingInt(String::length));

        HashMap<String, Verfahren> verfahren = new HashMap<>();
        verfahren.put("Collections.sort", Collections::sort);
        verfahren.put("SimpleSort", new SimpleSort());
        verfahren.put("Insertion Sort", new InsertionSort());

        verfahren.forEach((vn, v) -> kriterien.forEach((kn, k) -> {
            Collections.shuffle(list);
            System.out.printf("Verfahren: %10s Kriterium: %s\n", vn, kn);
            sortiere(list, v, k);
            System.out.println(list);
            System.out.println("");
        }));
    }
}
