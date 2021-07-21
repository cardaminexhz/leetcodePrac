package sort;

/**
 * @Description
 * 边排边找（排是对基准数而言，整体大致有序，左边<=基准数，右边>=基准数），
 * 找到第k大（idx=length-k）的基准数即可，不用再继续对其左右两边的数排序。
 * @Tag 快速排序，快速选择，第k大
 * @Date 2021/7/21
 */

public class KthLargestElemInAnArray_215_1 {

    public static void main(String[] argus) {
        int[] arr = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(arr, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        int targetIdx = nums.length - k;
        int l = 0;
        int r = nums.length - 1;
        while(true) {
            int mid = quickSelect(nums, l, r);
            if (mid == targetIdx) {
                return nums[mid];
            } else if (mid < targetIdx) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
    }

    public static int quickSelect(int[] nums, int l, int r) {
        int left = l + 1;
        int right = r;
        while(true) {
            while(left < r && nums[left] <= nums[l]) {
                ++left;
            }
            while(right > l && nums[right] >= nums[l]) {
                --right;
            }
            if(left >= right) {
                break;
            }
            swap(nums, left, right);
        }
        swap(nums, l, right);
        return right;
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
