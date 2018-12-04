package labb6;

import java.util.TreeMap;

public class OurSparseVector<E> implements SparseVector<E> {

    TreeMap<Integer, E> map;

    OurSparseVector(E type){
        this.map = new TreeMap<>();
    }

    public void add(E element){
        int counter = 0;
        while(true){
            if(!map.containsKey(counter)){
                map.put(counter, element);
                return;
            }
            counter ++;
        }
    }

    public void add(int i, E element){
        if(i < 0){
            i = 0;
        }
        this.map.put(i,  element);
    }

    //funkar om keys är i ordning!
    public int indexOf(E elem) {
        for(int i: this.map.keySet()){
            if(this.map.get(i).equals(elem)){
                return i;
            }
        }
        return -1;
    }

    public void removeAt(int pos) {
        this.map.remove(pos);
    }

    public void removeElem(E elem) {
        this.removeAt(this.indexOf(elem));
    }

    public int size() {
        return this.map.size();
    }

    public int minIndex() {
        return this.map.firstKey();
    }

    public int maxIndex() {
        return this.map.lastKey();
    }

    public E get(int pos) {
        return this.map.get(pos);
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        for(int i: this.map.keySet()){
            string.append(i + this.map.get(i).toString() + "\n");
        }
        return string.toString();
    }
}
