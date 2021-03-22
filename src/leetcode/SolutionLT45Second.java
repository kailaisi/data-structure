package leetcode;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 解题思路：贪心算法。在第一个里面的时间复杂度比较高，我们有办法正向去解决问题么？
 *                  比如从第一个位置开始，我可以跳转到1，2。那么1和2下标哪一个跳的最远，我们就选哪个，毕竟都是两次跳转。
 *        思路：1。记录当前位置，记录当前位置为起点的下一个位置的范围，然后从当前位置到下一个位置范围内的最大跳的距离
 *
 * 时间复杂度：O（N^2）：
 * 空间复杂度：O（1）
 */
class SolutionLT45Second {
    public static void main(String[] args) {
        SolutionLT45Second lt = new SolutionLT45Second();
        System.out.println(lt.jump(new int[]{2,3,1,1,4}));//2
    }

    public int jump(int[] nums) {
        int position=nums.length-1;
        int count=0;
        for (int i=0;i<nums.length-1;){
            int max=0;
            for (int j = 1; j <nums[i] ; j++) {
                max=Math.max(nums[j]+i,max);
            }
            count+=2;
            i=max;
        }
        return count;
    }
}
