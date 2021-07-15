package sort;

import java.util.Arrays;

/**
 * @Description
 * 重复扫描无序区；每一趟扫描，两两比较相邻气泡，将最大的气泡上移到顶部，即有序区增加了一个气泡
 * 若在一趟扫描中，未发生交换，说明已有序，可停止扫描
 * 扫描-比较交换-比较交换
 * T(n) = O(n^2)
 * @Tag 冒泡排序
 * @Date 2021/7/14
 */

public class Basic_BubbleSort {
    public static void main(String[] argus) {
        // 测试例子
        int[] arr = {6, 2, 4, 1, 5, 9};           // 显示引入标志位后的优化效果
//        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};  // 显示冒泡排序：每次将最大值移到最后
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int unSequencedLen = arr.length;
        boolean unSequenced = true;
        while(unSequencedLen > 0 && unSequenced) {
            unSequenced = false;
            for (int i = 0; i < unSequencedLen - 1; i++) {
                if(arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                    unSequenced = true;
                }
            }
            --unSequencedLen;
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
