package jianzhi;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 知识点：树
 * 解题思路：遍历循环
 *  当查询到某个节点的时候，如果当前的
 *  目标值=val值，而且是叶子节点。那么就将当前数据添加到list，然后放入到集合中。
 *  目标值<val值，那么直接返回即可。因为只会越加值越大
 *  目标值>val值，说明可以继续➕，那么将当前节点所有的list，复制一份，一个往左遍历增加，一个遍历往右增加。
 */
public class SolutionJZ24 {
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        find(root, target, list);
        return lists;
    }

    private void find(TreeNode root, int target, ArrayList<Integer> list) {
        if (root == null || root.val > target) {
            return;
        } else if (root.val == target && root.left==null && root.right==null) {
            list.add(root.val);
            lists.add(list);
        } else {
            list.add(root.val);
            ArrayList<Integer> copy = new ArrayList<>(list);
            find(root.left, target - root.val, copy);
            find(root.right, target - root.val, list);
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
