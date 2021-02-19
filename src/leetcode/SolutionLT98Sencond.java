package leetcode;

import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * 解题思路：中序排序方式。对于二叉搜索树，其对应的中序遍历满足递增的性质。所以，可以通过该性质来进行该题的解答。
 *          我们可以将树转化为一个中序的列表。因为不知道树的具体的大小，所以这里我们通过链表来保存中序队列。
 *
 * 时间复杂度：O（n）。其中n为节点数。因为每个节点都只遍历一次即可
 * 空间复杂度：O（n）。每次遍历都需要分配对应的栈空间。当节点为单链表的时候，所需要的栈列表达到最大，也就是n
 */
class SolutionLT98Sencond {
    public static void main(String[] args) {
        SolutionLT98Sencond lt = new SolutionLT98Sencond();
        TreeNode root=new TreeNode(5,new TreeNode(1),new TreeNode(4,new TreeNode(3),new TreeNode(6)));
        System.out.println(lt.isValidBST(root));//false
        root=new TreeNode(2,new TreeNode(1),new TreeNode(3));
        System.out.println(lt.isValidBST(root));//true
    }

    List<Integer> list=new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if (root==null){return true;}
        //这里每次都要进行重新赋值，否则两次调用该方法会存在问题
        list=new ArrayList<>();
        //添加到列表中
        insert(root);
        //判断列表是否满足条件。
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)<=list.get(i-1)){
                return false;
            }
        }
        return true;
    }

    private void insert(TreeNode root) {
        if (root==null){
            return;
        }
        //添加左子树
        insert(root.left);
        //添加当前节点
        list.add(root.val);
        //添加右子树
        insert(root.right);
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}