package binarySearch;

/**
 * @Description
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，
 * 并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * @Tag 旋转数组
 * @Date 2021/7/9
 */

public class FindMinimumInRotatedSortedArray2_154 {
    public static void main(String[] argus) {
        int[] nums = {1,3,5};
        System.out.println(findMin(nums));
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

}
