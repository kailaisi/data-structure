package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 示例 2：
 *
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 *
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 *  
 *
 * 提示：
 *
 * 0 ≤ N ≤ 30
 *
 * 来源：力扣（LeetCode）
 */
class SolutionLT509 {

    public static void main(String[] args) {
        SolutionLT509 lt = new SolutionLT509();
        int lists = lt.fib(4);
        System.out.println(lists);
    }

    public int fib(int N) {
        if(N<1){
            return 0;
        }
        int[] ints = new int[N+1];
        ints[0]=0;
        ints[1]=1;
        for(int i=2;i<N+1;i++){
            ints[i]=ints[i-1]+ints[i-2];
        }
        return ints[N];
    }
}