package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * 找到所有出现两次的元素。
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * 示例：
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [2,3]
 * 解题思路：条件1 ≤ a[i] ≤ n （n为数组长度）
 * 这个表明，我们的数组的数据范围已经固定了
 * a[i]=k，那么我们将a[k-1]的数据变为-a[k-1]。当再次有某个j位置需要修改k-1位置数据，则表明数字是重复的。
 */
class SolutionLT442 {
    public static void main(String[] args) {
        int[] ints = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = new SolutionLT442().findDuplicates(ints);
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if (nums[Math.abs(nums[i])-1]<0){
                list.add(Math.abs(nums[i]));
            }else{
                nums[Math.abs(nums[i])-1]*=-1;
            }
        }
        return list;
    }
}