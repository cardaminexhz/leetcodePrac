package String;

/**
 * @Description 回文子串
 * 给定一个字符串，求其有多少个回文子字符串。回文的定义是左右对称。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * @Tag 字符串比较
 * @Date 2021/8/12
 */

public class PalindromicSubstrings_647 {
    public static void main(String[] argus) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int count = 0;
        //从字符串的每个位置，向左向右延申，判断以当前位置为中轴的字符串有几个
        for (int i = 0; i < s.length(); i++) {
            count += extend(s, i, i);     //奇数长度
            count += extend(s, i, i+1); //偶数长度
        }
        return count;
    }

    public static int extend(String s, int l, int r) {
        int cnt = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            --l;
            ++r;
            ++cnt;
        }
        return cnt;
    }
}
