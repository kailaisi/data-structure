package leetcode;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
class SolutionLT66 {
    public static void main(String[] args) {
        SolutionLT66 lt1078 = new SolutionLT66();
        int[] plusOne = lt1078.plusOne(new int[]{7, 6, 4, 3, 1});
        System.out.println(Arrays.toString(plusOne));
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length ;
        for (int i = len-1;i>=0;i--){
            digits[i]++;
            digits[i]=digits[i]%10;
            if(digits[i]!=0) {//如果不是0，证明+1之前是0-8之间的数据。如果是0，那么下一位继续+1，知道不为0位置。
                return digits;
            }
        }
        //走到这里说明之前所有的数据都是999,+1之后，只有第一位是1，剩下的全是0
        digits=new int[len+1];
        digits[0]=1;
        return digits;
    }
}