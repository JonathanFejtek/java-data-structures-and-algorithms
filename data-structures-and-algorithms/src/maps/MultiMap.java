package maps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class MultiMap <K,V>{
    private HashMap<K,ArrayList<V>> multiMap = new HashMap<>();

    public void put(K key, V value){
        if(!multiMap.containsKey(key)){
            multiMap.put(key,new ArrayList<>());
        }
        multiMap.get(key).add(value);
    }

    public void remove(K key, V value){
        if(multiMap.containsKey(key)){
            ArrayList<V> list = multiMap.get(key);
            if(list.contains(value)){
                list.remove(value);
            }
        }
    }

    public ArrayList<V> get(K key){
        if(multiMap.containsKey(key)){
            return multiMap.get(key);
        }
        return null;
    }

    public Set<K> getAllKeys(){
        return multiMap.keySet();
    }

    public Collection<ArrayList<V>> getAllValues(){
        return multiMap.values();
    }

    public void clearKey(K key){
        if(multiMap.containsKey(key)){
            multiMap.get(key).clear();
        }
    }

    public void clearValues(){
        for(K key : multiMap.keySet()) {
            multiMap.put(key, null);
        }
    }

    public void clear(){
        multiMap.clear();
    }

    public String toString(){
        String toString = "";
        for(K key : multiMap.keySet()){
            toString += key.toString() + " --> "+ multiMap.get(key).toString() + "\n";
        }
        return toString;
    }
}