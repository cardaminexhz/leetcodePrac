package sort;

import java.util.*;

/**
 * @Description
 * 给定一个数组，求前 k 个最频繁的数字。
 * 暴力排序，遍历一遍统计频率，按照频率进行降序排序
 * T(n) = O(n)(遍历一遍) + O(nlogn)(排序) = O(nlogn)
 * S(n) = O(n)，最极端的情况下（每个元素都不同），用于存储元素及其频率的 Map 需要存储 n 个键值对
 * @Tag
 * @Date 2021/7/21
 */

public class TopKFrequentElements_347 {
    public static void main(String[] argus) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        // 遍历一遍，统计频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        //按频率降序排序
        Comparator<Map.Entry<Integer, Integer>> valueComparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, valueComparator);

        //返回频率前k高的元素
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            if (i <= k - 1) {
                res[i++] = entry.getKey();
            } else {
                break;
            }
        }

        return res;
    }
}
