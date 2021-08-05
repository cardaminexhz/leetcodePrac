package DynamicProgramming;

/**
 * @Description 等差数列划分
 * 给定一个数组，求这个数组中连续且等差的子数组一共有多少个。
 * 状态转移方程推导：
 * 定义一个数组dp，dp[i]表示到第i个元素时（即以第i个元素结尾），满足条件的子数组的数量。
 * 而等差数列可以在任何一个位置结束，即对dp[]求和，得到子数组的总数。
 * @Tag 基本动态规划，一维
 * @Date 2021/8/5
 */

public class ArithmeticSlices_413 {
    public static void main(String[] argus) {
        int[] nums = {1};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int[] cnt = new int[nums.length];
        int sum = 0;

        for (int i = 2; i < nums.length; i++) {
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]) {
                cnt[i] = cnt[i-1] + 1;
                sum += cnt[i];
            }
        }
        return sum;
    }
}
