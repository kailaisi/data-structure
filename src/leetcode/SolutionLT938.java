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
 * 解题思路：我们这里会根据树的特性，迭代所有的值，查看是否满足条件，如果满足则添加和，否则就按照0处理
 * 空间复杂度：O（n）
 * 时间复杂度：O (n)
 */
class SolutionLT938 {
    public static void main(String[] args) {
        SolutionLT938 lt = new SolutionLT938();
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

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root==null){
            return 0;
        }
        int temp=0;
        if (root.val>=low && root.val<=high){
            temp=root.val;
        }
        return temp+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
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