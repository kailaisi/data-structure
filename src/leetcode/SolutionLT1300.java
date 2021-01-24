package leetcode;

import java.util.Arrays;

/**
 * 1300. 转变数组后最接近目标值的数组和
 * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * 请注意，答案不一定是 arr 中的数字。
 *
 * 示例 1：
 * 输入：arr = [4,9,3], target = 10
 * 输出：3
 * 解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
 * 示例 2：
 *
 * 输入：arr = [2,3,5], target = 10
 * 输出：5
 * 示例 3：
 *
 * 输入：arr = [60864,25176,27249,21296,20204], target = 56803
 * 输出：11361
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i], target <= 10^5
 * 解题思路：有设置所有大于value的都变为value。所以这里的value其范围应该是0->数组的最大值。因为比最大值还大的话，其和也不会改变了。
 * 可以通过0>max进行遍历。然后计算其和跟target的差距，找到最小的那个值。
 * 当我们确定index之后的数据变化的时候，我们可以计算其和。
 * 这里最好对数组进行排序，那么之前的数据可以通过数组记录对应的和，然后计算后面的和就是a[0]....+a[index]+(n-index)*x;
 * 这里我们使用了迭代+java自带的二分搜索功能
 *
 */
class SolutionLT1300 extends GuessGame {

    public static void main(String[] args) {
        SolutionLT1300 lt = new SolutionLT1300();
        System.out.println(lt.findBestValue(new int[]{4,9,3},9));
        System.out.println(lt.findBestValue(new int[]{2,3,5},10));
        System.out.println(lt.findBestValue(new int[]{60864,25176,27249,21296,20204},56803));
    }

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int length = arr.length;
        int[] ints = new int[length+1];
        for (int i=1;i<length;i++){
            ints[i]=ints[i-1]+arr[i-1];
        }
        int r=arr[length-1];
        int res=0;
        int diff=target;
        for (int i=1;i<=r;i++){
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
}
