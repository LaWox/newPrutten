package labb6;

public interface SparseVector<E> {
    public void add(E elem);          // add at lowest positive index not it use
    public void add(int pos, E elem); // if pos is occupied, replace with elem, if pos<0, use 0
    public int indexOf(E elem);       // find first (lowest index) occurence of elem, return its index,
                                      // if not found, return -1
    public void removeAt(int pos);    // if index pos is not used, nothing happens
    public void removeElem(E elem);   // remove first occurence (lowest index) of elem
    public int size();
    public int minIndex();            // lowest index in use
    public int maxIndex();            // highest index in use
    public String toString();         // sorted by index
    public E get(int pos);            // return null if not available
}
