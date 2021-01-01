package leetcode;

import java.util.List;

/**
 * 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
 * <p>
 * 给定一个数字 n，找出可形成完整阶梯行的总行数。
 * <p>
 * n 是一个非负整数，并且在32位有符号整型的范围内。
 * <p>
 * 示例 1:
 * <p>
 * n = 5
 * <p>
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * 因为第三行不完整，所以返回2.
 * 示例 2:
 * <p>
 * n = 8
 * <p>
 * 硬币可排列成以下几行:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * 因为第四行不完整，所以返回3.
 * 题解：使用二分法来查找对应的解。
 * 使用二分法标准模板，由于mid计算以后，不能将mid的值抛出在外，所以进行赋值的时候，使用的是start=mid 以及end=mid 。
 * 而且需要注意这里进行计算的时候，要防止溢出 ，所以使用了double类型
 */
class SolutionLT441 {
    public static void main(String[] args) {
        SolutionLT441 lt = new SolutionLT441();
        System.out.println(lt.arrangeCoins(5));
        System.out.println(lt.arrangeCoins(8));
        System.out.println(lt.arrangeCoins(0));
        System.out.println(lt.arrangeCoins(1));
        System.out.println(lt.arrangeCoins(200));
    }

    public int arrangeCoins(int n) {
        int start = 0;
        int end = n;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            double res = res(mid);
            if (res == n) {
                return mid;
            }
            if (res < n) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (res(end) == n) {
            return end;
        } else {
            return start;
        }
    }

    private double res(int mid) {
        //这里强制转化为double类型，防止计算的时候溢出
        return ((double) mid * mid + mid) / 2;
    }
}