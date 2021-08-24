package binaryTree;

/**
 * @Description 二叉树的直径
 * 求一个二叉树的最长直径。直径的定义是二叉树上任意两节点之间的无向距离。这条路径可能穿过也可能不穿过根结点。
 * 任意一条路径均可以被看作由某个节点为起点，从其左子树和右子树向下遍历的路径拼接得到。
 * 遍历所有节点，求出以该节点为起点的直径，再在所有直径中求出最大值。
 * 遍历所有节点时，
 * 一方面，求出以该节点为起点的直径，depth(curNode.left) + depth(curNode.right);
 * 另一方面，递归求高度 Math.max(depth(curNode.left), depth(curNode.right)) + 1.
 * @Tag 树的递归
 * @Date 2021/8/24
 */

public class DiameterOfBinaryTree_543 {
    public static void main(String[] argus) {
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node2 = new TreeNode(2, node4, node5);
//        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1, node2, null);

        System.out.println(diameterOfBinaryTree(node1));
    }

    public static int maxd = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxd;
    }

    public static int depth(TreeNode curNode) {
        if (curNode == null) return 0;

        int L = depth(curNode.left);
        int R = depth(curNode.right);
        //每个节点最大直径与当前最大值比较
        maxd = Math.max(L + R, maxd);
        //返回节点深度
        return Math.max(L, R) + 1;
    }
}
