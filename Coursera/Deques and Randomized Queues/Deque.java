import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int n;
    private Node first;
    private Node last;
    private Node oldLast;
    
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }
    
    public Deque() {
        first = null;
         n = 0;
        assert check();
        
    }
    
    public boolean isEmpty()  {
        return n == 0;
    }
    
    public int size() {
        return n;
    }

    public void addFirst(Item item)  {
        if (item == null) throw new NullPointerException();
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.prev = null;
        if (isEmpty()) {
            first.next = null;
            last = first;
        }
        else {
            first.next = oldfirst;
            oldfirst.prev = first;
        }
        n++;   
    }
    public void addLast(Item item) {
        if (item == null) throw new NullPointerException();
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            last.prev = null;
            first = last;
        }
        else {
            oldlast.next = last;
            last.prev = oldlast;
        }
        n++;
    }
    public Item removeFirst()   {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        Item item = first.item;
        first = first.next;        
        n--;
        if (isEmpty()) last = null; 
        else first.prev = null;
        return item;
    }
    
    public Item removeLast()  {
        if (isEmpty()) throw new NoSuchElementException("Deque underflow");
        Item item = last.item;
        last = last.prev;        
        n--;
        if (isEmpty()) first = null;    // to avoid loitering
        else last.next = null;
        return item;
        
    }
    
     private boolean check() {

        // check a few properties of instance variable 'first'
        if (n < 0) {
            return false;
        }
        if (n == 0) {
            if (first != null) return false;
        }
        else if (n == 1) {
            if (first == null)      return false;
            if (first.next != null) return false;
        }
        else {
            if (first == null)      return false;
            if (first.next == null) return false;
        }

        // check internal consistency of instance variable n
        int numberOfNodes = 0;
        for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != n) return false;

        return true;
    }
     public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext()  {
            return current != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }

    public static void main(String[] args) {
        Deque n = new Deque();
        n.addFirst("hello");
        StdOut.println(n.removeLast());
    }
}
