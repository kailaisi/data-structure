package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 865 给定一个根为 root 的二叉树，每个结点的深度是它到根的最短距离。
 * <p>
 * 如果一个结点在整个树的任意结点之间具有最大的深度，则该结点是最深的。
 * <p>
 * 一个结点的子树是该结点加上它的所有后代的集合。
 * <p>
 * 返回能满足“以该结点为根的子树中包含所有最深的结点”这一条件的具有最大深度的结点。
 * 返回它的最大深度。
 * 解题思路：本题的实际含义是找到所有最深的节点的公共父类。
 * 可以考虑先深度遍历，可以记录所有节点的深度，然后从根节点开始，如果节点的子节点包含了所有的最深节点，则返回，否则继续下一个遍历
 */
class SolutionLT865 {
    public static void main(String[] args) {

    }

    //保存节点以及其对应的深度值
    Map<TreeNode, Integer> map;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        map = new HashMap<>();
        int maxdeep = def(root, 0);
        return getNode(root, maxdeep);
    }

    private TreeNode getNode(TreeNode root, int maxdeep) {
        if (root == null || map.get(root) == maxdeep) {//当前节点就是最大深度了
            return root;
        }
        //查看左右树到最大深度是否一致
        TreeNode left = getNode(root.left, maxdeep);
        TreeNode right = getNode(root.right, maxdeep);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }

    /**
     * root 以及更上一层节点的深度deep
     *
     * @return
     */
    private int def(TreeNode root, int deep) {
        if (root == null) {
            return deep;
        }
        map.put(root, deep + 1);
        return Math.max(def(root.left, deep + 1), def(root.right, deep + 1));
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
