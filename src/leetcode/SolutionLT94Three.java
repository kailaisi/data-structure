package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 解题思路：颜色标记法。具体使用规则参考算法文件的xmind
 * 时间复杂度：O(n)  只进行一次遍历
 * 空间复杂度：O(n)
 */
class SolutionLT94Three {
    public static void main(String[] args) {
        SolutionLT94Three lt = new SolutionLT94Three();
        TreeNode node=new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
        lt.inorderTraversal(node);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root==null){
            return list;
        }
        Stack<Node> nodes = new Stack<>();
        nodes.push(new Node(root,false));
        while (!nodes.isEmpty()){
            Node pop = nodes.pop();
            if(!pop.used){
                if (pop.node.right!=null) nodes.push(new Node(pop.node.right,false));
                nodes.push(new Node(pop.node,true));
                if (pop.node.left!=null) nodes.push(new Node(pop.node.left,false));
            }else{
                list.add(pop.node.val);
            }
        }
        return list;
    }

    public static class Node{
        TreeNode node;
        boolean used;
        public Node(TreeNode node,boolean used){
            this.node=node;
            this.used=used;
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