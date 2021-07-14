package sort;

import java.util.Arrays;

/**
 * @Description
 * 每一步将待排序的元素插入到前面的有序表中
 * 外层循环从第二个元素开始；内层循环，对当前元素，在前面的有序表中找到位置插入
 * T(n) = O(n^2)
 * @Tag 插入排序
 * @Date 2021/7/14
 */

public class Basic_InsertSort {
    public static void main(String[] argus) {
        // 测试例子
        int[] arr = {6, 2, 4, 1, 5, 9};           // 显示引入标志位后的优化效果
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};  // 显示冒泡排序：每次将最大值移到最后
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--) {
                swap(arr, j, j + 1);
                System.out.println(Arrays.toString(arr));
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
