package algo.blatt02;

import java.util.HashMap;

/**
 * Created by micha on 11.04.2017.
 */
public class TestMyHash {
    public static void main(String[] args) {
        MyHash<Integer, Integer> map1 = new MyHash<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < 1000000; ++i) {
            int key = (int) (Math.random() * Integer.MAX_VALUE);
            int value = (int) (Math.random() * Integer.MAX_VALUE);

            map1.add(key, value);
            map2.put(key, value);

            if (map1.get(key) != value) {
                System.out.println("Error");
            }
        }

        for (Integer key : map2.keySet()) {
            int val1 = map1.get(key);
            int val2 = map2.get(key);
            if (val1 != val2) {
                System.out.println("Error");
            }
        }
        System.out.println("Done");

    }
}
