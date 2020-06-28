package jianzhi;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 知识点：树
 * 解题思路：
 */
public class SolutionJZ24 {
    public static void main(String[] args) {
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        find(root, target, lists);
        //todo
        return lists;
    }

    private void find(TreeNode root, int target, ArrayList<ArrayList<Integer>> lists) {
        if (root == null || root.val > target) {
            return;
        }
        if (lists.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            lists.add(list);
        }
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
