package trees;

import java.io.Serializable;
import java.util.ArrayList;

public class BinaryTree<T> {
    private T data;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree(T item){
        this.data = item;
        if(item == null){
            this.left = null;
            this.right = null;
        }
        else{
            this.left = new BinaryTree<>(null);
            this.right = new BinaryTree<>(null);
        }

    }

    public T getData(){
        return this.data;
    }

    public static void main(String[] args){
        BinaryTree<String> bt = new BinaryTree<>("A");
        bt.insert("B");
        bt.insert("C");
        System.out.println(bt.inOrder());
        bt.delete("A");
        System.out.println(bt.inOrder());

        bt.delete("B");
        System.out.println(bt.inOrder());

    }

    public boolean isEmpty(){
        return (this.data == null);
    }

    public void insert(T item){
        if(this.isEmpty()){
            this.data = item;
            this.left = new BinaryTree<>(null);
            this.right = new BinaryTree<>(null);
        }

        else{
            if(this.left.isEmpty()){
                this.left.insert(item);
            }
            else{
                this.right.insert(item);
            }
        }
    }


    public void delete(T item){
        if(item.equals(this.data)){
            this.deleteNode();
        }

        else{
            if(!this.left.isEmpty()){
                this.left.delete(item);
            }
            if(!this.right.isEmpty()){
                this.right.delete(item);
            }
        }
    }

    public void deleteNode(){
        if(this.isEmpty()){
            return;
        }
        else if(this.right.isEmpty()){
            this.data = this.left.extractLeaf();
        }
        else{
            this.data = this.right.extractLeaf();
        }
    }

    public T extractLeaf(){
        if(this.isEmpty()){
            return null;
        }
        else if(this.right.isEmpty()){
            T temp = this.data;
            this.right = this.left.right;
            this.data = this.left.data;
            this.left = this.left.left;
            return temp;
        }
        else{
            return this.right.extractLeaf();
        }

    }

    public ArrayList<T> inOrder(){
            ArrayList<T> vals = new ArrayList<>();
            if(isEmpty()){
                return vals;
            }

            else{
                vals.addAll(left.inOrder());
                vals.add(this.data);
                vals.addAll(right.inOrder());
            }
            return vals;
    }

    public ArrayList<T> postOrder(){
        ArrayList<T> vals = new ArrayList<>();
        if(isEmpty()){
            return vals;
        }

        else{
            vals.addAll(left.postOrder());
            vals.addAll(right.postOrder());
            vals.add(this.data);

        }
        return vals;
    }

    public ArrayList<T> preOrder(){
        ArrayList<T> vals = new ArrayList<>();
        if(isEmpty()){
            return vals;
        }

        else{
            vals.add(this.data);
            vals.addAll(left.preOrder());
            vals.addAll(right.preOrder());
        }
        return vals;
    }

}
