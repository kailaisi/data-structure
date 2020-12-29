package leetcode;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 题解：二分查找法   时间复杂的  O(logn)  空间复杂度 ：O(1)
 * 此处二分法：
 * 1.如果mid是解，则直接返回。
 * 2.如果mid比解大，那么可以右侧缩小到mid-1。
 * 3.如果mid比解小，那么左侧应该缩小到mid+1。但是这时候其实mid可能是答案，因为mid+1之后可能就是比解大的答案了
 */
class SolutionLT69 {
    public static void main(String[] args) {
        SolutionLT69 lt = new SolutionLT69();
        System.out.println(lt.mySqrt(1));
        System.out.println(lt.mySqrt(2));
        System.out.println(lt.mySqrt(3));
        System.out.println(lt.mySqrt(4));
        System.out.println(lt.mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        int start = 0;
        int end = x;
        int mid;
        int ans=-1;
        while (start <= end) {
            mid = (start + end) / 2;
            if ((long)mid * mid < x) {
                ans=mid;
                start = mid+1;//记录乘积比N小的数字，小了可以+1后再比较
            } else if ((long)mid * mid > x) {
                end = mid-1;//大了，那么可以mid-1处理
            } else {
                return mid;
            }
        }
        return ans;
    }
}