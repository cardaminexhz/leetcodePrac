package String;

/**
 * @Description 计算有国少个二进制子串
 * 给定一个字符串 s，计算具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是连续的。
 * 重复出现的子串要计算它们出现的次数。
 * 同647
 * @Tag 字符串比较
 * @Date 2021/8/12
 */

public class CountBinarySubstrings_696 {
    public static void main(String[] argus) {
        String s = "10101";
        System.out.println(countBinarySubstrings(s));
    }

    public static int countBinarySubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                continue;
            }
            count += extend(s, i, i+1);
        }
        return count;
    }

    public static int extend(String s, int l, int r) {
        int cnt = 0;
        boolean ifFirst = true;
        while(l >= 0 && r < s.length() && s.charAt(l) != s.charAt(r)) {
            if(ifFirst) {
                --l;
                ++r;
                ++cnt;
                ifFirst = false;
            } else {
                if(s.charAt(l) == s.charAt(l+1)) {
                    --l;
                    ++r;
                    ++cnt;
                } else {
                    break;
                }
            }
        }

        return cnt;
    }
}
