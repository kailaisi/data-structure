package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * 解题思路：
 */
class LeetCode102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode left6 = new TreeNode(6);
        TreeNode right6 = new TreeNode(6);
        TreeNode left5 = new TreeNode(5);
        TreeNode left7 = new TreeNode(7);
        TreeNode right7 = new TreeNode(7);
        TreeNode right5 = new TreeNode(5);
        root.left = left6;
        root.right = right6;
        left6.left = left5;
        left6.right = left7;
        right6.left = right7;
        right6.right = right5;
        System.out.println(new LeetCode102().levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        ArrayList<TreeNode> nodes = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        nodes.add(root);
        while (nodes.size() > 0) {
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<TreeNode> nodes1 = new ArrayList<>();
            for (TreeNode node : nodes) {
                list.add(node.val);
                if (node.left != null) {
                    nodes1.add(node.left);
                }
                if (node.right != null) {
                    nodes1.add(node.right);
                }
            }
            lists.add(list);
            nodes.clear();
            nodes.addAll(nodes1);
        }
        return lists;
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
