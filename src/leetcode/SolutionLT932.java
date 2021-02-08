package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 932. 漂亮数组
 * 对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：
 * 对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。
 * 那么数组 A 是漂亮数组。
 * 给定 N，返回任意漂亮数组 A（保证存在一个）。
 * <p>
 * 示例 1：
 * 输入：4
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：5
 * 输出：[3,1,2,5,4]
 * 提示：
 * 1 <= N <= 10009
 * <p>
 * 解题思路：该体一看懵逼，再看更懵逼。入手点肯定就是不满足A[k] * 2 = A[i] + A[j]这个公式了。
 * 这个公式很显然，左边是偶数，那么恒不成立的话，右边弄成奇数。可以将数组分为两部分，左为奇数，右为偶数。
 * 那么拆分之后，左边都是奇数了，又该怎么办？我们可以看下这个奇数数字可否进行一些变换：
 * 从简单的开始：[1,3,5,7]是否可以看成是[1,2,3,4]->通过+1/2来生成的。A[k] * 2 = A[i] + A[j]=>  2(a[k]*2-1)=2((a[i]-1)+(a[j]-1))
 *               [2,4,6,8]可以看成是2倍的[1,2,3,4]  2(a[k]*2)=2((a[i])+(a[j]))
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(logn)
 */
class SolutionLT932 {
    public static void main(String[] args) {
        SolutionLT932 lt = new SolutionLT932();
        System.out.println(Arrays.toString(lt.beautifulArray(4)));
        System.out.println(Arrays.toString(lt.beautifulArray(8)));
    }

    Map<Integer,int[]> map=new HashMap<Integer,int[]>();
    public int[] beautifulArray(int N) {
        return f(N);
    }

    private int[] f(int n) {
        if(map.containsKey(n)){
            return map.get(n);
        }
        int[] ans = new int[n];
        if(n==1){
            ans[0]=1;
        }else {
            int t=0;
            for(int x:f((n+1)/2)){//迭代左侧的奇数部分
                ans[t++]=2*x-1;
            }
            for(int x:f((n/2))){//迭代右侧的偶数部分
                ans[t++]=2*x;
            }
        }
        map.put(n,ans);
        return ans;

    }

}