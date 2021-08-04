package depthFirstSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * @Tag 深度优先遍历，回溯
 * @Date 2021/8/4
 */

public class BinaryTreePaths_257 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] argus) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, null, node5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println(binaryTreePaths(node1));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, res, path);
        return res;
    }

    public static void dfs(TreeNode curNode, List<String> res, Deque<Integer> path) {
        if (curNode.left == null && curNode.right == null) {
            //叶子节点
            path.add(curNode.val);
            String s = (new ArrayList<>(path))
                    .stream()
                    .map(n -> String.valueOf(n))
                    .collect(Collectors.joining("->", "", ""));
            res.add(s);
            path.removeLast();
            return;
        }

        if (curNode.left != null) {
            path.add(curNode.val);
            dfs(curNode.left, res, path);
            path.removeLast();
        }
        if (curNode.right != null) {
            path.add(curNode.val);
            dfs(curNode.right, res, path);
            path.removeLast();
        }
    }

}
