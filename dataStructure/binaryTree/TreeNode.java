package binaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Description 初始化树，广度优先
 * @Tag 队列
 * @Date 2021/8/23
 */

public class TreeNode {
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

    public static TreeNode initTree(Integer[] arr) {
        if (arr.length == 0) return null;

        TreeNode[] nodeArr = new TreeNode[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                nodeArr[i] = null;
            } else {
                nodeArr[i] = new TreeNode(arr[i]);
            }
        }
        
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(nodeArr[0]);
        int idx = 1;
        while (idx < nodeArr.length) {
            TreeNode curNode = deque.pollFirst();

            deque.addLast(nodeArr[idx++]);
            curNode.left = deque.peekLast();
            deque.addLast(nodeArr[idx++]);
            curNode.right = deque.peekLast();
        }
        return nodeArr[0];
    }
}
