package binaryTree;

/**
 * @Description 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
 * 104 二叉树的最大深度-延申，递归求高度
 * @Tag 树的递归
 * @Date 2021/8/24
 */

public class BalancedBinaryTree_110 {
    public static void main(String[] argus) {
        TreeNode node5 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        TreeNode node3 = new TreeNode(20, node5, node4);
        TreeNode node2 = new TreeNode(9);
        TreeNode node1 = new TreeNode(3, node2, node3);

        System.out.println(isBalanced(node1));
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return Math.abs(depth(root.left)-depth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public static int depth(TreeNode curNode) {
        if(curNode == null) return 0;

        return Math.max(depth(curNode.left), depth(curNode.right)) + 1;
    }
}
