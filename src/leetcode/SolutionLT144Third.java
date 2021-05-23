package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *144. 二叉树的前序遍历
 *  * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *  *
 *  *
 *  *
 *  * 示例 1：
 *  *
 *  *
 *  * 输入：root = [1,null,2,3]
 *  * 输出：[1,2,3]
 *  * 示例 2：
 *  *
 *  * 输入：root = []
 *  * 输出：[]
 *  * 示例 3：
 *  *
 *  * 输入：root = [1]
 *  * 输出：[1]
 *  * 示例 4：
 *  *
 *  *
 *  * 输入：root = [1,2]
 *  * 输出：[1,2]
 *  * 示例 5：
 *  *
 *  *
 *  * 输入：root = [1,null,2]
 *  * 输出：[1,2]
 *  *
 *  *
 *  * 提示：
 *  *
 *  * 树中节点数目在范围 [0, 100] 内
 *  * -100 <= Node.val <= 100
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 解题思路：标记法。用点标记是否进行了记录
 * 时间复杂度：O(n)  只进行一次遍历
 * 空间复杂度：O(n)
 */
class SolutionLT144Third {
    public static void main(String[] args) {
        SolutionLT144Third lt = new SolutionLT144Third();
        TreeNode node = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(lt.preorderTraversal(node));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<ColorNode> nodes = new Stack<>();
        nodes.push(new ColorNode(root, false));
        while (!nodes.isEmpty()) {
            ColorNode pop = nodes.pop();
            if (!pop.isUsed){
                if(pop.node.right!=null) nodes.add(new ColorNode(pop.node.right,false));
                if(pop.node.left!=null) nodes.add(new ColorNode(pop.node.left,false));
                nodes.add(new ColorNode(pop.node,true));
            }else{
                list.add(pop.node.val);
            }
        }
        return list;
    }

    public static class ColorNode {
        public TreeNode node;
        public boolean isUsed;

        public ColorNode(TreeNode node, boolean isUsed) {
            this.node = node;
            this.isUsed = isUsed;
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