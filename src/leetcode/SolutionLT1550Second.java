package leetcode;

/**
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：arr = [2,6,4,1]
 * 输出：false
 * 解释：不存在连续三个元素都是奇数的情况。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,34,3,4,5,7,23,12]
 * 输出：true
 * 解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
 *  
 * 提示：
 * <p>
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 解题思路：遍历循环，每次都是判断是否是奇数，如果不是，则i++，如果是，则向后三位去判断。如果i+2是偶数，则没有必要再去判断i+1和i+2了
 * 时间复杂度：O(n),
 * 空间复杂度：O(1)
 */
class SolutionLT1550Second {

    public static void main(String[] args) {
        SolutionLT1550Second lt = new SolutionLT1550Second();
          System.out.println(lt.threeConsecutiveOdds(new int[]{2,6,4,1}));
          System.out.println(lt.threeConsecutiveOdds(new int[]{1,2,34,3,4,5,7,23,12}));
        System.out.println(lt.threeConsecutiveOdds(new int[]{1, 1, 1}));
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        int length = arr.length;
        if (length < 3) {
            return false;
        }
        int index = 0;
        while (index + 2 < length) {
            if (arr[index] % 2 == 1 && arr[index + 1] % 2 == 1 && arr[index + 2] % 2 == 1) {
                return true;
            }
            if (arr[index + 2] % 2 == 0) {
                index += 2;
            } else if (arr[index + 1] % 2 == 0) {
                index += 1;
            } else {
                index++;
            }
        }
        return false;
    }
}
