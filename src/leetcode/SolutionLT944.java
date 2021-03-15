package leetcode;

/**
 * 944. 删列造序
 * 给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
 *
 * 这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：
 * abc
 * bce
 * cae
 * 你需要找出并删除 不是按字典序升序排列的 列。在上面的例子（下标从 0 开始）中，列 0（'a', 'b', 'c'）和列 2（'c', 'e', 'e'）都是按升序排列的，而列 1（'b', 'c', 'a'）不是，所以要删除列 1 。
 * 返回你需要删除的列数。
 *
 * 示例 1：
 * 输入：strs = ["cba","daf","ghi"]
 * 输出：1
 * 解释：网格示意如下：
 *   cba
 *   daf
 *   ghi
 * 列 0 和列 2 按升序排列，但列 1 不是，所以只需要删除列 1 。
 * 示例 2：
 *
 * 输入：strs = ["a","b"]
 * 输出：0
 * 解释：网格示意如下：
 *   a
 *   b
 * 只有列 0 这一列，且已经按升序排列，所以不用删除任何列。
 * 示例 3：
 *
 * 输入：strs = ["zyx","wvu","tsr"]
 * 输出：3
 * 解释：网格示意如下：
 *   zyx
 *   wvu
 *   tsr
 * 所有 3 列都是非升序排列的，所以都要删除。
 *
 *
 * 提示：
 *
 * n == strs.length
 * 1 <= n <= 100
 * 1 <= strs[i].length <= 1000
 * strs[i] 由小写英文字母组成
 * 解题思路：贪心算法，按列进行遍历，只要遇到不符合条件的，就计数+1
 * 时间复杂度：O（N）
 * 空间复杂度：O（1）
 */
class SolutionLT944 {
    public static void main(String[] args) {
        SolutionLT944 lt = new SolutionLT944();
        System.out.println( lt.minDeletionSize(new String[]{"cba","daf","ghi"}));//1
        System.out.println( lt.minDeletionSize(new String[]{"a","b"}));//0
        System.out.println( lt.minDeletionSize(new String[]{"zyx","wvu","tsr"}));//3
    }

    public int minDeletionSize(String[] strs) {
        int res=0;
        int length = strs[0].length();
        for (int i=0;i<length;i++){
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i)<strs[j-1].charAt(i)){
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
