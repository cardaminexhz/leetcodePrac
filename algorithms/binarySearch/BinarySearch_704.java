package binarySearch;

/**
 * @Description:
 * 给定一个 n 个元素（不重复）有序的（升序）整型数组 nums 和一个目标值 target，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 二分查找基础问题
 * @Tag 二分查找
 * @Date 2021/7/10
 */

public class BinarySearch_704 {
    public static void main(String[] argus) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
