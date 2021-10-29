package week7;

public class PriorityQueue {
    private int realCapacity = 0;
    int[] arr;

    PriorityQueue(int capacity){
        arr = new int[capacity];
    }

    void insert(int x) {
        int i = 0;
        while (i < realCapacity && arr[i] > x){
            i++;
        }
        for(int j = realCapacity; j > i; j--){
            arr[j] = arr[j-1];
        }
        arr[i] = x;
        realCapacity++;
    }

    int deleteMin() {
        return arr[--realCapacity];
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(10);
        pq.insert(3);
        pq.insert(6);
        pq.insert(5);
        pq.insert(1);
        pq.insert(2);
        pq.insert(9);

        System.out.println(pq.deleteMin());
        System.out.println(pq.deleteMin());
        System.out.println(pq.deleteMin());
    }
}