package blatt08;

/**
 * Created by micha on 01.12.2016.
 */
public class WrongElementException extends RuntimeException {
    private int index;

    public WrongElementException(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String toString() {
        return "Wrong data element in <" + index + ">";
    }
}
