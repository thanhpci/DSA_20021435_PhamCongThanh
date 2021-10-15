package week4;

public class GetNodeValue {
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

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {

        SinglyLinkedListNode nodeFromTail = llist;
        SinglyLinkedListNode nodeFromHead = llist;

        for (int i = 0; i < positionFromTail; i++) {
            nodeFromHead = nodeFromHead.next;
        }

        while (nodeFromHead.next != null) {
            nodeFromTail = nodeFromTail.next;
            nodeFromHead = nodeFromHead.next;
        }

        return nodeFromTail.data;

    }
}
