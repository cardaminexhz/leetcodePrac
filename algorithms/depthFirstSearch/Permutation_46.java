package depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * 给定一个无重复数字的整数数组，求其所有的排列方式。
 * @Tag 回溯，全排列
 * @Date 2021/7/30
 */

public class Permutation_46 {
    public static void main(String[] argus) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTracing(nums, 0, res);
        return res;
    }

    public static void backTracing(int[] nums, int level, List<List<Integer>> res) {
        if(level == nums.length - 1) {
            List<Integer> elem = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                elem.add(nums[j]);
            }
            res.add(elem);
            return;
        }

        for (int i = level; i < nums.length; i++) {
            swap(nums, i, level);
            backTracing(nums, level+1, res);
            swap(nums, i, level);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
