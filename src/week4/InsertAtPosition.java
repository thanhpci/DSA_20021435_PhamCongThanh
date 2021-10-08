package week4;

public class InsertAtPosition {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        SinglyLinkedListNode temp = new SinglyLinkedListNode(data);
        temp.next = null;

        if (llist == null) {
            llist = temp;
            temp.next = null;
            return llist;
        }

        SinglyLinkedListNode cur = llist;

        if (position == 0) {
            temp.next = llist.next;
            temp = llist;
            return llist;
        } else {
            for (int i = 0; i < (position - 1); i++) {
                cur = cur.next;
            }
            temp.next = cur.next;
            cur.next = temp;
            return llist;
        }
    }

}
