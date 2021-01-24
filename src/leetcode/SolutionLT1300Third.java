package leetcode;

import java.util.Arrays;

/**
 * 1300. 转变数组后最接近目标值的数组和
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * 请注意，答案不一定是 arr 中的数字。
 * <p>
 * 示例 1：
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 * 示例 2：
 * <p>
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 * 解题思路：在方法2的基础上，还有优化的地方，从而可以减少我们进行数据查找过程。
 * 比如：1. 如果数组的和比target小，那么直接返回数组最大值就可以了
 *       2.目标值应该是比target/len大的值。因为比他小了之后，不可能会导致其和更接近target。
 *
 */
class SolutionLT1300Third extends GuessGame {

    public static void main(String[] args) {
        SolutionLT1300Third lt = new SolutionLT1300Third();
        System.out.println(lt.findBestValue(new int[]{4, 9, 3}, 9));
        System.out.println(lt.findBestValue(new int[]{2, 3, 5}, 10));
        System.out.println(lt.findBestValue(new int[]{60864, 25176, 27249, 21296, 20204}, 56803));
    }

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int length = arr.length;
        int[] ints = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            ints[i] = ints[i - 1] + arr[i - 1];
        }
        if(target>=ints[length]){
            return arr[length-1];
        }
        int r=arr[length-1];
        int res=0;
        int diff=target;
        for (int i=target/length;i<=r;i++){
            int index=Arrays.binarySearch(arr,i);
            if(index<0){//数组内不存在该数据,那么返回的就是插入该数据的位置。
                index=-index-1;
            }
            int cur=ints[index]+(length-index)*i;
            if (Math.abs(cur-target)<diff){//比较当前的差值，是否比之前记录的小
                res=i;
                diff=Math.abs(cur-target);
            }
        }
        return res;
    }

    private int sum(int[] arr, int res) {
        int ret = 0;
        for (int num : arr) {
            ret += Math.min(num, res);
        }
        return ret;
    }
}