package depthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。你可以按 任何顺序 返回答案。
 * 回溯算法是在一棵树上的深度优先遍历（因为要找到所有解，所以需要遍历）。
 * 既然是树形问题上的的深度优先遍历，那么首先画出树形结构。画图帮助分析
 * @Tag 深度优先遍历，回溯，组合
 * @Date 2021/7/30
 */

public class Combination_77 {
    public static void main(String[] argus) {
        int n = 4;
        int k = 2;
        System.out.println(combine(4,2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    public static void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if(path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <= n; i++) {
            //加入路径变量
            path.add(i);
            //组合里的元素不能重复，所以搜索的起点位置+1
            dfs(n, k, i+1, path, res);
            //深度优先遍历有回头的过程，所以递归前做了什么，递归后也要做什么
            path.removeLast();
        }
    }

}
