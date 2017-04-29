package algo.blatt04;

/**
 * Created by micha on 25.04.2017.
 */
public class Node {
    private int n;
    private Node next = null;

    public Node(int n) {
        this.n = n;
    }

    public Node(int n, Node next) {
        this.n = n;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return n;
    }

    public void setValue(int n) {
        this.n = n;
    }
}
