package now.in.jvm;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(val);
        ListNode node = next;
        while (node != null) {
            stringBuilder.append(',').append(node.val);
            node = node.next;
        }
        return stringBuilder.toString();
    }

    public static ListNode from(int[] a) {
        ListNode node = null;
        ListNode head = null;
        
        for (int i : a) {
            if (node == null) {
                node = new ListNode(i);
                head = node;
            } else {
                node.next = new ListNode(i);
                node = node.next;
            }
        }

        return head;
    }
}