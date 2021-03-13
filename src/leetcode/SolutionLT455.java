package leetcode;

import java.util.Arrays;

/**
 * 455. 分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 示例 1:
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 * 提示：
 * 1 <= g.length <= 3 * 104
 * 0 <= s.length <= 3 * 104
 * 1 <= g[i], s[j] <= 231 - 1
 * 解题思路：贪心算法。为了能够让尽量多的小孩得到满足，我们肯定是将能够满足当前小朋友的最小能量值给他。
 * 为了不造成浪费，我们肯定是将能量大的给胃口大的小朋友，如果给了胃口小的小朋友，那么可能会造成胃口大的小朋友得不到能量。这是一个局部最优解
 * 我们可以先将能量和对应需要的能量进行排序。然后依次便利，将最小的满足当前小朋友的能量给他，然后再找能够满足下一个小朋友的能量。
 * 时间复杂度：O（mlogm+nlogn）        对两个数组进行排序的时间复杂度为：O（mlogm+nlogn）,排序之后的遍历时间复杂度为：O（m+n）,所以综合的时间复杂度是：O（mlogm+nlogn）
 * 空间复杂度：O（mlogm+nlogn）        对数组排序所占用的空间复杂度是：O（mlogm+nlogn）
 */
class SolutionLT455 {
    public static void main(String[] args) {
        SolutionLT455 lt = new SolutionLT455();
        System.out.println(lt.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));//1
        System.out.println(lt.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));//2
    }

    //g是胃口值，s是能量块
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int len1 = g.length;
        int len2 = s.length;
        int i = 0;
        int j = 0;
        for (; i < len1 && j < len2; ) {
            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
