package leetcode;

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
 * 解题思路：递归方案：这里我们需要找到规律，验证二叉树的话，对于root节点，我们要保障左子树都比当前节点小，右子树都比当前节点大
 *      那么对于root节点来说，可以建立一个函数来确认是否在lower和upper区间之内。
 *      这时候遍历节点。左节点的话，更新upper为root.val。右节点的话，更新lower为root.val。然后进行迭代。
 * 时间复杂度：O（n）。其中n为节点数。因为每个节点都只遍历一次即可
 * 空间复杂度：O（n）。每次遍历都需要分配对应的栈空间。当节点为单链表的时候，所需要的栈列表达到最大，也就是n
 */
class SolutionLT98 {
    public static void main(String[] args) {
        SolutionLT98 lt = new SolutionLT98();
        TreeNode root=new TreeNode(5,new TreeNode(1),new TreeNode(4,new TreeNode(3),new TreeNode(6)));
        System.out.println(lt.isValidBST(root));
        root=new TreeNode(2,new TreeNode(1),new TreeNode(3));
        System.out.println(lt.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        if (root==null){return true;}
        return check(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }

    /**
     * 检测root以下的节点是否是在两个区间范围以内
     * @param root
     * @param maxValue
     * @param minValue
     * @return
     */
    private boolean check(TreeNode root, int maxValue, int minValue) {
        if (root==null){
            return true;
        }
        if(root.val<=minValue || root.val>=maxValue){
            return false;
        }
        return check(root.left, root.val, minValue) && check(root.right,maxValue,root.val);

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