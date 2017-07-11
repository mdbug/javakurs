package algo.klausurvorbereitung;

import java.util.ArrayList;

public class Heap {
    public static void insertElement(ArrayList<Integer> heap, int newElement) {
        heap.add(newElement);
        upheap(heap);
    }

    private static void upheap(ArrayList<Integer> heap) {
        int i = heap.size() - 1;
        int parent = (i+1) / 2 - 1;
        while (parent >= 0 && heap.get(i) > heap.get(parent)) {
            int tmp = heap.get(i);
            heap.set(i, heap.get(parent));
            heap.set(parent, tmp);
            i = parent;
            parent = (i+1) / 2 -1;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> heap = new ArrayList<>();
        insertElement(heap, 4);
        insertElement(heap, 5);
        insertElement(heap, 3);
        insertElement(heap, 7);
        insertElement(heap, 6);
        insertElement(heap, 0);
        insertElement(heap, 1);
        insertElement(heap, 9);
        System.out.println(heap);
    }
}
