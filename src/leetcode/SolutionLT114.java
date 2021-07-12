package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * 解题思路：列表。我们可以将其先按照先续遍历的方式，先保存到队列中，然后再自己生成
 * 时间复杂度：O(n)  需要进行一次遍历
 * 空间复杂度：O(n)  需要用list去存数据
 */
class SolutionLT114 {

    public static void main(String[] args) {
        SolutionLT114 lt = new SolutionLT114();
        lt.flatten(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6))));
        lt.flatten(null);
        lt.flatten(new TreeNode(0));
    }

    public void flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList<>();
        addNode(root, list);
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
        System.out.println(root);
    }

    private void addNode(TreeNode root, ArrayList<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        addNode(root.left, list);
        addNode(root.right, list);
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
