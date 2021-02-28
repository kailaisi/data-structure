package leetcode;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。  根节点的值为 5 ，但是其右子节点值为 4 。
 * 思路：
 * 空间复杂度：O(1)。
 */
class SolutionLT98 {

    public static void main(String[] args) {
        SolutionLT98 lt = new SolutionLT98();
        System.out.println(lt.isValidBST(new TreeNode(5,new TreeNode(1),new TreeNode(4,new TreeNode(3),new TreeNode(6)))));//flase
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftValid = true;
        boolean rightValid = true;
        if ((root.left != null )) {
            leftValid = root.left.val < root.val && isValidBST(root.left);
        }
        if (root.right != null ) {
            rightValid = root.right.val > root.val&& isValidBST(root.right);
        }
        return leftValid && rightValid;
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