package algo.blatt04;

/**
 * Created by micha on 25.04.2017.
 */
public class NodeD {
    private int n;
    private NodeD next = null;
    private NodeD previous = null;

    public NodeD(int n) {
        this.n = n;
    }

    public NodeD(int n, NodeD previous) {
        this.n = n;
        this.previous = previous;
    }

    public NodeD(int n, NodeD previous, NodeD next) {
        this.n = n;
        this.previous = previous;
        this.next = next;
    }

    public NodeD getNext() {
        return next;
    }

    public void setNext(NodeD next) {
        this.next = next;
    }

    public int getValue() {
        return n;
    }

    public void setValue(int n) {
        this.n = n;
    }

    public NodeD getPrevious() {
        return previous;
    }

    public void setPrevious(NodeD previous) {
        this.previous = previous;
    }
}
