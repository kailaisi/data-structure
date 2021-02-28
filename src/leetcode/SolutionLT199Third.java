package leetcode;

import com.sun.corba.se.spi.ior.IdentifiableFactory;
import com.sun.javafx.iio.gif.GIFImageLoaderFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * 解题思路：之前的思路都是从左往右，从广度优先的方式去处理每层的数据，但是其实我们关注的是每行最右侧的节点，我们可以通过根结点，右子树，左子树的方式去迭代
 *          如果当前深度没有数据，就添加到列表中
 * 时间复杂度：O（n）
 * 空间复杂度：O（n）
 */
class SolutionLT199Third {

    public static void main(String[] args) {
        SolutionLT199Third lt = new SolutionLT199Third();
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        List<Integer> list = lt.rightSideView(root);
        System.out.println(list.size());
    }

    List<Integer> res=new ArrayList<Integer>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return res;
    }

    private void dfs(TreeNode root, int deep) {
        if (root==null){
            return;
        }
        if (res.size()<=deep){
            res.add(root.val);
        }
        dfs(root.right,deep+1);
        dfs(root.left,deep+1);
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