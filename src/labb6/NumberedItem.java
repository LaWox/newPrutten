package labb6;

public class NumberedItem<T> implements Comparable<NumberedItem>{
    T type;
    int i;

    NumberedItem(int nr, T type){
        this.i = nr;
        if(nr < 0){
            this.i = 0;
        }
        this.type = type;
    }

    public String toString(){
        return this.type + " : " + this.i;
    }

    public int compareTo(NumberedItem other){
        return this.i - other.i;
    }

    public boolean equals(NumberedItem other){
        return this.i == other.i;
    }


    public static void main(String[] args){

    }

}
