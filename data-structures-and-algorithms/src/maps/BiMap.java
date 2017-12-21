package maps;

import java.util.HashMap;

public class BiMap<K, V> {

    HashMap<K,V> kToV = new HashMap<>();
    HashMap<V,K> vToK = new HashMap<>();

    public BiMap(){}

    public void add(K key, V value){
        kToV.put(key,value);
        vToK.put(value,key);
    }

    public V getForward(K key){
        return kToV.get(key);
    }

    public K getBackward(V value) {
        return vToK.get(value);
    }

}
