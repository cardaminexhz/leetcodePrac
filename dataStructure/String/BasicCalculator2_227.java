package String;

import java.util.Stack;

/**
 * @Description TODO
 * @Tag 字符串理解
 * @Date 2021/8/13
 */

public class BasicCalculator2_227 {
    public static void main(String[] argus) {
        String s = "3+2*2";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        Stack<Object> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (c == '*') {
                    int left = Character.getNumericValue((Character) stack.pop());
                    StringBuilder sb = new StringBuilder();
                    ++i;
                    while (i < s.length() && notOperator(s.charAt(i))) {
                        if(s.charAt(i) != ' ') {
                            sb.append(s.charAt(i));
                        }
                        ++i;
                    }
                    int right = Integer.parseInt(sb.toString());
                    int res = left * right;
                    stack.push(res);
                } else if (c == '/') {
                    int left = Character.getNumericValue((Character) stack.pop());
                    StringBuilder sb = new StringBuilder();
                    ++i;
                    while (i < s.length() && notOperator(s.charAt(i))) {
                        if(s.charAt(i) != ' ') {
                            sb.append(s.charAt(i));
                        }
                        ++i;
                    }
                    int right = Integer.parseInt(sb.toString());
                    int res = left / right;
                    stack.push(res);
                } else {
                    stack.push(c);
                }
            }
        }

        if(Character.isDigit((char) stack.peek())) {
            ans = (char) stack.pop() - '0';
        } else {
            ans =  Character.getNumericValue((char) stack.pop());
        }
        while (!stack.isEmpty()) {
            char operator = (char) stack.pop();
            int left = Character.getNumericValue((char) stack.pop());
            if (operator == '+') {
                ans = left + ans;
            } else if (operator == '-') {
                ans = left - ans;
            }
        }
        return ans;
    }

    public static boolean notOperator(char c) {
        return (c != '+' && c != '-' && c !='*' && c != '/');
    }
}
