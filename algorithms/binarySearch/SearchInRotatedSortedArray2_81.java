package binarySearch;

/**
 * @Description
 * 一个原本增序的数组被首尾相连后按某个位置断开（如 [1,2,2,3,4,5] → [2,3,4,5,1,2]，在第一位和第二位断开），我们称其为旋转数组。
 * 给定一个值，判断这个值是否存在于这个为旋转数组中。
 * @Tag 预处理，二分查找
 * @Date 2021/7/9
 */

public class SearchInRotatedSortedArray2_81 {
    public static void main(String[] argus) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        int[] newNums = new int[nums.length];

        //找到断开位置
        int minIdx = 0;
        for (int i = 1; i < nums.length; i++) {
            //在增序数组中，第i位<第i-1位，说明从i位置断开
            if(nums[i] < nums[i-1]) {
                minIdx = i;
                break;
            }
        }

        //恢复增序，存入newNums
        int j = 0;
        for (int i = 0; i < newNums.length; i++) {
            if(minIdx <= nums.length - 1) {
                newNums[i] = nums[minIdx];
                minIdx++;
            } else {
                newNums[i] = nums[j];
                j++;
            }
        }

        //二分查找
        int left = 0;
        int right = newNums.length - 1;
        int mid = 0;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(newNums[mid] == target) {
                return true;
            } else if(newNums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }


}
