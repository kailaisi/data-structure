package leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * 解题思路：最后要保留一定的个数，如果从前面来计算，比较复杂，我们可以考虑从后面往前进行数字的获取。比如说第一个题目：num = "1432219", k = 3
 *          最后保留的个数是4位，我们从末尾开始：2219 ，然后往前，如果发发现比2小的，肯定就要丢弃2了   结果只发现了1，所以最后保留的是1219
 *          还有一种情况：比如说11432219，   找到最后最后4位，2219，当遇到第一个1的时候，我们
 * 时间复杂度：O（N^2）：
 * 空间复杂度：O（1）
 */
class SolutionLT402 {
    public static void main(String[] args) {
        SolutionLT402 lt = new SolutionLT402();
        System.out.println(lt.reorganizeString("aab"));//aba
        System.out.println(lt.reorganizeString("aaab"));//""
    }

    public String removeKdigits(String num, int k) {

    }}
