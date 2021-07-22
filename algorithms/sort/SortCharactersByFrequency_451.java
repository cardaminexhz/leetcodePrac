package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。347变形题
 * @Tag 桶排序
 * @Date 2021/7/22
 */

public class SortCharactersByFrequency_451 {
    public static void main(String[] argus) {
        String s = "Aabb";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        // key:char, value:frequency
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        // 以频率为下标，放入桶（哈希表）
        List<Character>[] list = new List[s.length() + 1];
        for(Character key : map.keySet()) {
            int frequency = map.get(key);
            if(null == list[frequency]){
                list[frequency] = new ArrayList<>();
            }
            list[frequency].add(key);
        }

        StringBuilder res = new StringBuilder();
        for (int i = list.length - 1; i >= 0 ; i--) {
            if(null == list[i]) continue;
            for (Character chr : list[i]
                 ) {
                for (int j = 0; j < i; j++) {
                    res.append(chr);
                }
            }
        }

        return res.toString();
    }
}
