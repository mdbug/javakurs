package algo.blatt04;

/**
 * Created by micha on 25.04.2017.
 */
public interface IList {
    void insertAt(int i, int n);
    void removeAt(int i);
    int getAt(int i);
    int search(int n);
    void clear();
    int getCount();
}
