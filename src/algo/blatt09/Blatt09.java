package algo.blatt09;

import java.util.ArrayList;

public class Blatt09 {

    public static void printPermutationen(int n) {
        ArrayList<ArrayList<Integer>> permuationen = getPermuationen(new ArrayList<>(), n);
        for (ArrayList<Integer> p : permuationen) {
            System.out.println(p);
        }
    }

    private static ArrayList<ArrayList<Integer>> getPermuationen(ArrayList<Integer> p, int n) {
        ArrayList<ArrayList<Integer>> permutationen = new ArrayList<>();
        if (n == 0) {
            permutationen.add(p);
            return permutationen;
        }
        for (int i = 0; i < p.size() + 1; ++i) {
            ArrayList<Integer> per = new ArrayList<>(p);
            per.add(i, n);
            permutationen.addAll(getPermuationen(per, n - 1));
        }
        return permutationen;
    }

    public static void printPermutationen(int n, int ges) {
        for(String s : getPermutationen(n, ges, "")) {
            System.out.println(s);
        }
    }

    private static ArrayList<String> getPermutationen(int n, int ges, String s) {
        ArrayList<String> permutationen = new ArrayList<>();
        if (s.length() == ges) {
            permutationen.add(s);
            return permutationen;
        }
        if (n < ges - s.length()) {
            permutationen.addAll(getPermutationen(n, ges, s + "0"));
        }
        if (n > 0)
            permutationen.addAll(getPermutationen(n-1, ges, s + "1"));

        return permutationen;
    }

    public static void printBewegungen(int n, int start, int ziel) {
        if (n == 0) {
            return;
        }

        int other = 6-start-ziel;
        printBewegungen(n-1, start, other);
        System.out.println("Bewege Scheibe von " + start + " nach " + ziel);
        printBewegungen(n-1, other, ziel);
    }

    public static ArrayList<Integer> shortestWay(int[] f) {
        return shortestWay(f, 0);
    }

    public static ArrayList<Integer> shortestWay(int[] f, int pos, int punkte, ) {

    }

    public static void main(String[] args) {
        printPermutationen(3);
        printPermutationen(2, 4);
        printBewegungen(3, 1, 2);
    }
}
