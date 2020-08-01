package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 * 示例：
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 * 4
 * /   \
 * 2      6
 * / \
 * 1   3
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 * 注意：
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 * 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 * 解题思路：将数据放入数组，然后再 进行排序，排序以后，前后差值最小的数据
 */
class SolutionLT783 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(10);
        root.right = new TreeNode(9);
        System.out.println(new SolutionLT783().minDiffInBST(root));
    }

    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        add(root, list);
        int[] a = new int[list.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = list.get(i);
        }
        Arrays.sort(a);
        int min= Integer.MAX_VALUE;
        for (int i = 0; i < a.length-1; i++) {
            min=Math.min(min,Math.abs(a[i]-a[i+1]));
        }
        return min;
    }

    private void add(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        add(root.left, list);
        add(root.right, list);
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