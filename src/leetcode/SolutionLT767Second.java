package leetcode;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 767. 重构字符串
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 * <p>
 * 输入: S = "aaab"
 * 输出: ""
 * 注意:
 * <p>
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * 解题思路：典型的贪心算法。在进行重排序的过程中，如果某个数据出现的次数过多，那么就无法进行满足最终的结果。什么情况下算是超过了限制条件
 * 当超过一半的情况下，无论如何，都无法满足要求。所以我们需要统计每个数据出现的次数，然后找到出现次数最大的那个数据，如果大于一半就为false
 * 构建返回字符串：可以尝试将最多和次多的取出，依次放入，直到次多完成，再进行最多和次多的处理
 * 时间复杂度：O（N^2）：
 * 空间复杂度：O（1）
 */
class SolutionLT767Second {
    public static void main(String[] args) {
        SolutionLT767Second lt = new SolutionLT767Second();
        System.out.println(lt.reorganizeString("aab"));//aba
        System.out.println(lt.reorganizeString("aaab"));//""
    }


    public String reorganizeString(String S) {
        int length = S.length();
        if (length < 2) {
            return S;
        }
        int maxLength = 0;
        int[] ints = new int[26];
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            ints[c - 'a']++;
            maxLength = Math.max(ints[c - 'a'], maxLength);
        }
        if (maxLength > (length + 1) / 2) {//3个字母的情况下，是可以两个一样的。可以向上取整，也可以+1/2
            return "";
        }
        //队列，用于保存下一个要取出的数据
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                //按照在数组中出现的次数多少进行排序
                return ints[o2 - 'a'] - ints[o1 - 'a'];
            }
        });
    }
}
