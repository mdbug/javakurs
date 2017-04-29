package algo.blatt02;

/**
 * Created by micha on 11.04.2017.
 */
public class KeyValue<K, V> {
    private K key;
    private V value;

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
