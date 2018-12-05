package labb6;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OurSparceVectorTest {





    @Test
    public void testEmpty(){
        OurSparseVector<String> a1=new OurSparseVector<String>();
        assertEquals(0, a1.size());
        assertEquals(-1, a1.minIndex());
        assertEquals(-1, a1.maxIndex());
        assertEquals(null, a1.get(0));

    }

    @Test
    public void testIndex(){
        OurSparseVector<String> a1 = new OurSparseVector<String>();
        Integer[] list = new Integer[] {1, 0, 3, 8, 1, 0};
        String[] slist= new String[]{"hej", "hu", "gräs", "valle", "skön", "kille"};
        for (int k=0; k<slist.length; k++){
            a1.add(list[k], slist[k]);
        }
        a1.add("kompis");
        assertEquals("skön", a1.get(1));
        assertEquals("kille", a1.get(0));
        assertEquals("valle", a1.get(8));
        assertEquals(5, a1.size());
        assertEquals("kompis", a1.get(2));
    }

    @Test
    public void testRemove(){
        OurSparseVector<String> a1 = new OurSparseVector<String>();
        a1.add(0, "hej");
        a1.add(1, "nej");
        a1.add(2, "nej");
        assertEquals(3, a1.size());
        a1.removeAt(0);
        assertNull(a1.get(0));
        a1.removeElem("nej");
        assertEquals("nej", a1.get(2));
        assertEquals(1, a1.size());

    }

    @Test
    public void testToString(){
        OurSparseVector<String> a1 = new OurSparseVector<String>();
        a1.add(0, "hej");
        a1.add(1, "nej");
        System.out.println(a1.toString());

    }

    public static void main(String[] args){
        OurSparceVectorTest test = new OurSparceVectorTest();
        test.testEmpty();
        test.testIndex();
        test.testRemove();
        test.testToString();
        System.out.println("-------End of test-------");
    }
}
