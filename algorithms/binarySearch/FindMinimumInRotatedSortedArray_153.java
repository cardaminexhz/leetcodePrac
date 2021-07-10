package binarySearch;

/**
 * @Description:
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。
 * 请你找出并返回数组中的 最小元素 。
 * findMin() 暴力，从头到尾遍历，最坏情况下 T(n) = O(n);
 * findMin1() 二分查找，每一步会忽略一半的空间，T(n) = O(logn).
 * S(n) = O(1).
 * @Tag 旋转数组，二分查找
 * @Date 2021/7/10
 */

public class FindMinimumInRotatedSortedArray_153 {
    public static void main(String[] argus) {
        int[] nums = {2,1};
        System.out.println(findMin1(nums));
    }

    public static int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                min = Math.min(min, nums[i]);
                break;
            }
        }

        return min;
    }

    public static int findMin1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left < right) {
            mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right];
    }

}
