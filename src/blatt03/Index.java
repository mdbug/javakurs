package blatt03;

import java.util.HashMap;
import java.util.HashSet;

public class Index {
    private HashMap<String, HashSet<Integer>> map;

    public Index() {
       map = new HashMap<>();
    }
    
    public Index(Index index) {
       map = new HashMap<>();
       for (String begriff : index.map.keySet()) {
           for (Integer seite :index.map.get(begriff)) {
               begriffHinzufuegen(begriff, seite);
           }
       }
    }
    
    public void begriffHinzufuegen(String begriff, int seite) {
        if (map.containsKey(begriff)) {
            map.get(begriff).add(seite);
        } else {
            HashSet<Integer> set = new HashSet<>();
            set.add(seite);
            map.put(begriff, set);
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String begriff : map.keySet()) {
            sb.append(begriff + ": " + map.get(begriff) + "\n");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Index index = new Index();
        index.begriffHinzufuegen("Hallo", 34);
        index.begriffHinzufuegen("Bla", 37);
        index.begriffHinzufuegen("yollo", 334);
        index.begriffHinzufuegen("wtf", 3422);
        index.begriffHinzufuegen("Hallo", 1);
        index.begriffHinzufuegen("Hallo", 34);
        System.out.println(index);
    }

}
