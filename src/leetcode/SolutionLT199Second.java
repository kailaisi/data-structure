package leetcode;

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
 * 解题思路：因为要显示树的右侧数据，在第一种方案中，我们是使用的List来保存每行的数据的，是按照广度优先原则进行了遍历。
 *          在本次中，我们可以尝试使用queue来保存，也是采用广度优先原则，queue保存当前行的数据，然后最后一个就是我们最右边的数据。
 *
 * 时间复杂度：O（n）
 * 空间复杂度：O（n）
 */
class SolutionLT199Second {
    public static void main(String[] args) {
        SolutionLT199Second lt = new SolutionLT199Second();
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, new TreeNode(4)));
        List<Integer> list = lt.rightSideView(root);
        System.out.println(list.size());
    }


    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();//用于保存每行的节点
        ArrayList<Integer> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = nodes.poll();
                if (poll.left != null) {
                    nodes.add(poll.left);
                }
                if (poll.right != null) {
                    nodes.add(poll.right);
                }
                if (i == size - 1) {
                    res.add(poll.val);
                }
            }
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