package algo.blatt04;

/**
 * Created by micha on 25.04.2017.
 */
public class VerketteteListe implements IList {
    private Node start = null;
    private int size = 0;

    @Override
    public void insertAt(int i, int n) {
        if (i < 0 || i > size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        Node next = null;
        if (i == 0) {
            start = new Node(n, start);
        } else {
            Node previous = getNodeAt(i-1);
            assert previous != null;
            next = previous.getNext();
            Node insert = new Node(n, next);
            previous.setNext(insert);
        }
        ++size;
    }

    @Override
    public void removeAt(int i) {
        if (i < 0 || i > size-1) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        } else if (i == 0) {
            start = start.getNext();
        } else {
            Node previous = getNodeAt(i-1);
            assert previous != null;
            previous.setNext(previous.getNext().getNext());
        }
        --size;
    }

    @Override
    public int getAt(int i) {
        Node node = getNodeAt(i);
        if (node == null)
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        return node.getValue();
    }

    private Node getNodeAt(int i) {
        Node node = start;
        for (int j = 0; j < i; ++j) {
            if (node == null) {
                return null;
            }
            node = node.getNext();
        }

        return node;
    }

    @Override
    public int search(int n) {
        Node node = start;
        int i = 0;
        while(node != null && node.getValue() != n) {
            node = node.getNext();
            ++i;
        }
        return node == null ? -1 : i;
    }

    @Override
    public void clear() {
        start = null;
    }

    @Override
    public int getCount() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node node = start;
        while(node != null) {
            sb.append(node.getValue());
            node = node.getNext();
            if (node != null) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
