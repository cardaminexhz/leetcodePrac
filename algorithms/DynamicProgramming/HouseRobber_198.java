package DynamicProgramming;

/**
 * @Description 打家劫舍
 * 假如你是一个劫匪，并且决定抢劫一条街上的房子，每个房子内的钱财数量各不相同。
 * 如果你抢了两栋相邻的房子，则会触发警报机关。求在不触发机关的情况下最多可以抢劫多少钱。
 * 状态转移方程的推导：
 * 定义一个数组 dp，dp[i] 表示抢劫到第 i 个房子时，可以抢劫的最大数量。
 * 此时可以抢劫的最大数量有两种可能，一种是我们选择不抢劫这个房子，此时累计的金额即为dp[i-1]；
 * 另一种是我们选择抢劫这个房子，那么此前累计的最大金额只能是 dp[i-2]，因为我们不能够抢劫第 i-1 个房子，否则会触发警报机关。
 * 状态转移方程为 dp[i] = max(dp[i-1], dp[i-2]+nums[i-1])
 * 推导出状态转移方程后，再考虑空间压缩。
 * @Tag 基本动态规划，一维
 * @Date 2021/8/5
 */

public class HouseRobber_198 {
    public static void main(String[] argus) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }

    //空间压缩
    public static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int n2 = nums[0];
        int n1 = Math.max(nums[0], nums[1]);
        int tmp;

        for (int i = 2; i <= nums.length-1; i++) {
            tmp = n1;
            n1 = Math.max(n1, n2+nums[i]);
            n2 = tmp;
        }
        return n1;
    }

}
