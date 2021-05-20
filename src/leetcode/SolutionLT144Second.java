package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
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
 * 输出：[1,2]
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
 * 解题思路：迭代
 * 时间复杂度：O(n)  只进行一次遍历
 * 空间复杂度：O(n)
 */
class SolutionLT144Second {
    public static void main(String[] args) {
        SolutionLT144Second lt = new SolutionLT144Second();
        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        System.out.println(lt.preorderTraversal(root));

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> list = new LinkedList<>();
        while (!list.isEmpty() || root!=null) {
            while (root!=null){
                res.add(root.val);
                list.push(root);
                root=root.left;
            }
            TreeNode pop = list.pop();
            root=pop.right;
        }
        return res;
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