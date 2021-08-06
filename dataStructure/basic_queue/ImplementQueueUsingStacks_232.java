package basic_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description 用栈实现队列
 * @Tag 栈，队列
 * @Date 2021/8/6
 */

public class ImplementQueueUsingStacks_232 {
    public static void main(String[] argus) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
    }
}

class MyQueue {
    public static Deque<Integer> deq1 = null;
    public static Deque<Integer> deq2 = null;

    /** Initialize your data structure here. */
    public MyQueue() {
        deq1 = new ArrayDeque<>();
        deq2 = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        deq1.add(x);    //at the tail of this deque
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!deq1.isEmpty()) {
            deq2.add(deq1.pop());
        }
        int headElem = deq2.pop();
        while (!deq2.isEmpty()) {
            deq1.add(deq2.pop());
        }
        return headElem;
    }

    /** Get the front element. */
    public int peek() {
        while(!deq1.isEmpty()) {
            deq2.add(deq1.pop());
        }
        int headElem = deq2.peek();
        while (!deq2.isEmpty()) {
            deq1.add(deq2.pop());
        }
        return headElem;

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return deq1.isEmpty();
    }
}
