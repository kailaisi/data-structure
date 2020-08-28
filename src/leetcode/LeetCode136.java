package leetcode;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 解题思路：
 * 根据异或的性质
 * a^0=a
 * a^a=0
 * a^b^a=a^a^b=0^b=b
 * 如果数组存在相同的数据，那么通过异或处理就变成了0.而最终单个的数据就会保存下来
 */
class LeetCode136 {

    public int singleNumber(int[] nums) {
        int single=0;
        for (int num : nums) {
            single^=num;
        }
        return single;
    }
}
