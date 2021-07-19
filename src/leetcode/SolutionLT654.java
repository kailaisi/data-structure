package leetcode;

import java.util.Arrays;

/**
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * <p>
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 * <p>
 * 示例 1：
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 * - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 * - 空数组，无子节点。
 * - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 * - 空数组，无子节点。
 * - 只有一个元素，所以子节点是一个值为 1 的节点。
 * - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 * - 只有一个元素，所以子节点是一个值为 0 的节点。
 * - 空数组，无子节点。
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 * 提示：
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * nums 中的所有整数 互不相同
 * <p>
 * 解题思路：对于树结构，最常用的方式其实是递归调用。对于任何一个位置，我们找到其中的最大节点，然后将节点一分为二，然后左右两侧，在分别递归调用方法，进行处理
 * * 时间复杂度：O（N^2）：每次constructTree的时候，都需要需要遍历一次，找到最大值
 * * 空间复杂度：O（N）：需要用列表来保存
 */
class SolutionLT654 {
    public static void main(String[] args) {
        SolutionLT654 lt = new SolutionLT654();
        System.out.println(lt.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}));//
        System.out.println(lt.constructMaximumBinaryTree(new int[]{3,2,1}));//
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode tree = constructTree(nums, 0, nums.length);
        return tree;
    }

    private TreeNode constructTree(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int max = left;
        //遍历找到left和right之间的最大节点
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode root = new TreeNode(nums[max]);
        root.left = constructTree(nums, left, max);
        root.right = constructTree(nums, max + 1, right);
        return root;
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