package leetcode;

/**
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 * <p>
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 二叉树: [1,2,3,4]
 * 1
 * /   \
 * 2     3
 * /
 * 4
 * <p>
 * 输出: "1(2(4))(3)"
 * <p>
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 * 示例 2:
 * <p>
 * 输入: 二叉树: [1,2,3,null,4]
 * 1
 * /   \
 * 2     3
 * \
 * 4
 * <p>
 * 输出: "1(2()(4))(3)"
 * <p>
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class SolutionLT606 {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        addNode(t, sb);
        return sb.toString();
    }

    private void addNode(TreeNode t, StringBuilder sb) {
        if (t == null) {
            return;
        }
        if (t.left == null && t.right == null) {//如果左右子节点都为空，则直接添加值
            sb.append(t.val);
        } else {
            sb.append(t.val);
            if (t.right != null || t.left != null) {//如果存在右节点，那么需要将左节点的()也添加上去。
                sb.append("(");
                addNode(t.left, sb);
                sb.append(")");
            }
            if (t.right != null) {//添加右节点，有()包裹
                sb.append("(");
                addNode(t.right, sb);
                sb.append(")");
            }
        }
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