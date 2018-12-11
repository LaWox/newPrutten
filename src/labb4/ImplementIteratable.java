package labb4;

import java.util.Iterator;

public class ImplementIteratable extends Composite implements Iterable, Iterator{

    ImplementIteratable(double weight, String name){
        super(weight, name);
    }

    public Iterator iterator() {
        return null;
    }

    public boolean hasNext() {
        return false;
    }

    public Object next() {
        return null;
    }
}
