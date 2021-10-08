package week4;

import edu.princeton.cs.algs4.*;

public class PrintLinkedList {

    public class SList {
        Node head;

        public void print() {
            Node p = head;
            while (p != null) {
                System.out.println(p.element);
                p = p.next;
            }
        }


        class Node{
            int element;
            Node next;

            public Node(int element) {
                this.element = element;
                next = null;
            }
        }
    }




    public static void main(String[] args) {
    }
}
