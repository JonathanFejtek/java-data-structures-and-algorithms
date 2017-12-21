package trees;

import java.util.ArrayList;

public class Tree<T> {
    private Tree<T> parent;
    private ArrayList<Tree<T>> children = new ArrayList<>();
    private T data;

    public Tree(){

    }

    public Tree(T item){
        this.data = item;
    }

    public Tree(Tree<T> parent){
        this.parent = parent;
    }

    public Tree(Tree<T> parent,ArrayList<Tree<T>> children){
        this.parent = parent;
        this.children = children;
    }

    public void setParent(Tree<T> parent){
        this.parent = parent;
    }

    public void setData(T item){
        this.data = item;
    }

    public void addChild(Tree<T> child){
        this.children.add(child);
        child.setParent(this);
    }

    public void removeChild(Tree<T> child){
        this.children.remove(child);
    }

    public boolean contains(T item){
        if(item.equals(this.data)){
            return true;
        }

        else{
            for(Tree<T> child : this.children){
                if(child.contains(item)){
                    return true;
                }
            }
            return false;
        }
    }

    public int size(){
        int size = 1;
        for(Tree<T> child : this.children){
            size += child.size();
        }
        return size;
    }

    public ArrayList<T> getFlattened(){
        ArrayList<T> items = new ArrayList<>();

        items.add(this.data);

        for(Tree<T> child : children){
            items.addAll(child.getFlattened());
        }

        return items;
    }

    public boolean isLeaf(){
        return this.children.size() == 0;
    }

    public boolean hasChildren(){
        return this.children.size() > 0;
    }

    public int getHeight(){
        if(this.isLeaf()){
            return 0;
        }

        else{
            int height = 1;
            int highest = 0;

            for(Tree<T> child : this.children) {
                if(child.getHeight()>highest){
                    highest = child.getHeight();
                }
            }

            return height+highest;
        }
    }

    public int getWidth(int level){
        if(level == 1){
            return 1;
        }

        else{
            int width = 0;
            for(Tree<T> child : children){
                width += child.getWidth(level-1);
            }
            return width;
        }

    }

    public int getMaxWidth(){
        if(isLeaf()){
            return 1;
        }
        else{
            int height = this.getHeight();
            int max = 0;
            for(int i = 1; i < height; i++){
                int w = getWidth(i);
                if(w>max){
                    max = w;
                }
            }
            return max;
        }
    }

    public int getMaxDegree(){
        if(isLeaf()){
            return 0;
        }

        else{
            int maxDegree = this.getDegree();
            for(Tree<T> child : children){
                int degree = child.getMaxDegree();
                if(degree > maxDegree){
                    maxDegree = degree;
                }
            }
            return maxDegree;
        }
    }

    public Tree<T> getRoot(){
        if(!this.hasParent()){
            return this;
        }
        else{
            Tree<T> treeToCheck = this;

            while(treeToCheck.hasParent()){
                treeToCheck = treeToCheck.getParent();
            }
            return treeToCheck;
        }
    }

    public Tree<T> getParent(){
        return this.parent;
    }

    public boolean hasParent(){
        return !(this.parent == null);
    }

    public String toString(){
        String s = "--<" + this.data.toString() + ">--";

//        for(Tree<T> child : children){
//            s += "\n" + "    " + child.toString(1);
//        }
        return s;
    }

    public String toString(int level){
        String space = "";
        for(int i = 0; i < level; i++){
            space += "    ";
        }
        String s = "<"+  this.data.toString() + ">";

        for(Tree<T> child : children){
            s += "\n" + space + child.toString(level+1);
        }

        return s;
    }

    public ArrayList<Tree<T>> getInternalNodes(){
        if(!this.hasChildren()){
            return new ArrayList<Tree<T>>();
        }
        else{
            ArrayList<Tree<T>> internalNodes = new ArrayList<>();
            internalNodes.add(this);

            for(Tree<T> child : children){
                internalNodes.addAll(child.getInternalNodes());
            }

            return internalNodes;
        }
    }

    public ArrayList<Tree<T>> getChildren(){
        return this.children;
    }

    public int getDegree(){
        return this.children.size();
    }

    //todo : finish -- requires partitioning conditions since this isn't a binary tree
    public ArrayList<T> valuesInOrder(){
        if(isLeaf()){
            ArrayList<T> values = new ArrayList<>();
            values.add(this.data);
            return values;
        }

        else{
            ArrayList<T> values = new ArrayList<>();
            return null;
        }
    }


}
