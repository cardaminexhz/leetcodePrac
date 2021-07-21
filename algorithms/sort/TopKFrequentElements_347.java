package sort;

import java.util.*;

/**
 * @Description TODO
 * @Tag
 * @Date 2021/7/21
 */

public class TopKFrequentElements_347 {
    public static void main(String[] argus) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(topKFrequent(nums, k));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) != null) {
                int newVal = map.get(nums[i]) + 1;
                map.put(nums[i], newVal);
            } else {
                map.put(nums[i], 1);
            }
        }

        Comparator<Map.Entry<Integer, Integer>> valueComparator = new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        };
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list,valueComparator);

        for (Map.Entry<Integer, Integer> entry : list) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        return nums;
    }
}
