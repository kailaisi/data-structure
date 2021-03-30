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
 * 解题思路：典型的贪心算法。不考虑N的限制大的话，最大的单调递增数据肯定都是9
 * 加入了N的限制之后，肯定是尽量保持前面的数据。如果是1232。那么就睡1229。是将d[i]>d[i+1]中，将i位置变为d[i]-1,然后剩下的变为9
 * 那么肯定会有一种情况：133333332。变为啥？1299999999。因为变完之后，是133333329。仍然存在d[i]>d[i+1]的情况
 * 时间复杂度：O（N^2）：
 * 空间复杂度：O（1）
 */
class SolutionLT738 {
    public static void main(String[] args) {
        SolutionLT738 lt = new SolutionLT738();
        System.out.println(lt.monotoneIncreasingDigits(10));//3
        System.out.println(lt.monotoneIncreasingDigits(1234));//3
        System.out.println(lt.monotoneIncreasingDigits(332));//3
    }

    public int monotoneIncreasingDigits(int N) {
        char[] chars = (N + "").toCharArray();
        int max = -1;
        int idx = -1;
        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i] > max) {//找到符合顺序的坐标
                max = chars[i];
                idx = i;
            }
            if (chars[i] > chars[i + 1]) {//
                chars[idx] -= 1;//idx位置-1
                for (int j = idx + 1; j < chars.length; j++) {//后面的全部变为9
                    chars[j] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
