package leetcode;

import com.sun.deploy.panel.ITreeNode;

/**
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 * 提示：
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 * 解题思路：莫里斯方式。展开这棵树的方式：
 * 1。如果当前节点A，有左侧节点B，那么找到左侧节点的最右边的节点C（就是一直找right）。
 * 2。然后将顺序进行调整。A->B     C->A.right    A.left=null    这样就相当于把A节点的左侧节点挂到了右侧。
 * 3。然后将A.right作为跟节点，然后重复1-3的过程
 * 时间复杂度：O(n)  需要进行一次遍历
 * 空间复杂度：O(1)  不需要额外的空间进行存储
 */
class SolutionLT114Second {

    public static void main(String[] args) {
        SolutionLT114Second lt = new SolutionLT114Second();
        lt.flatten(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6))));
        lt.flatten(null);
        lt.flatten(new TreeNode(0));
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode right = root;
        //存在分支节点
        while (right!=null) {
            //1步骤，存在左侧分支
            if (right.left != null) {
                //当前节点的左侧不为空
                TreeNode left = right.left;
                //找到左侧节点的最右边节点
                while (left.right != null && left.right != right) {
                    left = left.right;
                }
                //调整指针指向
                left.right = right.right;
                right.right = right.left;
                right.left = null;
            }
            //指向下一个节点
            right = right.right;
        }
        System.out.println(root);
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
