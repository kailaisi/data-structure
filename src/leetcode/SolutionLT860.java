package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 860. 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * 示例 1：
 * 输入：[5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * 示例 2：
 * <p>
 * 输入：[5,5,10]
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：[10,10]
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：[5,5,10,10,20]
 * 输出：false
 * 解释：
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= bills.length <= 10000
 * bills[i] 不是 5 就是 10 或是 20
 * <p>
 * 解题思路：贪心算法。为了能够尽量的能够为后面的客户保证能够找零，对于每个顾客，我们都尽量使用20的，然后再使用10，最后再使用5元的。
 * 时间复杂度：O（mlogm+nlogn）        对两个数组进行排序的时间复杂度为：O（mlogm+nlogn）,排序之后的遍历时间复杂度为：O（m+n）,所以综合的时间复杂度是：O（mlogm+nlogn）
 * 空间复杂度：O（mlogm+nlogn）        对数组排序所占用的空间复杂度是：O（mlogm+nlogn）
 */
class SolutionLT860 {
    public static void main(String[] args) {
        SolutionLT860 lt = new SolutionLT860();
      //  System.out.println(lt.lemonadeChange(new int[]{5, 5, 5, 10, 20}));//true
        //System.out.println(lt.lemonadeChange(new int[]{5, 5, 10}));//true
        //System.out.println(lt.lemonadeChange(new int[]{10, 10}));//false
        System.out.println(lt.lemonadeChange(new int[]{5, 5, 10, 10, 20}));//false
    }

    //g是胃口值，s是能量块
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i = 0; i < bills.length; i++) {
            int mon = bills[i];
            if (mon == 5) {//5元直接收下
                five++;
            }
            if (mon == 10) {//10元需要找5元的
                ten++;
                if (five > 0) {
                    five--;
                } else {
                    return false;
                }
            } else if (mon == 20) {//20元需要找15
                if (ten > 0) {//有10元的
                    ten--;
                    if (five > 0) {
                        five--;
                    } else {
                        return false;
                    }
                } else {//没有10元的
                    if (five >= 3) {
                        five -= 3;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
