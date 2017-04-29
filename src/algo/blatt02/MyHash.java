package algo.blatt02;

import java.security.Key;
import java.util.ArrayList;

/**
 * Created by micha on 11.04.2017.
 */
public class MyHash<K, V> {
    private ArrayList<KeyValue<K, V>>[] list;
    private int size = 0;

    public MyHash() {
        initialisiereListe(10);
    }

    private void initialisiereListe(int size) {
        list = new ArrayList[size];
        for (int i = 0; i < list.length; ++i) {
            list[i] = new ArrayList<>();
        }
    }

    private void verdoppleTeillisten() {
        ArrayList<KeyValue<K, V>>[] tmp = list;
        initialisiereListe(tmp.length * 2);

        for (ArrayList<KeyValue<K, V>> teilliste : tmp) {
            for (KeyValue<K, V> pair : teilliste) {
                add(pair.getKey(), pair.getValue());
            }
        }
    }

    public boolean add(K key, V value) {
        ++size;
        if (size / list.length > 2) {
            verdoppleTeillisten();
        }
        ArrayList<KeyValue<K, V>> teilliste = list[hash(key)];
        for (KeyValue<K, V> pair : teilliste) {
            if (pair.getKey().equals(key)) {
                pair.setValue(value);
                return true;
            }
        }
        list[hash(key)].add(new KeyValue<>(key, value));
        return false;
    }

    public V get(K key) {
        ArrayList<KeyValue<K, V>> teilliste = list[hash(key)];
        for (KeyValue<K, V> pair : teilliste) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        return null;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % list.length;
    }
}
