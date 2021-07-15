package sort;

import java.util.Arrays;

/**
 * @Description
 * 找到一个基准数，让这个基准数到它该去的位置。并且，基准数左边的数都比这个它要小，右边的数都比它要大。每一趟至少能够保证基准数在它应该在的位置，并且右边的数都大于左边的数，整体基本有序。
 * 取决于基准数的选择，
 * 若选的好，每次都处于中间位置，递归时左右平衡，不停的二分，T(n) = O(nlogn)
 * 若选的差，每次刚好时最大值或最小值，子问题规模只减了1，T(n)=O(n^2)
 * @Tag 快速排序
 * @Date 2021/7/15
 */

public class Basci_QuickSort {
    public static void main(String[] argus) {
        int[] arr = {6, 2, 4, 10, 15, 5, 9};
        sort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int l, int r) {
        if(l + 1 > r) return;
        int left = l;
        int right = r - 1;
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                --right;
            }
            arr[left] = arr[right];

            while (left < right && arr[left] <= pivot) {
                ++left;
            }
            arr[right] = arr[left];

        }

        arr[left] = pivot;
        sort(arr, l, left);
        sort(arr, left + 1, r);
    }
}
