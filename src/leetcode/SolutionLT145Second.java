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
        System.out.println(lt.postorderTraversal(root));
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        //记录当前遍历的根节点
        TreeNode pre=root;
        LinkedList<TreeNode> nodes = new LinkedList<>();

        while (!nodes.isEmpty() || root!=null){
            //加入所有的左节点
            while (root!=null){
                nodes.add(root);
                root=root.left;
            }
            //弹出
             root = nodes.pop();
            if (root.right!=null && root.right!=pre){
                //右子树存在，并且没有访问过，那么就访问右节点，
                //把跟节点先放进队列中
                nodes.push(root);
                root=root.right;
            }else{
                list.add(root.val);
                //记录当前访问的节点为pre，
                // 那么下一次pop出来的，如果发现其右节点=当前节点
                // 证明是已经遍历完成的右节点
                pre=root;
                root=null;
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