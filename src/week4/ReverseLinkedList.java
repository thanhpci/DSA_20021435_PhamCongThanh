package week4;

import week4.PrintReverse;

public class ReverseLinkedList {
    class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }
    }

    class Result {

        public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
            if (llist == null || llist.next == null) {
                return llist;
            } else {
                SinglyLinkedListNode newhead = reverse(llist.next);
                llist.next.next = llist;
                llist.next = null;
                return newhead;
            }

        }

    }


}
