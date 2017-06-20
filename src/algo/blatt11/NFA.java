package algo.blatt11;

import java.util.ArrayList;
import java.util.HashMap;

public class NFA {
    private HashMap<Integer, ArrayList<Kante>> adjazenzliste = new HashMap<>();
    private int ziel;

    public NFA (String x) {
        String[] token = x.split(",");
        int knoten = Integer.parseInt(token[0]);
        int kanten = Integer.parseInt(token[1]);
        ziel = knoten;

        for (int i = 2; i < token.length; ++i) {
            int start = Integer.parseInt(token[i]);
            ++i;
            int ziel = Integer.parseInt(token[i]);
            ++i;
            char zeichen = token[i].charAt(0);
            ArrayList<Kante> liste = adjazenzliste.computeIfAbsent(start, k -> new ArrayList<>());
            liste.add(new Kante(ziel, zeichen));
        }
    }

    public boolean testString(String s) {
        ArrayList<Integer> besetzt = new ArrayList<>();
        besetzt.add(1);
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            boolean found = false;
            ArrayList<Integer> besetzt2 = new ArrayList<>();
            for (Integer b : besetzt) {
                ArrayList<Kante> liste = adjazenzliste.get(b);
                if (liste != null) {
                    for (Kante k : liste) {
                        if (k.zeichen == c) {
                            besetzt2.add(k.ziel);
                            found = true;
                        }
                    }
                }
            }
            besetzt = besetzt2;
            if (!found) {
                return false;
            }
        }
        return besetzt.contains(ziel);
    }

    public boolean testStringRek(String s, int knoten, int i) {
        if (i == s.length()) {
            return false;
        }
        char c = s.charAt(i);
        ArrayList<Kante> liste = adjazenzliste.get(knoten);
        if (liste == null) {
            return false;
        }

        for(Kante k : liste) {
            if (k.zeichen == c) {
                if ((k.ziel == ziel && i == s.length()-1) || testStringRek(s, k.ziel, i+1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        NFA nfa_test = new NFA("3,3,1,2,a,1,3,a,2,2,a,2,2,b,2,3,a");
        System.out.println(nfa_test.testString("abba"));
        System.out.println(nfa_test.testString("a"));
        System.out.println(nfa_test.testString("ab"));
        System.out.println(nfa_test.testStringRek("abba", 1, 0));
        System.out.println(nfa_test.testStringRek("a", 1, 0));
        System.out.println(nfa_test.testStringRek("ab", 1, 0));
    }
}
