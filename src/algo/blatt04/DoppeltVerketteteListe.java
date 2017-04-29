package algo.blatt04;

/**
 * Created by micha on 25.04.2017.
 */
public class DoppeltVerketteteListe implements IList {
    private NodeD start = null;
    private NodeD ende = null;
    private int size = 0;

    @Override
    public void insertAt(int i, int n) {
        if (i < 0 || i > size) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        NodeD next = null;
        if (i == 0) {
            start = new NodeD(n, null, start);
        } else if (i == size){
            ende = new NodeD(n, ende, null);
        } else {
            NodeD previous = getNodeAt(i-1);
            assert previous != null;
            next = previous.getNext();
            NodeD insert = new NodeD(n, previous, next);
            previous.setNext(insert);
            if (next != null) {
                next.setPrevious(insert);
            }
        }
        ++size;
    }

    @Override
    public void removeAt(int i) {
        if (i < 0 || i > size-1) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        } else if (i == 0) {
            start = start.getNext();
        } else if (i == size) {
            ende = ende.getPrevious();
        } else {
            NodeD previous = getNodeAt(i-1);
            assert previous != null;
            previous.setNext(previous.getNext().getNext());
        }
        --size;
    }

    @Override
    public int getAt(int i) {
        NodeD node = getNodeAt(i);
        if (node == null)
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        return node.getValue();
    }

    private NodeD getNodeAt(int i) {
        NodeD node = start;
        if (i < size / 2) {
            for (int j = 0; j < i; ++j) {
                if (node == null) {
                    return null;
                }
                node = node.getNext();
            }
        } else {
            for (int j = size-1; j > i; --j) {
                if (node == null) {
                    return null;
                }
                node = node.getPrevious();
            }
        }
        return node;
    }

    @Override
    public int search(int n) {
        NodeD node = start;
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
        NodeD node = start;
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
