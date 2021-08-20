package linkedList;

import java.util.Stack;

/**
 * @Description TODO
 * @Tag
 * @Date 2021/8/18
 */

public class SwapNodesInPairs_24 {
    public static void main(String[] argus) {
        int[] nums = {1, 2, 3, 4,5,6};
        ListNode head = ListNode.initList(nums);
        head = swapPairs(head);
        ListNode.printList(head);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        ListNode p = new ListNode();
        head = p;
        Stack<ListNode> stack = new Stack<>();
        if(cur != null && cur.next !=null) {
            stack.add(cur);
            stack.add(cur.next);

            cur = cur.next.next;

            p.next = stack.pop();
            p = p.next;
            p.next = stack.pop();
            p = p.next;
        }
        return head.next;
    }
}
