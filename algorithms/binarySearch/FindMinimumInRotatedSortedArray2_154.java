package binarySearch;

/**
 * @Description
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。
 * 请你找出并返回数组中的 最小元素 。
 * 三种情况的分析。允许存在重复元素时，情况分析。
 * @Tag 旋转数组，二分查找
 * @Date 2021/7/9
 */

public class FindMinimumInRotatedSortedArray2_154 {
    public static void main(String[] argus) {
        int[] nums = {2,2,2,0,1};
        System.out.println(findMin2(nums));
    }

    public static int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                min = nums[i];
                break;
            }
        }

        return Math.min(min, nums[0]);
    }

    public static int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left < right) {
            mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]) {
                right = mid;
            } else if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                --right;
            }
        }
        return nums[left];
    }

}
