package leetcode;

import java.util.*;

/**
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * 示例 1:
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2:
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 注意:
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 * 解题思路：遍历，每个位置都修改为左边的数组的和。
 * <p>
 * 然后再次迭代，计算对应的k间距的差值，求平均值
 */
public class SolutionLT697 {
    public static void main(String[] args) {
        SolutionLT697 lt = new SolutionLT697();
        int[] ints = {1,2,2,3,1,4,2};
        System.out.println(lt.findShortestSubArray(ints));
    }

    public int findShortestSubArray(int[] nums) {
        int length = nums.length;
        //计算每个数据的个数
        HashMap<Integer, Integer> map = new HashMap<>();
        //记录左侧的位置
        HashMap<Integer, Integer> left = new HashMap<>();
        //记录右侧的位置
        HashMap<Integer, Integer> right = new HashMap<>();

        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if(map.get(num)==null){
                left.put(num,i);
            }
            int newValue = map.getOrDefault(num, 0) + 1;
            map.put(num, newValue);
            right.put(num,i);
        }
        int count = Integer.MAX_VALUE;
        Integer max = Collections.max(map.values());
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getValue().equals(max)){
                count=Math.min(count,right.get(next.getKey())-left.get(next.getKey())+1);
            }
        }
        return count;
    }
}
