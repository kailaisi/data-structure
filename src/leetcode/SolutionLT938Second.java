package leetcode;

/**
 * 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * 示例 1：
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * 示例 2：
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 * 提示：
 * 树中节点数目在范围 [1, 2 * 104] 内
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * 所有 Node.val 互不相同
 * 解题思路：对于二叉搜索树，其中序遍历方式是有序的，可以通过中序的方式来迭代遍历，查找满足条件的值。然后加入到和中
 * 空间复杂度：O（n）
 * 时间复杂度：O (n)
 */
class SolutionLT938Second {
    public static void main(String[] args) {
        SolutionLT938Second lt = new SolutionLT938Second();
        TreeNode root = new TreeNode(10);
        TreeNode l1 = new TreeNode(5);
        l1.left=new TreeNode(3);
        l1.right=new TreeNode(7);
        root.left=l1;
        TreeNode r1 = new TreeNode(15);
        r1.right=new TreeNode(18);
        root.right=r1;
        lt.rangeSumBST(root,7,15);
    }

    int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum=0;
        add(root,low,high);
        return sum;
    }

    private void add(TreeNode root, int low, int high) {
        if (root==null){
            return;
        }
        if (root.val<low){
            add(root.right,low,high);
        }else if (root.val>high){
            add(root.left,low,high);
        }else{
            add(root.left,low,high);
            sum+=root.val;
            add(root.right,low,high);
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