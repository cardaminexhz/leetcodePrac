package linkedList;

/**
 * @Description TODO
 * @Tag
 * @Date 2021/8/18
 */

public class SwapNodesInPairs_24 {
    public static void main(String[] argus) {
        int[] nums = {1, 2, 3, 4};
        ListNode head = ListNode.initList(nums);
        head = swapPairs(head);
        ListNode.printList(head);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode();
        h.next = head;
        ListNode cur = head;
        ListNode prev = cur.next;
        boolean ifFirst = true;;
        while(cur.next != null) {
            cur.next = prev.next;
            prev.next = cur;

            head.next = prev;
            head = head.next.next;

            cur = cur.next;
            prev = cur.next;
        }
        return head;
    }
}
