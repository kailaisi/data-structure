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
 * 解题思路：中序排序方式。对于二叉搜索树，其对应的中序遍历满足递增的性质。所以，可以通过该性质来进行该题的解答。
 * 对于节点，只需要判断当前节点大于其中序遍历的前一个节点即可。
 *
 * 时间复杂度：O（n）。其中n为节点数。因为每个节点都只遍历一次即可
 * 空间复杂度：O（n）。每次遍历都需要分配对应的栈空间。当节点为单链表的时候，所需要的栈列表达到最大，也就是n
 */
class SolutionLT98Third {
    public static void main(String[] args) {
        SolutionLT98Third lt = new SolutionLT98Third();
        TreeNode root=new TreeNode(5,new TreeNode(1),new TreeNode(4,new TreeNode(3),new TreeNode(6)));
        //System.out.println(lt.isValidBST(root));
        root=new TreeNode(2,new TreeNode(1),new TreeNode(3));
        System.out.println(lt.isValidBST(root));
    }

    private long preValue=Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root==null){return true;}
        //判断左子树是否满足条件
        if (!isValidBST(root.left)){
            return false;
        }
        //如果当前节点小于前一个节点，则返回false.
        if (root.val<=preValue){
            return false;
        }
        //将当前节点信息置为pre值
        preValue=root.val;
        //判断右子树是否满足条件。
        return isValidBST(root.right);
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