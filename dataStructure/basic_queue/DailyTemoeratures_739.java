package basic_queue;

import java.util.Stack;

/**
 * @Description 每日温度
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替
 * 栈中存储下标，而非元素。
 * 弹栈时，确定栈顶元素的res。
 * @Tag 单调栈
 * @Date 2021/8/9
 */

public class DailyTemoeratures_739 {
    public static void main(String[] argus) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] res = dailyTemperatures1(temperatures);
        for (int elem : res
             ) {
            System.out.print(elem + ", ");
        }
    }

    public static int[] dailyTemperatures(int[] t) {
        int[] res = new int[t.length];
        Stack<Integer> stack = new Stack<>();
        // stack中存储下标，而非温度元素
        for (int i = 0; i < t.length; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && t[i] > t[stack.peek()]) {
                for (int idx : stack
                     ) {
                    ++res[idx];
                }
                stack.pop();
            }
            stack.push(i);
        }

        //数组遍历完成，即栈中剩余元素不满足条件，置0
        for (int idx : stack
             ) {
            res[idx] = 0;
        }

        return res;
    }

    public static int[] dailyTemperatures1(int[] t) {
        int[] res = new int[t.length];
        Stack<Integer> stack = new Stack<>();
        // stack中存储下标，而非温度元素
        for (int i = 0; i < t.length; i++) {
            while(!stack.isEmpty() && t[i] > t[stack.peek()]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }

        //数组遍历完成，即栈中剩余元素不满足条件，置0
        for (int idx : stack
        ) {
            res[idx] = 0;
        }

        return res;
    }
}
