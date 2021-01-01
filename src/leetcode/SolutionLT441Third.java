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
 * 题解：使用牛顿迭代法。这里其实是计算f(x)=x²+x-2n的零点值。
 * 对应的迭代公式推理方式是：
 * (2xi+1)(xi-xi-1)=xi²+xi-2n的方程
 **/
class SolutionLT441Third {
    public static void main(String[] args) {
        SolutionLT441Third lt = new SolutionLT441Third();
        System.out.println(lt.arrangeCoins(5));
        System.out.println(lt.arrangeCoins(8));
        System.out.println(lt.arrangeCoins(0));
        System.out.println(lt.arrangeCoins(1));
        System.out.println(lt.arrangeCoins(200));
    }

    public int arrangeCoins(int n) {
        double res=n;
        while (Math.abs(res*(res+1)/2-n)>0.01){//停止条件是算出来的结果和n的差值只有0.01即可。
            res=(res*res+n*2)/(res*2+1);//牛顿迭代的公式
        }
        return (int)res;
    }
}