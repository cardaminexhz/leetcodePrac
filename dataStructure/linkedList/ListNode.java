package linkedList;

/**
 * @Description
 * @Tag
 * @Date 2021/8/18
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode initList(int[] elems) {
        ListNode head = new ListNode(elems[0], null);
        ListNode cur = head;
        for (int i = 1; i < elems.length; i++) {
            ListNode node = new ListNode(elems[i], null);
            cur.next = node;
            cur = cur.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
