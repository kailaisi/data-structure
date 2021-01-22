package leetcode;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 228. 汇总区间
 * 给定一个无重复元素的有序整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 * <p>
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 示例 3：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：["-1"]
 * 示例 5：
 * 输入：nums = [0]
 * 输出：["0"]
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 * 通过次数42,205提交次数71,998
 * <p>
 * 解题思路：按照数组的顺序逐个进行比较。我们需要记录每个启动顺序区间的start位置，对于end位置，则可以通过i和i-1位置的数字进行比较。如果不连续，则start->i-1位置是一个区间。
 *                遍历完成以后，那么需要进行最后一组数据的添加。
 *                这里，如果start==i-1和二者不相等时，输出的格式是不一样的
 * 时间复杂度：O(n)，一次遍历循环
 * 空间复杂度：O(1)，没有任何新空间的申请
 */
class SolutionLT228 {

    public static void main(String[] args) {
        SolutionLT228 lt = new SolutionLT228();
        System.out.println(lt.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));//["0->2","4->5","7"]
        System.out.println(lt.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));//["0","2->4","6","8->9"]
        System.out.println(lt.summaryRanges(new int[]{-1}));//["0","2->4","6","8->9"]
    }

    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return list;
        }
        int start = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (i - 1 == start) {
                    list.add(nums[start] + "");
                } else {
                    list.add(nums[start] + "->" + nums[i - 1]);
                }
                start = i;
            }
        }
        //最后一组数据处理
        if (start == length - 1) {
            list.add(nums[start] + "");
        } else {
            list.add(nums[start] + "->" + nums[length - 1]);
        }
        return list;
    }

}
