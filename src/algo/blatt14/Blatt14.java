package algo.blatt14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Blatt14 {
    final static int LIST_SIZE = 1000;
    final static int BOUND = 1000000;
    final static int BUCKETS = 1000;
    final static int BUCKETSIZE = BOUND / BUCKETS;

    public static ArrayList<Integer> getRandomList() {
        ArrayList<Integer> list = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < LIST_SIZE; ++i) {
            list.add(rnd.nextInt(BOUND));
        }
        return list;
    }

    public static boolean isSorted(ArrayList<Integer> list) {
        int last = Integer.MIN_VALUE;
        for (Integer x : list) {
            if (x < last) {
                return false;
            }
            last = x;
        }
        return true;
    }

    public static void bucketSort1(ArrayList<Integer> list) {
        int[] buckets = new int[BOUND];
        for (Integer x : list) {
            buckets[x]++;
        }
        list.clear();
        for (int i = 0; i < buckets.length; ++i) {
            for (int j = 0; j < buckets[i]; ++j) {
                list.add(i);
            }
        }
    }

    public static void bucketSort2(ArrayList<Integer> list) {
        // Buckets intitialisieren
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < BUCKETS; ++i) {
            buckets.add(new ArrayList<>());
        }

        // Werte in die Buckets einsortieren
        for (Integer x : list) {
            int bucketIndex = x / BUCKETSIZE;
            buckets.get(bucketIndex).add(x);
        }

        // Buckets sortieren
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Werte aus den sortierten Buckets in die Liste einfuegen
        list.clear();
        for (ArrayList<Integer> bucket : buckets) {
            list.addAll(bucket);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = getRandomList();
        System.out.println(list);
        System.out.println(isSorted(list));
        bucketSort2(list);
        System.out.println(list);
        System.out.println(isSorted(list));
    }
}
