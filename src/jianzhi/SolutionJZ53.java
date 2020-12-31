package jianzhi;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 * 限制：
 * 1 <= 数组长度 <= 10000
 * 解题思路：二分法去进行查询。这里我们查找到中间mid之后，不能使用mid+1，或者mid-1。否则会漏掉具体的情况。例如  7 9  如果我们mid是7，使用mi+1,就会丢掉我们的答案了。
 */
public class SolutionJZ53 {
    public static void main(String[] args) {
        SolutionJZ53 jz = new SolutionJZ53();
        System.out.println(jz.missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
        System.out.println(jz.missingNumber(new int[]{0, 1, 3}));
        System.out.println(jz.missingNumber(new int[]{1}));
        System.out.println(jz.missingNumber(new int[]{0}));
    }

    public int missingNumber(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if(nums[end]==end){
            return end+1;
        }
        while (start + 1 < end) {
            int mid = (end + start) >> 1;
            if (nums[mid] == mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == start) {
            return start + 1;
        }
        return start;
    }
}