package trees;

import java.io.Serializable;
import java.util.ArrayList;

public class BinaryTree<T> {
    private T data;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree(){}

    public BinaryTree(T item){
        this.data = item;
        if(item == null){
            this.left = null;
            this.right = null;
        }
        else{
            this.left = new BinaryTree<>();
            this.right = new BinaryTree<>();
        }

    }

    public T getData(){
        return this.data;
    }

    public boolean isEmpty(){
        return (this.data == null);
    }

    public void insert(T item){
        if(this.isEmpty()){
            this.data = item;
            this.left = new BinaryTree<>();
            this.right = new BinaryTree<>();
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

//    public void delete(T item){
//        if(!this.isEmpty()){
//            if(this.data.equals(item)){
//                this.deleteRoot();
//            }
//        }
//    }
//
//    private T deleteRoot(){
//
//        if(this.isEmpty()){
//            return this.data;
//        }
//
//        else if(isLeaf()){
//            T temp = this.data;
//            this.data = null;
//            this.left = null;
//            this.right = null;
//            return temp;
//        }
//
//        else{
//            if(!right.isEmpty()){
//                return right.deleteRoot();
//            }
//
//            return left.deleteRoot();
//
//        }
//    }

    public ArrayList<T> inOrder(){

        if(isLeaf()){
            ArrayList<T> vals = new ArrayList<T>();
            vals.add(this.data);
            return vals;
        }

        else{
            ArrayList<T> vals = new ArrayList<>();
            vals.addAll(left.inOrder());
            vals.add(this.data);
            vals.addAll(right.inOrder());
            return vals;
        }
    }

    public boolean isLeaf(){
        return (left.isEmpty() && right.isEmpty());
    }

}
