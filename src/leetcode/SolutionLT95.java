package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * 示例：
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * 提示：
 * 0 <= n <= 8
 * 解题思路：通过递归方案。
 */
class SolutionLT95 {
    public static void main(String[] args) {
    }

    public List<TreeNode> generateTrees(int n) {
        if(n<1){
            return new ArrayList<>();
        }
       return generateTrees(1,n);
    }

    //生成从start->end所有的根节点信息
    private LinkedList<TreeNode> generateTrees(int start, int end) {
        LinkedList<TreeNode> list = new LinkedList<>();
        if(start>end){
            list.add(null);
            return list;
        }
        for(int i=start;i<=end;i++){
            //以i为根节点，left会生成多个start->i-1为根节点的数据。根节点的列表为left
            LinkedList<TreeNode> left = generateTrees(start, i-1);
            //生成的右边的根节点所有的列表
            LinkedList<TreeNode> right = generateTrees(i + 1, end);
            //左右两边各取一个，都可以组合到根节点下面。
            for(TreeNode leftNode:left){
                for (TreeNode rightNode:right){
                    TreeNode node = new TreeNode(i);
                    node.left=leftNode;
                    node.right=rightNode;
                    list.add(node);
                }
            }
        }
        return list;
    }


    public class TreeNode {
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