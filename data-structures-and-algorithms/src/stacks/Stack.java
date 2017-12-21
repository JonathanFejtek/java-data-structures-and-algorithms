package stacks;

import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> items = new ArrayList<>();

    public int size(){
        return items.size();
    }

    public T pop(){
        return items.remove(items.size()-1);
    }

    public void push(T item){
        items.add(item);
    }

    public boolean contains(T item){
        return items.contains(item);
    }

    public T peek(){
        return items.get(items.size()-1);
    }
}
