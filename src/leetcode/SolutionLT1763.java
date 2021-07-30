package leetcode;

/**
 * 1763. 最长的美好子字符串
 * 当一个字符串 s 包含的每一种字母的大写和小写形式 同时 出现在 s 中，就称这个字符串 s 是 美好 字符串。比方说，"abABB" 是美好字符串，因为 'A' 和 'a' 同时出现了，且 'B' 和 'b' 也同时出现了。然而，"abA" 不是美好字符串因为 'b' 出现了，而 'B' 没有出现。
 * 给你一个字符串 s ，请你返回 s 最长的 美好子字符串 。如果有多个答案，请你返回 最早 出现的一个。如果不存在美好子字符串，请你返回一个空字符串。
 * 示例 1：
 * 输入：s = "YazaAay"
 * 输出："aAa"
 * 解释："aAa" 是一个美好字符串，因为这个子串中仅含一种字母，其小写形式 'a' 和大写形式 'A' 也同时出现了。
 * "aAa" 是最长的美好子字符串。
 * 示例 2：
 * 输入：s = "Bb"
 * 输出："Bb"
 * 解释："Bb" 是美好字符串，因为 'B' 和 'b' 都出现了。整个字符串也是原字符串的子字符串。
 * 示例 3：
 * 输入：s = "c"
 * 输出：""
 * 解释：没有美好子字符串。
 * 示例 4：
 * 输入：s = "dDzeE"
 * 输出："dD"
 * 解释："dD" 和 "eE" 都是最长美好子字符串。
 * 由于有多个美好子字符串，返回 "dD" ，因为它出现得最早。
 * 提示：
 * 1 <= s.length <= 100
 * s 只包含大写和小写英文字母。
 * 解题思路：这种k个数据之间的一般就按照滑动窗口来处理。
 * 现有set，然后没到k大小的时候，直接添加，到达k的时候，先移除一个，再添加1个
 * 空间复杂度：O(n)，需要有个set来保存数据
 * 时间复杂度：O(n)，需要一次遍历
 */
class SolutionLT1763 extends GuessGame {

    public static void main(String[] args) {
        SolutionLT1763 lt = new SolutionLT1763();
        System.out.println(lt.longestNiceSubstring("YazaAay"));//aAa
        System.out.println(lt.longestNiceSubstring("Bb"));//Bb
        System.out.println(lt.longestNiceSubstring("c"));//""
        System.out.println(lt.longestNiceSubstring("dDzeE"));//dD
    }

    public String longestNiceSubstring(String s) {
        // TODO: 2021/7/30
        return s;
    }
}