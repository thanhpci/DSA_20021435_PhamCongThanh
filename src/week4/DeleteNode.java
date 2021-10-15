package week4;

public class DeleteNode {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public PrintReverse.SinglyLinkedListNode head;
        public PrintReverse.SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

    }

    public SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {

        SinglyLinkedListNode cur = llist;

        if (position == 0) return llist.next;
        else {
            for (int i = 0; i < (position - 1); i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return llist;
    }
}