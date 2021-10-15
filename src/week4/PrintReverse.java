package week4;


public class PrintReverse {
    class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

    }

    class Result {

        public static void reversePrint(SinglyLinkedListNode llist) {
            if (llist.next != null) {
                reversePrint(llist.next);
            }
            System.out.println(llist.data);
        }

    }

}
