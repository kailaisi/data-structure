package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 * 解题技巧：巧妙的利用1 ≤ a[i] ≤ n ( n = 数组大小 ) 这个条件
 * 这个说明我们任何的a[i]的值-1在数组中都能找到对应的位置信息。所以我们可以将这个位置的变为负数。
 */
class SolutionLT448 {
    public static void main(String[] args) {
        SolutionLT448 lt167 = new SolutionLT448();
        lt167.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }


    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;//index调整为0...n-1
            if(nums[index]>0){
                nums[index]=0-nums[index];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<nums.length+1;i++){//遍历1到N
            if(nums[i-1]>0){
                list.add(i);
            }
        }
        return list;
    }
}
