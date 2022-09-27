package a3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SLinkedListTest {
    @Test
    void emptyList() {
        LList<Integer> lst0 = new SLinkedList<>();
        assertEquals(lst0.size(), 0);
    }
    @Test
    void append12() {
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(42);
        assertEquals(l1.size(), 1);
        assertEquals(l1.head(), 42);
        assertEquals(l1.tail(), 42);
        l1.append(21);
        assertEquals(l1.size(), 2);
        assertEquals(l1.head(), 42);
        assertEquals(l1.tail(), 21);
    }
    @Test
    void prepend12() {
        LList<Integer> l1 = new SLinkedList<Integer>();
        l1.prepend(42);
        assertEquals(l1.size(), 1);
        assertEquals(l1.head(), 42);
        assertEquals(l1.tail(), 42);
        l1.prepend(21);
        assertEquals(l1.size(), 2);
        assertEquals(l1.head(), 21);
        assertEquals(l1.tail(), 42);
    }

    @Test
    void test_get() {
        LList<Integer> lst = new SLinkedList<>();
        for (int i = 0; i < 5; i++) lst.append(i);
        assertEquals(lst.size(), 5);
        for (int i = 0; i < 5; i++) {
            assertEquals(i, lst.get(i));
            lst.append(i);
        }
    }

    @Test
    void test_toString() {
        LList<String> l1 = new SLinkedList<>();
        l1.append('1');
        l1.append('2');
        l1.append('3');
        l1.append('4');
        //normal case
        l1.toString();
        assertEquals(l1.length(), 4);
        assertEquals(l1, "[1, 2, 3, 4]")

        //case where it contains two empty strings
        LList<String> l2 = new SLinkedList<>();
        l2.append('');
        l2.append('');
        l2.toString();
        assertEquals(l1.length(), 2);
        assertEquals(l2, "[, ]");

        //case where it contains one string
        LList<String> l3 = new SLinkedList<>();
        l3.append('1');
        l3.toString();
        assertEquals(l3.length(), 1);
        assertEquals(l3, "[1]")
    }


    @Test
    void test_remove() {
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(1);
        l1.append(2);
        l1.append(3);
        l1.append(4);
        //normal case
        l1.remove(1);
        assertEquals(l1.size(), 3);
        assertEquals(l1.head(), 2);
        assertEquals(l1.tail(), 4);
        //test case for more than one item in the list with value of x
        LList<Integer> l2 = new SLinkedList<>();
        l2.append(1);
        l2.append(4);
        l2.append(3);
        l2.append(4);
        l2.remove(4);
        assertEquals(l2.size(), 3);
        assertEquals(l2.head(), 1);
        assertEquals(l2.tail(), 3);
    }


    @Test
    void test_insertBefore(){
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(1);
        l1.append(2);
        l1.append(4);
        l1.append(5);
        //normal case
        l1.insertBefore(3, 4);
        assertEquals(l1.size(), 5);
        assertEquals(l1.head(), 1);
        assertEquals(l1.tail(), 5);
        assertEquals(l1, [1, 2, 3, 4, 5])

        //y is the only element in the list
        LList<Integer> l2 = new SLinkedList<>();
        l2.append(2);
        l2.insertBefore(1, 2);
        assertEquals(l2.size(), 2);
        assertEquals(l2.head(), 1);
        assertEquals(l2.tail(), 2);

        //x is the same as y
        LList<Integer> l3 = new SLinkedList<>();
        l3.append(2);
        l3.insertBefore(2, 2);
        assertEquals(l3.size(), 2);
        assertEquals(l3.head(), 2);
        assertEquals(l3.tail(), 2);
    }

    @Test
    void testContains1() {
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(1);
        l1.append(2);
        l1.append(4);
        l1.append(5);
        //normal case where it contains the elem
        assertEquals(l1.contains(2), true)
        //normal case where it does not contains the elem
        assertEquals(l1.contains(6), false)

        //the list is empty
        LList<Integer> l2 = new SLinkedList<>();
        assertEquals(l2.contains(2), false)
    }

    @Test
    void testContains2() {
        LList<Integer> l1 = new SLinkedList<>();
        l1.append(1);
        l1.append(2);
        l1.append(4);
        l1.append(5);

    }
}