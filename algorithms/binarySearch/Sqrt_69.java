package binarySearch;

/**
 * @Description
 * 给定一个非负整数，求它的开方，向下取整。
 * @Tag 二分查找
 * @Date 2021/7/8
 */

public class Sqrt_69 {
    public static void main(String[] argus) {
        System.out.println(mySqrt1(2147395599));
    }

    public static int mySqrt(int x) {
        return (int) Math.floor(Math.sqrt(x));
    }

    public static int mySqrt1(int x) {
        if(x == 0) return 0;
        int left = 1;
        int right = x;
        int mid = 0;
        int sqrt = 0;
        while (left <= right) {
            mid = left + (right-left) / 2;
            sqrt = x / mid;
            if(sqrt == mid) {
                return mid;
            } else if(sqrt < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

}
