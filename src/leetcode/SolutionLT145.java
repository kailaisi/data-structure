package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 解题思路：递归
 * 时间复杂度：O(n)  只进行一次遍历
 * 空间复杂度：O(n)    栈深度
 */
class SolutionLT145 {
    public static void main(String[] args) {
        SolutionLT145 lt = new SolutionLT145();
        TreeNode root = new TreeNode(1, null,new TreeNode(2, new TreeNode(3),null));
        System.out.println(lt.preorderTraversal(root));
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postorderTraversal(list,root);
        return list;
    }

    private void postorderTraversal(ArrayList<Integer> list, TreeNode root) {
        if (root==null){
            return;
        }
        postorderTraversal(list,root.left);
        postorderTraversal(list,root.right);
        list.add(root.val);
    }

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
}