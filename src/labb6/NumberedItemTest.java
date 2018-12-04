package labb6;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberedItemTest {

    @Test
    public void testCompare() {
	NumberedItem<Integer> i1 = new NumberedItem<>(-1,1);
	NumberedItem<Integer> i2 = new NumberedItem<>(0,17);
	NumberedItem<Integer> i3 = new NumberedItem<>(5,100);
	NumberedItem<Integer> i4 = new NumberedItem<>(10,378);
	assertEquals(0, i1.compareTo(i2));
	assertEquals(-5, i3.compareTo(i4));
	assertEquals(5, i4.compareTo(i3));
    }

    @Test
    public void testEquals() {
	NumberedItem<Integer> i1 = new NumberedItem<>(-1,1);
	NumberedItem<Integer> i2 = new NumberedItem<>(0,1);
	NumberedItem<Integer> i3 = new NumberedItem<>(7,117);
	assertTrue(i1.equals(i2));
	assertFalse(i2.equals(i3));
    }

	public static void main(String[] args){
		NumberedItemTest test = new NumberedItemTest();
		test.testCompare();
		test.testEquals();
		System.out.println("testOK");
	}
}
