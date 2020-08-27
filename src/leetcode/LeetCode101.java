package leetcode;

import java.util.TreeMap;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * 进阶：
 * <p>
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 * 解题思路：
 *  * 既然是镜像，那么肯定是a.val=b.val   而且a.left  和b.right对称，a.right和b.left对称。
 *  * 通过递归迭代判断是否符合条件
 */
class LeetCode101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left= left;
        left.right=new TreeNode(2);
        left.left=new TreeNode(3);
        left.right=new TreeNode(4);
        root.right=new TreeNode(20);
        boolean depth = new LeetCode101().isSymmetric(root);
        System.out.println(depth);
    }
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return  isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left==null && right==null){
            //都为空，则对称
            return true;
        }
        if(left==null || right==null){
            //一个为空，则不对称
            return false;
        }
        //当前节点相同。而且A的左节点和B的右节点是是镜像。A的右节点跟B的左节点也是镜像
        return left.val==right.val && isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
