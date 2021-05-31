package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 解题思路：莫里斯方法
 * 时间复杂度：O(n)  只进行一次遍历
 * 空间复杂度：O(h)    栈深度
 */
class SolutionLT145Fore {
    public static void main(String[] args) {
        SolutionLT145Fore lt = new SolutionLT145Fore();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(lt.postorderTraversal(root));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                    printMorris(cur1.left, list);
                }
            }
            cur1 = cur1.right;
        }
        printMorris(root, list);
        return list;
    }

    /**
     * 从root开始，逆序打印对应的数据
     */
    private void printMorris(TreeNode root, ArrayList<Integer> list) {
        TreeNode revert = revert(root);
        while (revert != null) {
            list.add(revert.val);
            revert = revert.right;
        }
    }

    /**
     * 逆序当前链表
     * @param root
     * @return
     */
    private TreeNode revert(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            TreeNode right = cur.right;
            cur.right = pre;
            pre = cur;
            cur = right;
        }
        return pre;
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