package leetcode;

/**
 * 1784. 检查二进制字符串字段
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * 如果 s 最多包含 一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：s = "1001"
 * 输出：false
 * 解释：字符串中的 1 没有形成一个连续字段。
 * <p>
 * 示例 2：
 * 输入：s = "110"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length <= 100
 * s[i]​​​​ 为 '0' 或 '1'
 * s[0] 为 '1'
 * <p>
 * 解题思路：贪心算法。 去掉前缀0，然后后面的1，后边如果有0之后，还有1，这返回false
 * 时间复杂度：O(n)  只进行一次遍历
 * 空间复杂度：O(1)
 */
class SolutionLT1478 {
    public static void main(String[] args) {
        SolutionLT1478 lt = new SolutionLT1478();

        System.out.println(lt.checkOnesSegment("1001"));//false
        System.out.println(lt.checkOnesSegment("110"));//true
    }

    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}