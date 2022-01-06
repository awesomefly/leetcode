package main.java.com.leetcode;

public class LinkListReverse {
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;

        if (head == null) {
            return head;
        }

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverse2(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse2(head.next);

        head.next.next = head;
        head.next = null;

        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        ListNode cur = head;

        cur.next = new ListNode(2);
        cur = cur.next;

        cur.next = new ListNode(3);
        cur = cur.next;

        cur.next = new ListNode(4);
        cur = cur.next;

        cur.next = new ListNode(5);
        cur = cur.next;

        cur.next = null;


//        ListNode head1 = new LinkListReverse().reverse(head);
//        while (head1 != null) {
//            System.out.print(head1.val+",");
//            head1=head1.next;
//        }

        System.out.println("---------------");
        ListNode head2 = new LinkListReverse().reverse2(head);
        while (head2 != null) {
            System.out.print(head2.val+",");
            head2=head2.next;
        }

    }
}
