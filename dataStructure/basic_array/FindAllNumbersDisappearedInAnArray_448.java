package basic_array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 找到数组中所有消失的数字
 * 给定一个长度为 n 的数组，其中包含范围为 1 到 n 的整数，有些整数重复了多次，有些整数没有出现，
 * 求 1 到 n 中没有出现过的整数。
 * 优化方案：空间压缩。不借助新的数组，如何在原数组上记录是否出现（不影响原位置上的值）？引入新维度
 * @Tag 数组
 * @Date 2021/8/5
 */

public class FindAllNumbersDisappearedInAnArray_448 {
    public static void main(String[] argus) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers1(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        boolean[] appeared = new boolean[n+1];

        for (int elem : nums
             ) {
            appeared[elem] = true;
        }

        for (int i = 1; i <= n; i++) {
            if(!appeared[i]) {
                res.add(i);
            }
        }
        return res;
    }

    //空间压缩：在值的维度之外，引入新维度：正负，来标记是否出现过
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;

        for (int elem : nums
        ) {
            int pos = Math.abs(elem) - 1;
            nums[pos] = nums[pos] < 0 ? nums[pos] : -nums[pos];
        }

        for (int i = 0; i <= n-1; i++) {
            if(nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }
}
