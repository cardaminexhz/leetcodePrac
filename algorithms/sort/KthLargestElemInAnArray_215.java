package sort;

/**
 * @Description
 * 在一个未排序的数组中，找到第 k 大的数字。
 * 暴力，先排序，后返回第k大（idx=len-k）
 * @Tag
 * @Date 2021/7/16
 */

public class KthLargestElemInAnArray_215 {

    public static void main(String[] argus) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(arr, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length);
        return nums[nums.length-k];
    }

    public static void quickSort(int[] arr, int l, int r) {
        if(l + 1 >= r) return;
        int left = l;
        int right = r - 1;
        int pivot= arr[left];
        while(left < right) {
            while(left < right && arr[right] >= pivot) {
                --right;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= pivot) {
                ++left;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        quickSort(arr, l, left);
        quickSort(arr, left+1, r);
    }
}
