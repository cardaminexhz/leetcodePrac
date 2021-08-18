package linkedList;

/**
 * @Description 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @Tag 链表基本操作
 * @Date 2021/8/18
 */

public class MergeTwoSortedList_21 {
    public static void main(String[] argus) {
        int[] elems1 = {1};
        int[] elems2 = {0};
        ListNode h1 = ListNode.initList(elems1);
        ListNode h2 = ListNode.initList(elems2);
        ListNode newHead = mergeTwoLists(h1, h2);
        ListNode.printList(newHead);
    }

    public static ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        while(h1 != null && h2 != null) {
            if(h1.val <= h2.val) {
                cur.next = h1;
                h1 = h1.next;
            } else {
                cur.next = h2;
                h2 = h2.next;
            }
            cur = cur.next;
        }
        cur.next = (h1 != null) ? h1 : h2;
        return head.next;
    }
}