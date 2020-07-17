package Model.ADTs;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface MyIDictionary<K,V> {
    V lookup(K key);
    boolean isDefined(K key);
    void add(K key, V value);
    void update(K key, V value);
    int size();
    Set<K> getKeys();
    Collection<V> getValues();
    void remove(K key);
    Set<Map.Entry<K,V>> entrySet();
    void clear();
    void putAll(Map<K, V> m);
    MyIDictionary<K, V> cloneAll();
}
