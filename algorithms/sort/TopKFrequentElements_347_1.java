package sort;

import java.util.*;

/**
 * @Description
 * 给定一个数组，求前 k 个最频繁的数字。
 * 遍历一遍统计频率，以频率为数组下标存入哈希表，相同频率的元素存入该下标对应的链表
 * T(n) = O(n)(遍历一遍统计频率) + O(n)(遍历一遍存入哈希表) = O(n)
 * S(n) = O(n)
 * @Tag 桶排序，前k个高频元素
 * @Date 2021/7/22
 */

public class TopKFrequentElements_347_1 {
    public static void main(String[] argus) {
        int[] nums = {1};
        int k = 1;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        // 遍历一遍，统计频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        //桶排序（哈希表）
        //将频率作为数组下标，将相同频率的元素存入该下标对应的链表
        List<Integer>[] list = new List[nums.length + 1];
        for(int key : map.keySet()) {
            int i = map.get(key);
            if(list[i] == null) {
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }

        //返回频率前k高的元素
        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if(null == list[i]) continue;
            res.addAll(list[i]);
        }

        int[] res1 = new int[res.size()];
        int i = 0;
        for (Integer elem : res
             ) {
            res1[i++] = elem;
        }
        return res1;
    }
}
