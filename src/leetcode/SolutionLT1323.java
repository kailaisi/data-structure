package leetcode;

/**
 * 给你一个仅由数字 6 和 9 组成的正整数 num。
 * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
 * 请返回你可以得到的最大数字。
 * 示例 1：
 * 输入：num = 9669
 * 输出：9969
 * 解释：
 * 改变第一位数字可以得到 6669 。
 * 改变第二位数字可以得到 9969 。
 * 改变第三位数字可以得到 9699 。
 * 改变第四位数字可以得到 9666 。
 * 其中最大的数字是 9969 。
 * 示例 2：
 * 输入：num = 9996
 * 输出：9999
 * 解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
 * 示例 3：
 * 输入：num = 9999
 * 输出：9999
 * 解释：无需改变就已经是最大的数字了。
 *
 * 提示：
 * 1 <= num <= 10^4
 * num 每一位上的数字都是 6 或者 9 。
 * 解题思路：用数组保存，然后找到数组中第一个6，将其变为9
 *
 */
class SolutionLT1323 {
    public static void main(String[] args) {
        SolutionLT1323 lt53 = new SolutionLT1323();
        System.out.println(lt53.maximum69Number(66));
    }

    public int maximum69Number (int num) {
        int[] ints = new int[4];
        for(int i=0;i<4;i++){
            ints[i]=num%10;
            num=num/10;
        }

        for(int i=3;i>=0;i--){
            if(ints[i]==6){
                ints[i]=9;
                break;
            }
        }
        int result=ints[3];
        for(int i=2;i>=0;i--){
            result=result*10+ints[i];
        }
        return result;
    }
}