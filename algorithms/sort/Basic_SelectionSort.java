package sort;

import java.util.Arrays;

/**
 * @Description
 * 在未排序区找到最小/最大元素，放到有序区的末尾
 * 扫描-比较比较比较-交换
 * T(n) = O(n^2)
 * @Tag 选择排序
 * @Date 2021/7/15
 */

public class Basic_SelectionSort {
    public static void main(String[] argus) {
        int[] arr = {6, 2, 4, 10, 15, 5, 9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i+1; j < arr.length; j++) {
                minIdx = arr[j] < arr[minIdx] ? j : minIdx;
            }
            if(minIdx != i) {
                swap(arr, i, minIdx);
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
