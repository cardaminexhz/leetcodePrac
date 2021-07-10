package binarySearch;

/**
 * @Description:
 * 给定一个排序数组(无重复值)和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @Tag
 * @Date 2021/7/10
 */

public class FindInsertIdx_35 {

    public static void main(String[] argus) {
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert1(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int searchInsert1(int[] nums, int target) {
        if(nums[nums.length - 1] < target) {
            return nums.length;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left < right) {
            mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
