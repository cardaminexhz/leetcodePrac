package String;

import java.util.*;

/**
 * @Description 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串(注意是连续的子串) 的长度。
 * 双端队列，每访问s中的一个字符，
 *              若在队列中已存在，则从左端弹出，直到队列中此元素已被弹出。
 *              此元素从右端入队列。
 * 类似239_1 滑动窗口
 * 什么是滑动窗口？
 * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，
 * 当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列。
 * 如何移动？
 * 我们只要把队列的左边的元素移出就行了，直到满足题目要求。
 * @Tag 双端队列，滑动窗口
 * @Date 2021/8/17
 */

public class LongestSubstringNotRepeated_3 {
    public static void main(String[] argus) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (!deque.isEmpty() && deque.contains(c)) {
                maxLength = Math.max(deque.size(), maxLength);
                while(deque.peekFirst() != c) {
                    deque.pollFirst();
                }
                deque.pollFirst();
            }

            deque.addLast(c);
        }
        maxLength = Math.max(deque.size(), maxLength);
        return maxLength;
    }
}
