package greedy;

/**
 * @Description 455 AssignCookies
 * 有一群孩子和一堆饼干，每个孩子有一个饥饿度，每个饼干都有一个大小。每个孩子只能吃
 * 一个饼干，且只有饼干的大小不小于孩子的饥饿度时，这个孩子才能吃饱。求解最多有多少孩子
 * 可以吃饱。
 * @Date 2021/6/24
 */

import java.util.Arrays;

public class AssignCookies_455 {

    public static void main(String[] argus) {
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};
        System.out.println(findContentChildren1(g, s));
    }

    // g 饥饿度 s 饼干大小
    public static int findContentChildren(int[] g, int[] s) {
        int res = 0;
        int indexInS = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        for (int gElem : g
             ) {
            for (int i = indexInS; i < s.length; i++) {
                if (gElem <= s[i]) {
                    res++;
                    indexInS = i+1;
                    break;
                }
            }
        }

        return res;
    }

    public static int findContentChildren1(int[] g, int[] s) {
        int childIdx = 0;
        int cookieIdx = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        while(childIdx < g.length && cookieIdx < s.length) {
            if(g[childIdx] <= s[cookieIdx]) {
                childIdx++;
            }
            cookieIdx++;
        }

        return childIdx;
    }

}
