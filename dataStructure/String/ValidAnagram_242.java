package String;

import java.util.HashMap;

/**
 * @Description 字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 可以用 哈希表 或者 数组 (通过 s[i]-'a' 来映射到下标) 来统计两个数组中每个数字出现的频次
 * @Tag 字符串比较，哈希表
 * @Date 2021/8/12
 */

public class ValidAnagram_242 {
    public static void main(String[] argus) {
        String s = "rat";
        String t = "cat";
        System.out.println(isAnagram2(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        // key:char, value:frequency
        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(hashMap1.containsKey(c)) {
                hashMap1.put(c, hashMap1.get(c) + 1);
            } else {
                hashMap1.put(c, 1);
            }
        }

        HashMap<Character, Integer> hashMap2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(hashMap2.containsKey(c)) {
                hashMap2.put(c, hashMap2.get(c) + 1);
            } else {
                hashMap2.put(c, 1);
            }
        }

        boolean ifEqual = true;
        for(Character key : hashMap1.keySet()) {
            if(!hashMap1.get(key).equals(hashMap2.get(key))) {
                ifEqual = false;
                break;
            }
        }
        return ifEqual;
    }

    public static boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()) return false;

        // key:char, value:frequency
        int[] frequency1 = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            frequency1[pos] = frequency1[pos] == 0 ? 1 : frequency1[pos] + 1;
        }

        int[] frequency2 = new int[26];
        for (int i = 0; i < t.length(); i++) {
            int pos = t.charAt(i) - 'a';
            frequency2[pos] = frequency2[pos] == 0 ? 1 : frequency2[pos] + 1;
        }

        boolean ifEqual = true;
        for (int i = 0; i < frequency1.length; i++) {
            if(frequency1[i] != frequency2[i]) {
                ifEqual = false;
                break;
            }
        }
        return ifEqual;
    }

    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;

        // key:char, value:frequency
        int[] frequency = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ++frequency[s.charAt(i) - 'a'];
            --frequency[t.charAt(i) - 'a'];
        }

        for (int elem : frequency
             ) {
            if(0 != elem) {
                return false;
            }
        }
        return true;
    }
}
