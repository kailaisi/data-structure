package leetcode;

/**
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：arr = [2,6,4,1]
 * 输出：false
 * 解释：不存在连续三个元素都是奇数的情况。
 * 示例 2：
 *
 * 输入：arr = [1,2,34,3,4,5,7,23,12]
 * 输出：true
 * 解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
 *  
 * 提示：
 *
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 解题思路：遍历循环，每次都是判断是否是奇数，如果不是，则i++，如果是，则向后三位去判断
 * 时间复杂度：O(n),
 * 空间复杂度：O(1)
 */
class SolutionLT1550 {

    public static void main(String[] args) {
        SolutionLT1550 lt = new SolutionLT1550();
      //  System.out.println(lt.threeConsecutiveOdds(new int[]{2,6,4,1}));
      //  System.out.println(lt.threeConsecutiveOdds(new int[]{1,2,34,3,4,5,7,23,12}));
        System.out.println(lt.threeConsecutiveOdds(new int[]{1,1,1}));
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        int length = arr.length;
        if(length<3){
            return  false;
        }
        for(int i = 0; i<= length-3;i++){
            if(arr[i]%2==1 &&arr[i+1]%2==1 &&arr[i+2]%2==1){
                return true;
            }
        }
        return false;
    }
}
