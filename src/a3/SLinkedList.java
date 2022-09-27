package a3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of {@code LList<T>} as a singly linked list.
 */
public class SLinkedList<T> implements LList<T> {

    /**
     * Number of values in the linked list.
     */
    private int size;
    /**
     * First and last nodes of the linked list (null if size is 0)
     */
    private Node<T> head, tail;

    /**
     * Creates: an empty linked list.
     */
    public SLinkedList() {
        size = 0;
        head = tail = null;
    }

    boolean classInv() {
        assert size >= 0;
        if (size == 0) {
            return (head == null && tail == null);
        }
        // TODO
        return true;
    }

    public int size() {
        return size;
    }

    public T head() {
        return head.data();
    }

    public T tail() {
        return tail.data();
    }

    public void prepend(T v) {
        assert classInv();
        Node<T> n = new Node<>(v, head);
        head = n;
        if (tail == null) tail = head;
        size++;
        assert classInv();
    }


    /**
     * Return a representation of this list: its values, with "[" at the beginning, "]" at the
     * end, and adjacent ones separated by ", " . Takes time proportional to the length of this
     * list. E.g. for the list containing 4 7 8 in that order, the result it "[4, 7, 8]".
     * E.g. for the list containing two empty strings, the result is "[, ]"
     */
    @Override
    public String toString() {
        // Do not modify the following 2 lines or the return statement
        assert classInv();
        StringBuilder res = new StringBuilder("[");
        Node<T> n = head;
        while(n.next()!= null) {
            res.append(n.data().toString()+ ", ");
            n=n.next();

        }
        return res + "]";
    }

    public void append(T v) {
        Node<T> i= new Node<T>(v, null);
        if (size!=0){
            tail.setNext(i);
            tail= i;
        }
        else head=i;
    }

    public void insertBefore(T x, T y) {
        Node<T> n= head;
        while (n!=null) {
            if (y.equals(n.data())) {
                Node<T> i= new Node<T>(x, n);
            }
        }

        }


        //since there is a precondition that y is in the list, we don't have to handle the case of the empty list


    public T get(int k) {
        Node<T> n= head;
        for(int i=0; i<k; i++) {
            n=n.next();
        }
        return n.data();
    }

    public boolean contains(T value) {
        Node<T> n=head;
        while(n!=null) {
            if(value.equals(n.data())) return true;
            n=n.next();
        }
        return false;
    }

    public boolean remove(T x) {
        Node n = head, push = null;
        while (n != null && !x.equals(n.data())) {
            push = n;
            n = n.next();
        }
        if (n == null) {
            return false;
        }
        if (push == null) {
            head = n.next();
        } else
            push.setNext(n.next());
        return true;

    }


    /**
     * Iterator support. This method makes it possible to write
     * a for-loop over a list, e.g.:
     * <pre>
     * {@code LList<String> lst = ... ;}
     * {@code for (String s : lst) {}
     *   ... use s here ...
     * }
     * }
     */
    @Override
    public Iterator<T> iterator() {
        assert classInv();
        return new Iterator<T>() {
            private Node<T> current = head;

            public T next() throws NoSuchElementException {
                if (current != null) {
                    T result = current.data();
                    current = current.next();
                    return result;
                } else {
                    throw new NoSuchElementException();
                }
            }

            public boolean hasNext() {
                return (current != null);
            }
        };
    }
}
