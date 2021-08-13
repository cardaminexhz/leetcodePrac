package String;

/**
 * @Description 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 定义一个大小为52的数组，且通过s[i]-'A'映射到下标，是放不下A-Z, a-z的
 * 注意ASCII码：A 65 a 97
 * @Tag 字符串比较
 * @Date 2021/8/13
 */

public class LonggestPalindrome_409 {
    public static void main(String[] argus) {
        String s = "zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        int maxLength = 0;
        int[] frequency = new int[100];
        for (int i = 0; i < s.length(); i++) {
            ++frequency[s.charAt(i) - 'A'];
        }
        boolean ifFirstOdd = true;
        for (int elem : frequency
             ) {
            if(elem != 0 ) {
                if (elem % 2 == 0) {
                    maxLength += elem;
                }else if (elem % 2 != 0 && ifFirstOdd) {
                    maxLength += elem;
                    ifFirstOdd = false;
                } else {
                    maxLength += elem - 1;
                }
            }
        }
        return maxLength;
    }
}
