package leetcode;

import java.util.ArrayList;

/**
 * 897. 递增顺序查找树
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * 示例 ：
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 * 提示：给定树中的结点数介于 1 和 100 之间。
 *     每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 * 解题思路：这里我们可以根据树，按照中序遍历存放到数组中，这时候数组是有序的，然后我们再根据题目中的要求去构建树即可
 * 空间复杂度：O（n）
 * 时间复杂度：O (n)
 */
class SolutionLT897 {
    public static void main(String[] args) {
        SolutionLT897 lt167 = new SolutionLT897();
        int[] numbers = new int[]{1, 2, 3, 4};
    }

    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(list,root);
        TreeNode header = new TreeNode(0);
        TreeNode cur=header;
        for (int v:list) {
            cur.right=new TreeNode(v);//创建一个右节点
            cur=cur.right;
        }
        return header.right;
    }

    private void inorder(ArrayList<Integer> list, TreeNode note) {
        if (note==null){
            return;
        }
        //左节点
        inorder(list,note.left);
        list.add(note.val);
        //右节点
        inorder(list,note.right);
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