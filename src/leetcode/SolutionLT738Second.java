package leetcode;


/**
 * 738. 单调递增的数字
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * 示例 1:
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 * <p>
 * 解题思路：数学法
 *  由于结果要求各位数字单调递增，那么这些数字必然形如 a0a1a2……an (1 <= a0 <= a1 <= a2 <= …… <= an <= 9)
 *
 * 显然有：
 *
 *
 *        --------------
 *        a0 a1 a2 …… an      (1 <= a0 <= a1 <= a2 <= …… <= an <= 9)
 *
 *  =     a0 *  111……1    + (a1 - a0) *   111……1
 *             \-n个1-/                 \-(n-1)个1-/
 *
 *     + (a2 - a1) *   111……1    + ………… + (an - an-1) * 1
 *                   \-(n-2)个1-/
 *
 * 可见最终结果必然是若干个形如 11……11 的数字相加所得。
 *
 * 本题中，最大的n为10^9，所以，可以从111111111开始依次累加，如果继续累加将导致结果超过n，则去掉一个1继续循环。总累加次数不超过9次。
 *
 * 时间复杂度：O（N^2）：
 * 空间复杂度：O（1）
 */
class SolutionLT738Second {
    public static void main(String[] args) {
        SolutionLT738Second lt = new SolutionLT738Second();
        System.out.println(lt.monotoneIncreasingDigits(10));//3
        System.out.println(lt.monotoneIncreasingDigits(1234));//3
        System.out.println(lt.monotoneIncreasingDigits(332));//3
    }

    public int monotoneIncreasingDigits(int N) {
        int ones=111111111;
        int res=0;
        for (int i=0;i<9;i++){
            while (res+ones>N){
                ones/=10;
            }
            res+=ones;
        }
        return res;
    }
}
