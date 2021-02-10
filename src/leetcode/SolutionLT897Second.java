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
 * 解题思路：同样是进行中序遍历，但是遍历过程中，我们不再进行数据的保存，而是通过指针的修改，而改变树的结构。
 *          通过迭代，先处理左侧的节点，然后处理当前节点的指针问题，最后处理右侧数据
 * 空间复杂度：O（n）
 * 时间复杂度：O (H)  H为树的高度
 */
class SolutionLT897Second {
    public static void main(String[] args) {
        SolutionLT897Second lt167 = new SolutionLT897Second();
        int[] numbers = new int[]{1, 2, 3, 4};
    }

    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode header = new TreeNode(0);
        cur=header;
        inorder(root);
        return header.right;
    }

    private void inorder(TreeNode note) {
        if (note==null){
            return;
        }
        inorder(note.left);

        note.left=null;

        cur.right=note;
        cur=note;
        //右节点
        inorder(note.right);
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