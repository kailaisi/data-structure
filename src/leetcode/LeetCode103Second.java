package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * 解题思路：栈，todo 待写
 */
class LeetCode103Second {
    public static void main(String[] args) {
        System.out.println(new LeetCode103Second().zigzagLevelOrder(new TreeNode(3, new TreeNode(9, new TreeNode(15), null), new TreeNode(20, null, new TreeNode(7)))));
        TreeNode root = new TreeNode(0, new TreeNode(2, new TreeNode(1, new TreeNode(5), new TreeNode(1)), null), new TreeNode(4, new TreeNode(3, null, new TreeNode(6)), new TreeNode(-1, null, new TreeNode(8))));
        System.out.println(new LeetCode103Second().zigzagLevelOrder(root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<TreeNode> nodes = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        // TODO: 2021/6/1
        return lists;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
