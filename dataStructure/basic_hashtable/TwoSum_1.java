package basic_hashtable;

import java.util.HashMap;

/**
 * @Description 两数之和
 * 给定一个整数数组，已知有且只有两个数的和等于给定值，求这两个数的位置。
 * 暴力解法：外层 i 遍历数组，然后找 差值target-nums[i] 在剩余元素中是否存在，即内层 j(j=i+1) 继续遍历。
 *         T(n) = O(n^2)
 * 哈希表：利用哈希表可在O(1)的时间复杂度里获取数的特点，优化在剩余元素中是否存在 差值target-nums[i]，
 *        第一遍遍历建立哈希表，key-值，value-下标
 *        第二遍遍历，一次即可。
 *        T(n) = O(n)
 * @Tag 哈希表
 * @Date 2021/8/11
 */

public class TwoSum_1 {
    public static void main(String[] argus) {
        int[] nums = {3,2,4};
        int target = 6;
        int[] res = twoSum1(nums, target);
        for (int elem : res
             ) {
            System.out.println(elem);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int last = target - nums[i];    //避免溢出
            for (int j = i+1; j < nums.length; j++) {
                if(last == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static int[] twoSum1(int[] nums, int target) {
        // key-值, value-下标
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        int last;
        for (int i = 0; i < nums.length; i++) {
            last = target - nums[i];
            if(hashMap.containsKey(last) && hashMap.get(last) != i) {
                return new int[]{i, hashMap.get(last)};
            }
        }

        return null;
    }
}
