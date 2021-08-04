package DynamicProgramming;

/**
 * @Description 爬楼梯
 * 给定 n 节台阶，每次可以走一步或走两步，求一共有多少种方式可以走完这些台阶。
 * 状态转移方程，边界条件
 * 优化：空间压缩
 * @Tag 基本动态规划，一维
 * @Date 2021/8/4
 */

public class ClimbStairs_70 {
    public static void main(String[] argus) {
        System.out.println(climbStairs1(45));
    }

    public static int climbStairs(int n) {
        if(n == 1 || n == 2) return n;

        int[] f = new int[n+1];
        f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    //优化S(n)，空间压缩
    public static int climbStairs1(int n) {
        if(n == 1 || n == 2) return n;
        int n1, n2, tmp;

        n2 = 1;
        n1 = 1;
        for (int i = 2; i <= n; i++) {
            tmp = n1;
            n1 = n1 + n2;
            n2 = tmp;
        }
        return n1;
    }
}
