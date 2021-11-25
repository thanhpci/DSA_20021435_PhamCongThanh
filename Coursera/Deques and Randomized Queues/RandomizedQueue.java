import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdOut;
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] a;
    private int n;
    public RandomizedQueue() {
        a = (Item[]) new Object[2];
        n = 0; 
    }
    
    public boolean isEmpty() {
        return n ==0;
    }
    
    public int size() {
        return n;
    }
    
    private void resize(int capacity) {
        assert capacity >= n;
        
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
    
    public void enqueue(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException("null item");
        }
        if (n == a.length) {
            resize(2*a.length);
    }
                    a[n++] = item;
    }
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        }
        exchange(a, StdRandom.uniform(n), --n);
        Item item = a[n];        
        a[n] = null;
        if (n > 0 && n <= a.length/4) {
            resize(a.length/2);
        }
        return item;
    }
    
    private void exchange(Item[] q, int i, int j) {
        if (i == j) return;
        Item swap = q[i];
        q[i] = q[j];
        q[j] = swap;
    }
    
    public Item  sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        }
        return a[StdRandom.uniform(n)];
    }
    
   public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = n-1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
    }
    
    public static void main(String[] args) {

    }
    
    
    
    
}
