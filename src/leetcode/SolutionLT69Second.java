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
 * 题解：牛顿迭代法：这里求x²=C。相当于求f(x)=x²-C=0的零点。通过不断的做切线，然后移动来处理
 *
 */
class SolutionLT69Second {
    public static void main(String[] args) {
        SolutionLT69Second lt = new SolutionLT69Second();
        System.out.println(lt.mySqrt(1));
        System.out.println(lt.mySqrt(2));
        System.out.println(lt.mySqrt(3));
        System.out.println(lt.mySqrt(4));
        System.out.println(lt.mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        double C=x;
        double x0=C;
        while(true){
            double xi=0.5*(x0+C/x0);
            if (Math.abs(x0 - xi) < 1e-7){
                break;
            }
            x0=xi;
        }
        return (int) x0;
    }
}