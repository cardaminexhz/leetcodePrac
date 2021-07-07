package doublePointer;

/**
 * @Description
 * 给定一个链表，如果有环路，找出环路的开始点
 * 第一次相遇时，a+n(b+c)+b=2(a+b) => a=(n-1)(b+c)+c，将fast移到head按1步长重新走，第二次会在环点相遇
 * @Tag 双指针，快慢指针
 * @Date 2021/7/7
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle2_142 {
    public static void main(String[] argus) {
        int[] elems = {1};
        int pos = -1;
        ListNode head = initListWithCycle(elems, pos);

        ListNode cycleStart = detectCycle(head);
        System.out.println(cycleStart.val);
    }

    public static ListNode initListWithCycle(int[] elems, int pos) {
        if(elems.length == 0 ){
            return null;
        }

        ListNode head = new ListNode(elems[0]);
        ListNode tail = head;
        ListNode cycleStart = null;

        for (int i = 1; i < elems.length; i++) {
            ListNode node = new ListNode(elems[i]);
            tail.next = node;
            tail = tail.next;
            if(i == pos) {
                cycleStart = tail;
            }
        }
        tail.next = cycleStart;

        return head;
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(true) {
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
