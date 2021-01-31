package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2:
 * <p>
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * 解题思路：递归算法
 * 猛一看这个问题，有点无从下手的感觉。
 * 但是我们可以考虑将问题进行简化，比如说，如果就是2个数字的计算，我们应该怎么算？
 * 那么如果是3个，我们是否可以将考虑第一个和后面两个的计算以及前两个和后面一个数字的计算？
 * 以2-1-1为例。
 * 1-1可以组合 ，拆分为  2-(1-1)
 * 2-1可以组合，拆分为   (2-1)-1
 * 如果是4个数字呢？是否可以拆分为1和3，2和2，3和1个的组合呢？
 * 以2*3-4*5为例
 * 2和3-4*5两部分，这个里面的3-4*5又可以按照3个的时候进行一次拆分处理，拆分为3和4*5，以及3-4和5。
 * 2*3和4*5两部分，
 * 2*3-4和5两部分，
 * 递归的结束条件：只有一个数字，或者字符串为空
 * 时间复杂度：O(logn)
 * 空间复杂度：O(1)
 */
class SolutionLT241 {
    public static void main(String[] args) {
        SolutionLT241 lt = new SolutionLT241();
        System.out.println(lt.diffWaysToCompute("2-1-1"));//5
        System.out.println(lt.diffWaysToCompute("2*3-4*5"));//4
    }

    public List<Integer> diffWaysToCompute(String input) {
        int length = input.length();
        if (length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<>();
        //获取第一个数字的大小
        int index = 0;
        int num = 0;
        while (index < length && !isOperate(input.charAt(index))) {
            num = num * 10 + input.charAt(index) - '0';
            index++;
        }
        if (index == length) {
            result.add(num);
            return result;
        }
        for (int i = 0; i < length; i++) {
            //这里要将字符串进行拆分
            if (isOperate(input.charAt(i))) {
                List<Integer> result1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> result2 = diffWaysToCompute(input.substring(i + 1));
                for (Integer integer : result1) {
                    for (Integer integer1 : result2) {
                        char c = input.charAt(i);
                        result.add(operate(c, integer, integer1));
                    }
                }

            }
        }
        return result;
    }

    private Integer operate(char c, Integer integer, Integer integer1) {
        switch (c) {
            case '+':
                return integer + integer1;
            case '-':
                return integer - integer1;
            case '*':
                return integer * integer1;
        }
        return -1;
    }


    private boolean isOperate(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}