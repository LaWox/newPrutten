package labb6;

import java.util.NoSuchElementException;
import java.util.TreeMap;

public class OurSparseVector2B<E> extends TreeMap<Integer, E> implements SparseVector<E> {


    OurSparseVector2B(){
        super();
    }

    public void add(E element){
        int counter = 0;
        while(true){
            if(!this.containsKey(counter)){
                this.put(counter, element);
                return;
            }
            counter ++;
        }
    }

    public void add(int i, E element){
        if(i < 0){
            i = 0;
        }
        this.put(i,  element);
    }

    //funkar om keys är i ordning!
    public int indexOf(E elem) {
        for(int i: this.keySet()){
            if(this.get(i).equals(elem)){
                return i;
            }
        }
        return -1;
    }

    public void removeAt(int pos) {
        this.remove(pos);
    }

    public void removeElem(E elem) {
        this.removeAt(this.indexOf(elem));
    }

    public int size() {
        return this.size();
    }

    public int minIndex() {
        try
        {
        return this.firstKey();
        }
        catch (NoSuchElementException e){
            return -1;
        }
    }

    public int maxIndex() {

        try {
            return this.lastKey();
        }
        catch(NoSuchElementException e){
            return -1;
        }
    }

    public E get(int pos) {
        return this.get(pos);
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        for(int i: this.keySet()){
            string.append(i +" : "+ this.get(i).toString() + "\n");
        }
        return string.toString();
    }
}
