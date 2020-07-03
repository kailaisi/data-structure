package jianzhi;

import java.util.ArrayList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 知识点：树，队列
 * 解题思路：既然是按行打印，那么我们只需要有一个队列来保存从左到右的node节点信息。
 * 然后遍历。将本层的数据放到int的list中。同时将下一层的node节点放入到新的list中。遍历执行即可
 */
public class SolutionJZ22 {

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
        System.out.println(PrintFromTopToBottom(node8));
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return integers;
        }
        list.add(root);
        addAllTreeNode(list, integers);
        return integers;
    }

    private static void addAllTreeNode(ArrayList<TreeNode> list, ArrayList<Integer> integers) {
        if (!list.isEmpty()) {
            ArrayList<TreeNode> list1 = new ArrayList<>();
            for(int i=0;i<list.size();i++){
                integers.add(list.get(i).val);
                if(list.get(i).left!=null){
                    list1.add(list.get(i).left);
                }
                if(list.get(i).right!=null){
                    list1.add(list.get(i).right);
                }
            }
            addAllTreeNode(list1, integers);
        }else {
            return;
        }
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
