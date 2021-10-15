package week4;

public class MergeTwoSortedLinkedLists {
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

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        SinglyLinkedListNode head = null;
        if (head1.data < head2.data) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }

        SinglyLinkedListNode n = head;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                n.next = head1;
                head1 = head1.next;
            } else {
                n.next = head2;
                head2 = head2.next;
            }
            n = n.next;
        }
        if (head1 == null) {
            n.next = head2;
        } else {
            n.next = head1;
        }
        return head;

    }
}
