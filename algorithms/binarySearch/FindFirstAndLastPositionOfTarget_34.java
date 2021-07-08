package binarySearch;

/**
 * @Description
 * 给定一个增序的整数数组和一个值，查找该值第一次和最后一次出现的位置。
 * @Tag 二分查找
 * @Date 2021/7/8
 */

public class FindFirstAndLastPositionOfTarget_34 {
    public static void main(String[] argus) {
        int[] nums = {8,8};
        int target = 8;
        int[] res = searchRange(nums, target);
        for (int elem:res
             ) {
            System.out.println(elem);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        boolean hasTarget = false;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                hasTarget = true;
                break;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if(!hasTarget) return new int[]{-1, -1};
        int start = mid;
        int end = mid;
        while(start >= 0 && nums[start] == target) {
            --start;
        }
        while(end <= nums.length - 1 && nums[end] == target) {
            ++end;
        }
        if(start == end - 1) return new int[]{start, start};
        return new int[]{start+1, end-1};
    }
}
