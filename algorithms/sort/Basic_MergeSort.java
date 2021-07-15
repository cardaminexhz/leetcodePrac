package sort;

import java.util.Arrays;

/**
 * @Description TODO
 * 分治思想
 * @Tag 归并排序
 * @Date 2021/7/15
 */

public class Basic_MergeSort {
    public static void main(String[] argus) {
        int[] arr = {6, 2, 4, 10, 15, 5, 9};
        int[] tmp = new int[arr.length];
        sort(arr, 0, arr.length, tmp);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int l, int r, int[] tmp) {
        if (l + 1 >= r) return;
        // divide
        int mid = l + (r - l) / 2;
        sort(arr, l, mid, tmp);
        sort(arr, mid, r, tmp);

        //conquer
        int p = l;
        int q = mid;
        int i = l;
        while (p < mid || q < r) {
            if (q >= r || (p < mid && arr[p] <= arr[q])) {
                tmp[i++] = arr[p++];
            } else {
                tmp[i++] = arr[q++];
            }
        }

        for (int j = l; j < r; j++) {
            arr[j] = tmp[j];
        }
    }
}
