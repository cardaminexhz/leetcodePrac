package String;

/**
 * @Description 同构字符串
 * 给定两个字符串 s 和 t，判断它们是否是同构的。如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 若仅为小写字符，可通过 s[i]-'a' 映射到数组下标 0-25，
 * 若字符范围更大，可以直接取其ASCII作为下标 0 - 255。
 * ASCII码：char->int 即该字符的ASCII码
 * ASCII码包括3部分：控制字符（非打印），打印字符，扩展打印字符
 * @Tag 字符串比较
 * @Date 2021/8/12
 */

public class IsomorphicStrings_205 {
    public static void main(String[] argus) {
//        String s = "badc";
//        String t = "baba";
//        String s = "paper";
//        String t = "title";
        String s = "13";
        String t = "24";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        //s[i]->t[i],如p->t,mapping['p'] = 't',marked['t']=true(不同字符不能被映射到同一字符)
        char[] mapping = new char[256];
        boolean[] marked = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if('\u0000' == mapping[c1]) {
                if(!marked[c2]) {
                    mapping[c1] = c2;
                    marked[c2] = true;
                } else if(marked[c2]) {
                    return false;
                }
            } else if(c2 != mapping[c1]){
                return false;
            }
        }
        return true;
    }
}
