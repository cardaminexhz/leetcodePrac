package basic_hashtable;

import java.util.HashMap;

/**
 * @Description 最长连续序列
 * 给定一个整数数组，求这个数组中的数字可以组成的最长连续序列有多长。
 * 将数组映射到哈希表。不断的从哈希表中取（未访问的）元素，并将其前后连续的元素标记为已访问。
 * @Tag 哈希表
 * @Date 2021/8/11
 */

public class LonggestConsecutiveSequence_128 {
    public static void main(String[] argus) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(nums));

    }

    public static int longestConsecutive(int[] nums) {
        int maxLength = 0;
        //key-元素，value-是否已访问
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], false);
        }
        for (Integer cur : hashMap.keySet()) {
            if(!hashMap.get(cur)) {
                hashMap.put(cur, true);
                int prev = --cur;
                int next = ++cur;
                while (hashMap.containsKey(prev)) {
                    hashMap.put(prev, true);
                    --prev;
                }
                while (hashMap.containsKey(next)) {
                    hashMap.put(next, true);
                    ++next;
                }
                maxLength = Math.max(maxLength, next - prev - 1);
            }
        }

        return maxLength;
    }
}
