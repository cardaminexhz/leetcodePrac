package basic_array;

/**
 * @Description 搜索二维矩阵Ⅱ
 * 给定一个二维矩阵，已知每行和每列都是增序的，尝试设计一个快速搜索一个数字是否在矩阵中存在的算法。
 * @Tag 数组
 * @Date 2021/8/6
 */

public class SearchA2DMatrix2_240 {
    public static void main(String[] argus) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 0;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        while(i <= m - 2) {
            if(target >= matrix[i][0]) {
                //在同一行查找，（有序）用二分查找
                if(binarySearch(matrix[i], target)) {
                    return true;
                }
                if(target < matrix[i+1][0]) {
                    return false;
                } else {
                    i++;
                }
            } else {
                return false;
            }
        }
        if(binarySearch(matrix[m-1], target)) {
            return true;
        }
        return false;
    }

    public static boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                return true;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
