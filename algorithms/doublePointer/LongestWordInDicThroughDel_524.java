package doublePointer;

import java.util.*;

/**
 * @Description
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 * @Tag 双指针
 * @Date 2021/7/8
 */

public class LongestWordInDicThroughDel_524 {
    public static void main(String[] argus) {
        String s = "wordgoodgoodgoodbestword";
        List<String> dictionary = Arrays.asList(new String[]{"word", "good", "best", "good"});
        System.out.println(findLongestWord(s, dictionary));
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        List<String> newDict = new ArrayList<>();

        for (int i = 0; i < dictionary.size(); i++) {
            String anchor = dictionary.get(i);
            int p1 = 0;
            int p2 = 0;
            while (p1 < s.length() && p2 < anchor.length() && s.length() - p1 >= anchor.length() - p2) {
                if (s.charAt(p1) == anchor.charAt(p2)) {
                    ++p1;
                    ++p2;
                } else {
                    ++p1;
                }
            }
            if (p2 == anchor.length()) {
                newDict.add(anchor);
            }
        }

        Collections.sort(newDict, new Comparator<String>() {
                    @Override
                    public int compare(String s1, String s2) {
                        //长度最长（降序），且字典序最小（长度相同时，字典序升序）
                        if (s1.length() < s2.length()) {
                            return 1;
                        } else if (s1.length() == s2.length()) {
                            return s1.compareTo(s2);
                        } else {
                            return -1;
                        }
                    }
                }
        );

        if (newDict.size() == 0) {
            return "";
        }
        return newDict.get(0);
    }
}
