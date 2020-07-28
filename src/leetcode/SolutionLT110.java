package leetcode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 解题思路：使用迭代的方式，逐次判断左右子树是否是高度平衡的二叉树
 * 这里可以根据左右子树的高度来进行迭代完成条件的处理。
 * 如果左右子树的高度绝对值超过1，则直接返回false。
 */
class SolutionLT110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        root.left= left;
        left.left=new TreeNode(18);
        root.right=new TreeNode(20);
        boolean depth = new SolutionLT110().isBalanced(root);
        System.out.println(depth);
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        if(Math.abs(maxDepth(root.left)-maxDepth(root.right))>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}