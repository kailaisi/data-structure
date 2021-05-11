package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 解题思路：迭代。迭代相当于将递归的栈处理拿出来进行记录
 * 时间复杂度：O(n)  只进行一次遍历
 * 空间复杂度：O(1)
 */
class SolutionLT94Second {
    public static void main(String[] args) {
        SolutionLT94Second lt = new SolutionLT94Second();
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        while (root!=null || !linkedList.isEmpty()) {
            while (root != null) {
                linkedList.add(root);
                root = root.left;
            }
            root=linkedList.pop();
            list.add(root.val);
            root=root.right;
        }
        return list;
    }

    private void inorderTraversal(ArrayList<Integer> list, TreeNode root) {
        if (root==null){
            return;
        }
        inorderTraversal(list,root.left);
        list.add(root.val);
        inorderTraversal(list,root.right);
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