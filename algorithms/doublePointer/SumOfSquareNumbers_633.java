package doublePointer;

/**
 * @Description
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * 167-TwoSum2的变形
 * @Tag 双指针
 * @Date 2021/7/7
 */

public class SumOfSquareNumbers_633 {
    public static void main(String[] argus) {
        int c = 3;
        System.out.println(judgeSquareSum(c));
    }

    public static boolean judgeSquareSum(int c) {
        if(c == 0 || c == 1) {
            return true;
        }
        int left = 0;
        int right = (int) Math.sqrt(c);
        while(left <= right) {
            int sum = (int) (Math.pow(left, 2) + Math.pow(right, 2));
            if(sum == c) {
                return true;
            } else if(sum < c) {
                ++left;
            } else if(sum > c) {
                --right;
            }
        }
        return false;
    }
}
