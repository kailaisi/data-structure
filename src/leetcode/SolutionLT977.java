package leetcode;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */
class SolutionLT977 {
    //todo 未完成
    public int[] sortedSquares(int[] A) {
        int start = 0, end = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            if (A[i] < 0) {
                start++;
                end++;
            } else {
                end++;
                break;
            }
        }
        if (end >= length) {//保证不会越界
            end = length - 1;
        }
        int[] ints = new int[length];
        int index=0;
        while (start != 0 && end != length-1) {
            if(Math.abs(A[start])>Math.abs(A[end])){
                ints[index]=(int) Math.sqrt(A[start]);
                start--;
            }
            index++;
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