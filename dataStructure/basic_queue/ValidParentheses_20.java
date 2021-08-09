package basic_queue;

import java.util.Stack;

/**
 * @Description 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 括号匹配是典型的使用栈来解决的问题。
 * @Tag 栈
 * @Date 2021/8/9
 */

public class ValidParentheses_20 {
    public static void main(String[] argus) {
        String s = "{[]}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isLeft(c)) {
                stack.push(c);
            }
            if (isRight(c)) {
                if(!stack.isEmpty()) {
                    if(match(stack.pop(), c)) {
                        continue;
                    }
                }
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isLeft(char c) {
        char[] left = {'(', '{', '['};
        for (char elem : left
             ) {
            if(elem == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRight(char c) {
        char[] right = {')', '}', ']'};
        for (char elem : right
        ) {
            if(elem == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean match(char cl, char cr) {
        String left = "({[";
        String right = ")}]";
        int posInLeft = left.indexOf(cl);
        int posInRight = right.indexOf(cr);
        return -1 != posInLeft && posInLeft == posInRight;
    }
}
