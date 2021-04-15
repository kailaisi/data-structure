package leetcode;


/**
 * 402. 移掉K位数字
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * <p>
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * <p>
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * <p>
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * <p>
 * 解题思路：最后要保留一定的个数，如果从前面来计算，比较复杂，我们可以考虑从后面往前进行数字的获取。比如说第一个题目：num = "1432219", k = 3
 * 最后保留的个数是4位，我们从末尾开始：2219 ，然后往前，如果发发现比2小的，肯定就要丢弃2了   结果只发现了1，所以最后保留的是1219
 * 还有一种情况：比如说11432219，   找到最后最后4位，2219，当遇到第一个1的时候，我们需要将2变为1219，再遇到2时候，需要将1往后移动，变为
 * 1119。
 * 时间复杂度：O（N）：
 * 空间复杂度：O（1）
 */
class SolutionLT402 {
    public static void main(String[] args) {
        SolutionLT402 lt = new SolutionLT402();
        System.out.println(lt.removeKdigits("1432219", 3));//1219
        System.out.println(lt.removeKdigits("10200", 1));//200
        System.out.println(lt.removeKdigits("10", 2));//0
        System.out.println(lt.removeKdigits("12345", 2));//0
    }

    public String removeKdigits(String num, int k) {
        //反转，
        String reverse = new StringBuffer(num).reverse().toString();
        int length = num.length();
        k = length - k;
        if (k <= 0) {
            return "0";
        }
        char[] chars = reverse.substring(0, k).toCharArray();
        int lastIndex = 0;
        for (int i = 0; i < length; i++) {
            char c = reverse.charAt(i);
            if (i < k) {
                //先复制初始值
                chars[i] = c;
                if (chars[i] != chars[lastIndex]) {
                    lastIndex = i;
                }
            } else {
                if (c <= chars[k - 1]) {//这里需要处理了
                    //从k-i位置开始，往前移动,找到第一个比charAt[i]大的，替换掉
                    //54321   543   2  1
                    //9122  1
                   char temp=c;
                    for (int j = k - 1; j >= 0; j--) {
                        if (chars[j] >= temp) {
                            //将【j】保存到temp，然后替换当前j的数据为上一个temp数据
                            c=temp;
                            temp=chars[j];
                            chars[j] = c;
                        }else {
                            break;
                        }
                    }
                }//如果比最后一个大，则不需要处理
            }
        }
        StringBuffer buffer = new StringBuffer(new String(chars)).reverse();
        //去掉前导0,但是要保证，最后一个不能删除，因为不能返回""
        while (buffer.length() > 1 && buffer.charAt(0) == '0') {
            buffer.deleteCharAt(0);
        }

        return buffer.toString();
    }
}
