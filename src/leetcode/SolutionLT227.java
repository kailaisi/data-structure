package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 227. 基本计算器 II
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * 示例 1：
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 * <p>
 * 解题思路：这里的计算只有加减乘除，但是乘除的优先级最高，所以我们可以优先计算乘除之后的结果，作为一个数据保存下来，
 *
 * <p>
 * 时间复杂度：O(m*n)
 */
class SolutionLT227 {
    public static void main(String[] args) {
        SolutionLT227 lt = new SolutionLT227();
        //System.out.println(lt.calculate("3+2*2"));  //7
      //  System.out.println(lt.calculate("3/2"));//1
        System.out.println(lt.calculate("3+5 / 2"));
        // " 3+5 / 2 "
    }

    public int calculate(String s) {
        Deque<Integer> list = new LinkedList<>();
        char preSign = '+';
        s = s.trim();
        int n = s.length();
        int num = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            //统计数字
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            if (ch!=' ' && Character.isDigit(ch) || i == n - 1) {//已经是最后一个数字了，或者是其他符号
                switch (preSign) {
                    case '+':
                        list.push(num);
                        break;
                    case '-':
                        list.push(0 - num);
                        break;
                    case '*':
                        list.push(list.pop() * num);
                        break;
                    case '/':
                        list.push(list.pop() / num);
                        break;
                }
                preSign = ch;
                num = 0;
            }
        }
        int ans = 0;
        while (!list.isEmpty()) {
            ans += list.pop();
        }
        return ans;
    }
}