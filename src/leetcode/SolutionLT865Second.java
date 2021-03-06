package leetcode;

/**
 * 865 给定一个根为 root 的二叉树，每个结点的深度是它到根的最短距离。
 * <p>
 * 如果一个结点在整个树的任意结点之间具有最大的深度，则该结点是最深的。
 * <p>
 * 一个结点的子树是该结点加上它的所有后代的集合。
 * <p>
 * 返回能满足“以该结点为根的子树中包含所有最深的结点”这一条件的具有最大深度的结点。
 * 返回它的最大深度。
 * 解题思路：本题的实际含义是找到所有最深的节点的公共父类。
 * 其思路肯定是先深度遍历，可以记录所有节点的深度，然后从根节点开始，如果节点的子节点包含了所有的最深节点，则返回，否则
 */
class SolutionLT865Second {
    public static void main(String[] args) {
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return def(root).node;
    }

    /**
     * 返回子树的节点信息
     */
    private Result def(TreeNode root) {
        if (root == null) {
            return new Result(null, 0);
        }
        Result left = def(root.left);
        Result right = def(root.right);
        if (left.dist > right.dist) {
            return new Result(left.node, left.dist + 1);
        }
        if (left.dist < right.dist) {
            return new Result(right.node, right.dist + 1);
        }
        return new Result(root, left.dist + 1);
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

class Result {
    //节点
    SolutionLT865Second.TreeNode node;
    //节点深度
    int dist;

    Result(SolutionLT865Second.TreeNode n, int d) {
        node = n;
        dist = d;
    }
}