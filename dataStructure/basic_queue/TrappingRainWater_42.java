package basic_queue;

import java.util.Stack;

/**
 * @Description 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @Tag 单调栈
 * @Date 2021/8/10
 */

public class TrappingRainWater_42 {
    public static void main(String[] argus) {
        int[] height = {0,1,0,2,1,0,1,4,2,3,2,1};
//        int[] height  = {4,2,3};
        System.out.println(trap(height));

    }

    public static int trap(int[] height) {
        int res = 0;
        int[] f = new int[height.length]; // f[i]表示第i个位置能存放的雨水
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            int left = 0;
            int right = i;
            boolean canTrap = false;
            while(!stack.isEmpty() && height[right] >= height[stack.peek()]) {
                left = stack.pop();
                canTrap = true;
            }
            if(canTrap) {
                //解决423的问题，取4作为左边界，不将4弹栈
                if(!stack.isEmpty()) {
                    left = stack.peek();
                }
                int minHeight = Math.min(height[left], height[right]);
                //引入f[]，解决 21013 的雨水问题。第一次遇1弹栈，0的位置f=1;第二次遇3弹栈，0的位置f=2
                for (int j = left + 1; j <= right - 1; j++) {
                    f[j] = Math.max(minHeight - height[j], f[j]);
                }
            }

            stack.push(i);
        }
        for (int elem : f
             ) {
            res += elem;
        }
        return res;
    }
}
