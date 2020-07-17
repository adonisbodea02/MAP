package Model.ADTs;
import Exceptions.MyDictionaryException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyDictionary<K,V> implements MyIDictionary<K,V> {

    private Map<K, V> dict;

    public MyDictionary(){
        this.dict = new HashMap<>();
    }

    @Override
    public V lookup(K key) {
        if(isDefined(key))
            return dict.get(key);
        else
            throw new MyDictionaryException();
    }

    @Override
    public boolean isDefined(K key) {
        return dict.containsKey(key);
    }

    @Override
    public void add(K key, V value) {
        dict.put(key, value);
    }

    @Override
    public void update(K key, V value) {
        if(isDefined(key))
            dict.put(key, value);
        else
            throw new MyDictionaryException();
    }

    @Override
    public int size() {
        return dict.size();
    }

    @Override
    public String toString() {
        return dict.toString();
    }

    @Override
    public Set<K> getKeys(){
        return dict.keySet();
    }

    @Override
    public Collection<V> getValues(){return dict.values();}

    @Override
    public void remove(K key){
        dict.remove(key);
    }

    @Override
    public Set<Map.Entry<K,V>> entrySet(){
        return dict.entrySet();
    }

    @Override
    public void clear(){
        dict.clear();
    }

    @Override
    public void putAll(Map<K,V> m){
        dict.putAll(m);
    }

    @Override
    public MyIDictionary<K,V> cloneAll(){
        MyIDictionary<K, V> clone = new MyDictionary<>();
        for(Map.Entry<K,V> entry : this.dict.entrySet()){
            clone.add(entry.getKey(), entry.getValue());
        }
        return clone;
    }
}
