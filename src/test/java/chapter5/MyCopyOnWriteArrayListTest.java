package chapter5;

import org.junit.Test;

import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.*;

public class MyCopyOnWriteArrayListTest {

    @Test
    public void testAddItem() throws Exception {
        MyCopyOnWriteArrayList<Integer> numbers = new MyCopyOnWriteArrayList();
        Object[] expected = new Object[] {
                Integer.valueOf(3),
                Integer.valueOf(5),
                Integer.valueOf(8),
                Integer.valueOf(9)
        };
        for (Object number: expected) {
            numbers.add((Integer) number);
        }
        assertArrayEquals(expected, numbers.toArray());
    }

    @Test
    public void testAdd2() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testSize() throws Exception {

    }
}