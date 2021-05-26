package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
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
 * 解题思路：标记法
 * 时间复杂度：O(n)  只进行一次遍历
 * 空间复杂度：O(h)    栈深度
 */
class SolutionLT145Third {
    public static void main(String[] args) {
        SolutionLT145Third lt = new SolutionLT145Third();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(lt.postorderTraversal(root));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<ColorNode> nodes = new LinkedList<>();
        nodes.push(new ColorNode(false,root));
        while (!nodes.isEmpty()) {
            ColorNode pop = nodes.pop();
            if (pop.used){
                list.add(pop.node.val);
            }else{
                nodes.push(new ColorNode(true, pop.node));
                if (pop.node.right!=null) nodes.push(new ColorNode(false, pop.node.right));
                if (pop.node.left!=null) nodes.push(new ColorNode(false, pop.node.left));
            }
        }
        return list;
    }

    public static class ColorNode {
        boolean used;
        TreeNode node;

        public ColorNode(boolean used, TreeNode node) {
            this.used = used;
            this.node = node;
        }
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