package algo.klausurvorbereitung;

import java.util.ArrayList;

public class HashSet {
    private ArrayList<ArrayList<String>> list = new ArrayList<>();

    public HashSet() {
        for (int i = 0; i < 26; ++i) {
            list.add(new ArrayList<>());
        }
    }

    public boolean contains(String s) {
        return list.get(hash(s)).contains(s);
    }

    private int hash(String s) {
        return s.charAt(0)-65;
    }

    public void add(String s) {
        if (!contains(s)) {
            list.get(hash(s)).add(s);
        }
    }

    public static void main(String[] args) {
        HashSet h = new HashSet();

        h.add("HALLO");
        h.add("HI");
        h.add("TEST");
        h.add("HALLO");
        h.add("BLA");
        h.add("AAALA");
        System.out.println(h.contains("HALLO"));
        System.out.println(h.contains("HI"));
        System.out.println(h.contains("TETWEWTETW"));
        System.out.println(h.contains("AAALA"));
        System.out.println(h.contains("TEST"));
    }
}
