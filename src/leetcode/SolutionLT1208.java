package leetcode;

import java.util.HashSet;

/**
 * 1208. 尽可能使字符串相等
 * 给你两个长度相同的字符串，s 和 t。
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 * 示例 1：
 * 输入：s = "abcd", t = "bcdf", maxCost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 * 示例 2：
 * 输入：s = "abcd", t = "cdef", maxCost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 * 示例 3：
 * 输入：s = "abcd", t = "acde", maxCost = 0
 * 输出：1
 * 解释：a -> a, cost = 0，字符串未发生变化，所以最大长度为 1。
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 10^5
 * 0 <= maxCost <= 10^6
 * s 和 t 都只含小写英文字母。
 * 解题思路：典型的滑动窗口案例，而且没有固定大小的窗口，可以使用左右两个指针来处理。
 *         窗口的条件是差值的和大于我们给定的值
 * 空间复杂度：O(n)，需要有个set来保存数据
 * 时间复杂度：O(n)，需要一次遍历
 */
class SolutionLT1208 extends GuessGame {

    public static void main(String[] args) {
        SolutionLT1208 lt = new SolutionLT1208();
        System.out.println(lt.equalSubstring("abcd", "bcdf", 3));//3
        System.out.println(lt.equalSubstring("abcd", "cdef", 3));//1
        System.out.println(lt.equalSubstring("abcd", "acde", 0));//1
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0;
        int end = 0;
        int length = s.length();
        int res = 0;
        int sum = 0;
        while (end < length) {
            sum += Math.abs(s.charAt(end) - t.charAt(end));
            end++;
            //构造窗口
            while (sum > maxCost) {
                sum -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            //记录当前窗口的大小
            res = Math.max(res, end - start);
        }
        return res;
    }
}