package jianzhi;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 知识点：树
 * 解题思路：
 * 既然是镜像，那么肯定是a.val=b.val   而且a.left  和b.right对称，a.right和b.left对称。
 * 通过递归迭代判断是否符合条件
 */
public class SolutionJZ58 {
    public static void main(String[] args) {
        TreeNode node8 = new TreeNode(8);
        TreeNode left6 = new TreeNode(6);
        TreeNode right6 = new TreeNode(6);
        TreeNode left5 = new TreeNode(5);
        TreeNode left7 = new TreeNode(7);
        TreeNode right7 = new TreeNode(7);
        TreeNode right5 = new TreeNode(5);
        node8.left = left6;
        node8.right = right6;
        left6.left = left5;
        left6.right = left7;
        right6.left = right7;
        right6.right = right5;
        System.out.println(isSymmetrical(node8));
    }

    static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    /**
     * 判断二者是否完全是镜像
     */
    private static boolean isSymmetrical(TreeNode left, TreeNode right) {
        //都为空，算镜像
        if (left == null && right == null) {
            return true;
        }
        //其中一个为空，不为镜像
        if (left == null || right == null) {
            return false;
        }
        //当前节点相同。而且A的左节点和B的右节点是是镜像。A的右节点跟B的左节点也是镜像
        return left.val == right.val && isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
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
