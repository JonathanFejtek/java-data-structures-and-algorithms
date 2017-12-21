package maps;

import java.util.ArrayList;

public class MultiBiMap <K,V> {
    private MultiMap<K,V> kToV = new MultiMap<>();
    private MultiMap<V,K> vToK = new MultiMap<>();

    public void put(K key, V value){
        kToV.put(key,value);
        vToK.put(value,key);
    }

    public void put(K key, V[] values){
        for(V v : values.clone()){
            kToV.put(key,v);
            vToK.put(v,key);
        }
    }

    public void put(K[] keys, V value){
        for(K k : keys.clone()){
            kToV.put(k,value);
            vToK.put(value,k);
        }
    }

    public void put(K[] keys, V[] values){
        for(K k : keys.clone()){
            for(V v : values.clone()){
                this.put(k,v);
            }
        }
    }

    public ArrayList<V> getForward(K key){
        return kToV.get(key);
    }

    public ArrayList<K> getBackward(V value){
        return vToK.get(value);
    }

    public String toString(){
        return kToV.toString() + "\n" + vToK.toString();
    }

}