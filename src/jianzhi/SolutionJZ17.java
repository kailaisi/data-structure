package jianzhi;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 知识点：数，二叉树
 * 解题思路：
 * 注意：这里的节点，居然有相同的。而且不是排序的
 * 1.首先找到2个树的相同的节点。
 * 2.从节点开始遍历，然后看两个左右是否相等。
 */
public class SolutionJZ17 {
    public static void main(String[] args) {

    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        return isSub(root1, root2) || isSub(root2, root1);
    }

    //判断root1，是否是root2的子树
    private boolean isSub(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        TreeNode node = findNode(root1, root2);
        if (node == null) {
            return false;
        } else {
            return isMatch(root1, node);
        }
    }

    //判断节点是否相等
    private boolean isMatch(TreeNode root1, TreeNode node) {
        if (root1 == null && node == null) {//都为空，相等
            return true;
        }
        if (root1 == null || node == null) {//走到这里，说明只有一个为空
            return false;
        }
        return isMatch(root1.left, node.left) && isMatch(root1.right, node.right);
    }

    //获取到相同的节点
    private TreeNode findNode(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return null;
        }
        boolean match=false;
        boolean match1 = isMatch(root1, root2);
        if (root2.val == root1.val) {
            return root2;
        }
        TreeNode node = findNode(root1, root2.left);
        if (node != null) {
            return node;
        }
        node = findNode(root1, root2.right);
        return node;
    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
