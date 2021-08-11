package basic_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description 滑动窗口最大值
 * 给定一个整数数组和一个滑动窗口大小，求在这个窗口的滑动过程中，每个时刻其包含的最大值。
 * 双端队列，最左边元素（窗口每次向右滑动1个元素）不在滑动窗口内了就弹出去，
 *         右边元素（从右向左）依次和新元素比较，若小于，则弹出，
 *         然后把新元素从右边加入队列。
 * 单调栈的延申：该双端队列维持着从左到右递减的单调性。
 * 最左边元素是当前滑动窗口的最大值。
 * @Tag 双端队列，单调队列
 * @Date 2021/8/11
 */

public class SlidingWindowMaximum_239_1 {
    public static void main(String[] argus) {
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        for (int elem : res
        ) {
            System.out.print(elem + ", ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        //队列，存储下标，nums[左边下标]为最大值
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        int  j = 0;
        for (int i = 0; i < nums.length; i++) {
            //队列最左边的元素在不在滑动窗口内，不在，则弹出
            if(!deque.isEmpty() && deque.peekFirst() <= i-k) {
               deque.pollFirst();
            }
            //队列右边的元素(从右向左)，依次跟新元素相比，若小于，则弹出。以保持最左边的元素最大
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            //新元素从右边入队列
            deque.addLast(i);
            if(i >= k-1) {
                res[j++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
