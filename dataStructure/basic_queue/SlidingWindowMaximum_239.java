package basic_queue;

import java.util.Arrays;

/**
 * @Description 滑动窗口最大值
 * 给定一个整数数组和一个滑动窗口大小，求在这个窗口的滑动过程中，每个时刻其包含的最大值。
 * 暴力解法，会超出时间限制
 * @Tag
 * @Date 2021/8/10
 */

public class SlidingWindowMaximum_239 {
    public static void main(String[] argus) {
        int[] nums = {7,2,4};
        int k = 2;
        int[] res = maxSlidingWindow(nums, k);
        for (int elem : res
             ) {
            System.out.print(elem + ", ");
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1 || k == 1) return nums;
        int[] res = new int[nums.length - k + 1];
        int maxIdx = getIdxOfMaxVal(Arrays.copyOfRange(nums, 0, k));
        int maxVal = nums[maxIdx];
        res[0] = maxVal;
        for (int i = k; i < nums.length; i++) {
            if(nums[i] >= maxVal) {
                maxIdx = i;
                maxVal = nums[i];
            } else if(nums[i] < maxVal && maxIdx < i-k+1){
                // 重新选
                maxIdx = (i-k+1) + getIdxOfMaxVal(Arrays.copyOfRange(nums, i-k+1, i+1));
                maxVal = nums[maxIdx];
            }
            res[i-k+1] = maxVal;
        }
        return res;
    }

    public static int getIdxOfMaxVal(int[] window) {
        int maxIdx = 0;
        int maxVal = window[maxIdx];
        for (int i = 0; i < window.length; i++) {
            if(window[i] > maxVal) {
                maxIdx = i;
                maxVal = window[i];
            }
        }
        return maxIdx;
    }
}
