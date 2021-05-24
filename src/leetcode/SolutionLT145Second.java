package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 解题思路：递归
 * 时间复杂度：O(n)  只进行一次遍历
 * 空间复杂度：O(h)    栈深度
 */
class SolutionLT145Second {
    public static void main(String[] args) {
        SolutionLT145Second lt = new SolutionLT145Second();
        TreeNode root = new TreeNode(1, null,new TreeNode(2, new TreeNode(3),null));
        System.out.println(lt.preorderTraversal(root));
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        //记录当前遍历的根节点
        TreeNode pre=root;
        LinkedList<TreeNode> nodes = new LinkedList<>();

        while (!nodes.isEmpty() || root!=null){
            while (root!=null){
                nodes.add(root);
                root=root.left;
            }
            //弹出
            TreeNode pop = nodes.pop();
            if (pop.right!=null && pop.right!=pre){
                nodes.push(pop);

                nodes.push(pop.right);
            }else{
                list.add(pop.val);
            }
        }
        return list;
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