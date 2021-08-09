package basic_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 最小栈
 * 设计一个最小栈，除了需要支持常规栈的操作外，还需要支持在 O(1) 时间内查询栈内最小值的功能。
 * 额外建立一个新栈，存储最小值。
 * @Tag 栈
 * @Date 2021/8/9
 */

public class MIniStack_155 {

    //["MinStack","push","push","push","getMin","pop","getMin"]
    //[[],[0],[1],[0],[],[],[]]
    public static void main(String[] argus) {
        MinStack obj = new MinStack();
        obj.push(0);
        obj.push(1);
        obj.push(0);
        int param_4 = obj.getMin();
        obj.pop();
        int param_3 = obj.getMin();

        obj.push(1);
    }
}

class MinStack {
    public static Deque<Integer> stack = null;
    public static Deque<Integer> min_stack = null;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        min_stack = new LinkedList<>();
        min_stack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.add(val);
        // 注意条件 <=
        if(val <= min_stack.peekLast()) {
            min_stack.add(val);
        }
    }

    public void pop() {
        int val = stack.pollLast();
        if(val == min_stack.peekLast()) {
            min_stack.pollLast();
        }
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return min_stack.peekLast();
    }
}