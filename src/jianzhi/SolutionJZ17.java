package jianzhi;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 知识点：数，二叉树
 * 解题思路：
 * 注意：这里的节点，居然有相同的。而且不是排序的
 * 1.首先找到2个树的相同的节点。
 * 2.从节点开始遍历，然后看两个树是否包含。
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
        if (root2 == null) {
            return false;
        }
        //当前节点相等，判断节点之下的数据是否匹配
        if (root1.val == root2.val && isMatch(root1, root2)) {
            return true;
        }
        //节点不相等。遍历root的左右两个节点
        return isSub(root1, root2.left) || isSub(root1, root2.right);
    }

    //判断node节点是否包含root1
    private boolean isMatch(TreeNode root1, TreeNode node) {
        if (root1 == null) {//root1为空,证明node完全包含了root1的数据
            return true;
        }
        if (node == null) {//走到这里，说明node完了，root1没走完。肯定就不匹配了
            return false;
        }
        //判断当前节点相等，且其左右之后的节点都匹配
        return root1.val==node.val && isMatch(root1.left, node.left) && isMatch(root1.right, node.right);
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
