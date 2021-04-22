package leetcode;


/**
 * 135. 分发糖果
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1：
 * 输入：[1,0,2]
 * 输出：5
 * 解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 * 输入：[1,2,2]
 * 输出：4
 * 解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * 解题思路：为了满足要求，对于一个点的数据，我们必须要满足左右两个条件，
 * 左侧：当ratings[i-]<ratings[i]的时候。那么i的苹果要比i-1多，贪心理念，我们只多给一个。
 * 右侧：当ratings[i+1]<ratings[i]的时候。那么i的苹果要比i+1多，贪心理念，我们只多给一个。
 * 我们可以先从一测开始。先满足左侧的条件，只要满足ratings[i-]<ratings[i]。苹果+1，不满足的话，就直接置为1。
 * 然后我们再从右侧遍历，
 * 以【1，0，2】为例。  第一遍结果是：1，1，2。  第二遍的时候，a[0]>a[1]，所以要0位置的比1位置的数据+1。而且从正面结果是1，这时候要取最大值
 * 时间复杂度：O（N）： 最多遍历2N
 * 空间复杂度：O（1）
 */
class SolutionLT135 {
    public static void main(String[] args) {
        SolutionLT135 lt = new SolutionLT135();
        System.out.println(lt.candy(new int[]{1,0,2}));//5
        System.out.println(lt.candy(new int[]{1,2,2}));//4
    }

    public int candy(int[] ratings) {
        int length = ratings.length;
        if (length < 2) {
            return length;
        }
        int[] res = new int[length];
        res[0] = 1;
        //先遍历确定左边的效果
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = 1;
            }
        }
        //反面遍历
        for (int i = length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                int r = res[i + 1] + 1;
                res[i] = Math.max(res[i], r);
            }
        }
        //最终结果
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += res[i];
        }
        return result;
    }
}
