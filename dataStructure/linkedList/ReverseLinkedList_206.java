package linkedList;

/**
 * @Description 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @Tag 链表基本操作
 * @Date 2021/8/18
 */

public class ReverseLinkedList_206 {
    public static void main(String[] argus) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.initList(nums);
        head = reverseList1(head);
        ListNode.printList(head);
    }

    public static ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        if(head.next.next == null) {
            ListNode node = head.next;
            node.next = head;
            head.next = null;
            return node;
        }

        boolean ifFirst = true;
        ListNode cur = head.next;
        ListNode prev = head.next.next;

        while(prev != null) {
            cur.next = head;
            if (ifFirst) {
                head.next = null;
                ifFirst = false;
            }
            head = cur;
            cur = prev;
            prev = prev.next;
        }
        cur.next = head;

        return cur;
    }
}