package leetcode;

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
 * 题解：直接使用计算的公式
 * k=sqre(2n+0.25)-0.5   ->为了防止2*n+0.25超出sqrt的范围，所以调整为sqrt(2)*sqrt(n+0.125)-0.5
 **/
class SolutionLT441Second {
    public static void main(String[] args) {
        SolutionLT441Second lt = new SolutionLT441Second();
        System.out.println(lt.arrangeCoins(5));
        System.out.println(lt.arrangeCoins(8));
        System.out.println(lt.arrangeCoins(0));
        System.out.println(lt.arrangeCoins(1));
        System.out.println(lt.arrangeCoins(200));
    }

    public int arrangeCoins(int n) {
        return  (int) (Math.sqrt(2)*(Math.sqrt(n+0.125))-0.5);
    }

    private double res(int mid) {
        //这里强制转化为double类型，防止计算的时候溢出
        return ((double) mid * mid + mid) / 2;
    }
}