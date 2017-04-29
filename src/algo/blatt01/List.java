package algo.blatt01;

import java.util.ArrayList;
import java.util.Collections;

public class List {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int SIZE = 1000000;
        for(int i = 1; i <= SIZE; ++i) {
            list.add(i);
        }

        long t0, t1;
        t0 = System.nanoTime();
        for (int i = 0; i <= 1000; ++i) {
            Integer val = (int) (Math.random() * SIZE);
            int pos = list.indexOf(val);
        }
        t1 = System.nanoTime();
        System.out.println("indexOf:");
        System.out.println(t1-t0);

        t0 = System.nanoTime();
        for (int i = 0; i <= 1000; ++i) {
            Integer val = (int) (Math.random() * SIZE);
            int pos = Collections.binarySearch(list, val);
        }
        t1 = System.nanoTime();

        System.out.println("Collections.binarySearch:");
        System.out.println(t1-t0);

        t0 = System.nanoTime();
        for (int i = 0; i <= 1000; ++i) {
            Integer val = (int) (Math.random() * SIZE);
            int pos = binarySearchRekursiv(list, val);
        }
        t1 = System.nanoTime();

        System.out.println("binarySearchRekursiv");
        System.out.println(t1-t0);

        t0 = System.nanoTime();
        for (int i = 0; i <= 1000; ++i) {
            Integer val = (int) (Math.random() * SIZE);
            int pos = binarySearchIterativ(list, val);
        }
        t1 = System.nanoTime();

        System.out.println("binarySearchIterativ");
        System.out.println(t1-t0);
    }

    public static int binarySearchRekursiv(ArrayList<Integer> list, int search) {
        return binarySearchRekursiv(list, search, 0, list.size());
    }

    public static int binarySearchRekursiv(ArrayList<Integer> list, int search, int x1, int x2) {
        int pos = x1 + (x2 - x1) / 2;
        int value = list.get(pos);
        if (value < search)
            return binarySearchRekursiv(list, search, pos+1, x2);
        else if (value > search)
            return binarySearchRekursiv(list, search, x1, pos);
        return pos;
    }

    public static int binarySearchIterativ(ArrayList<Integer> list, int search) {
        int x1 = 0;
        int x2 = list.size();
        int value, pos;
        do {
            pos = x1 + (x2 - x1) / 2;
            value = list.get(pos);
            if (value < search) {
                x1 = pos + 1;
            } else if (value > search) {
                x2 = pos;
            }
        } while (value != search);
        return pos;
    }
}
