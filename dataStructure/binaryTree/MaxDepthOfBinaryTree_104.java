package binaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description 二叉树的最大深度
 * @Tag 树的递归，深度优先搜索
 * @Date 2021/8/23
 */

public class MaxDepthOfBinaryTree_104 {
    public static void main(String[] argus) {
        TreeNode node5 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        TreeNode node3 = new TreeNode(20, node5, node4);
        TreeNode node2 = new TreeNode(9);
        TreeNode node1 = new TreeNode(1, node2, node3);

        System.out.println(maxDepth(node1));
    }

    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Deque<Integer> path = new ArrayDeque<>();
        return dfs(root, path, 0);
    }

    public static int dfs(TreeNode curNode, Deque<Integer> path, int maxDepth) {
        // 叶子节点
        if(curNode.left == null && curNode.right == null) {
            path.add(curNode.val);
            maxDepth = Math.max(maxDepth, path.size());
            path.removeLast();
            return maxDepth;
        }

        if(curNode.left != null) {
            path.add(curNode.val);
            maxDepth = dfs(curNode.left, path, maxDepth);
            path.removeLast();
        }

        if(curNode.right != null) {
            path.add(curNode.val);
            maxDepth =dfs(curNode.right, path, maxDepth);
            path.removeLast();
        }
        return maxDepth;
    }
}
