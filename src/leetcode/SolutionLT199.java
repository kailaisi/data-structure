package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * 解题思路：因为要显示树的右侧数据，我们可以考虑将每一行都放入到一个list中，然后就可以通过获取list的末尾的数据来得到对应的结果
 * 如果保存list？我们可以考虑通过迭代，根据当前节点的深度来存放数据，先遍历左侧数据，然后再遍历右侧数据，从而保证同一行的数据是顺序保存到list中的
 * 时间复杂度：O（n）
 * 空间复杂度：O（n）
 */
class SolutionLT199 {
    public static void main(String[] args) {
        SolutionLT199 lt = new SolutionLT199();
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        List<Integer> list = lt.rightSideView(root);
        System.out.println(list.size());
    }


    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        addToList(root, 0, lists);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> integers = lists.get(i);
            int length = integers.size();
            res.add(integers.get(length - 1));
        }
        return res;
    }

    /**
     * 将root数据添加到list中的第deep行
     */
    private void addToList(TreeNode root, int deep, ArrayList<List<Integer>> lists) {
        if (root == null) {
            return;
        }
        if (lists.size() < deep + 1) {//如果deep行没有数据的话，这时候lists的第deep个位置是null
            lists.add(new ArrayList<>());
        }
        lists.get(deep).add(root.val);
        //添加下一行数据到lists
        addToList(root.left, deep + 1, lists);
        addToList(root.right, deep + 1, lists);
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