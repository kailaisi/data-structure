package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * *
 * *
 * *
 * * 示例 1：
 * *
 * *
 * * 输入：root = [1,null,2,3]
 * * 输出：[1,2,3]
 * * 示例 2：
 * *
 * * 输入：root = []
 * * 输出：[]
 * * 示例 3：
 * *
 * * 输入：root = [1]
 * * 输出：[1]
 * * 示例 4：
 * *
 * *
 * * 输入：root = [1,2]
 * * 输出：[1,2]
 * * 示例 5：
 * *
 * *
 * * 输入：root = [1,null,2]
 * * 输出：[1,2]
 * *
 * *
 * * 提示：
 * *
 * * 树中节点数目在范围 [0, 100] 内
 * * -100 <= Node.val <= 100
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 解题思路：莫里斯
 * 时间复杂度：O(n)  只进行一次遍历
 * 空间复杂度：O(1) 没有额外的空间消耗
 */
class SolutionLT144Fore {
    public static void main(String[] args) {
        SolutionLT144Fore lt = new SolutionLT144Fore();
        TreeNode node = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(lt.preorderTraversal(node));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        //记录左子树
        TreeNode left;
        while (cur != null) {
            left = cur.left;
            //有左节点
            if (left != null) {
                //找到当前节点的最右边节点
                while (left.right != null && left.right != cur) {
                    left = left.right;
                }
                if (left.right == null) {//找到了最右边的节点，并且没有建立连接
                    res.add(cur.val);
                    left.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    left.right = null;
                }
            } else {//没有左节点了，直接记录数据
                res.add(cur.val);
            }
            cur=cur.right;
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