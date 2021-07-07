package doublePointer;

/**
 * @Description
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * @Tag 双指针
 * @Date 2021/7/7
 */

public class ValidPalindrome2_680 {
    public static void main(String[] argus) {
        String s = "cbbcc";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        int charToDel = 0;
        boolean isLeftPalindrome = true;
        boolean isRightPalindrome = true;
        while(left <= right) {
            if(charToDel >= 2) {
                isLeftPalindrome = false;
                break;
            }
            if(s.charAt(left) == s.charAt(right)) {
                ++left;
                --right;
            } else {
                ++left;
                ++charToDel;
            }
        }

        left = 0;
        right = s.length() - 1;
        charToDel = 0;
        while(left <= right) {
            if(charToDel >= 2) {
                isRightPalindrome = false;
                break;
            }
            if(s.charAt(left) == s.charAt(right)) {
                ++left;
                --right;
            } else {
                --right;
                ++charToDel;
            }
        }

        return (isLeftPalindrome || isRightPalindrome);
    }
}
