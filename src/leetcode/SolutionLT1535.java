package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。
 * <p>
 * 每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。
 * <p>
 * 返回赢得比赛的整数。
 * <p>
 * 题目数据 保证 游戏存在赢家。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,1,3,5,4,6,7], k = 2
 * 输出：5
 * 解释：一起看一下本场游戏每回合的情况：
 * <p>
 * 因此将进行 4 回合比赛，其中 5 是赢家，因为它连胜 2 回合。
 * 示例 2：
 * <p>
 * 输入：arr = [3,2,1], k = 10
 * 输出：3
 * 解释：3 将会在前 10 个回合中连续获胜。
 * 示例 3：
 * <p>
 * 输入：arr = [1,9,8,2,3,7,6,4,5], k = 7
 * 输出：9
 * 示例 4：
 * <p>
 * 输入：arr = [1,11,22,33,44,55,66,77,88,99], k = 1000000000
 * 输出：99
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^6
 * arr 所含的整数 各不相同 。
 * 1 <= k <= 10^9
 * 解题思路：
 *    这里每次比较，都会把小的数字放到最后，整个一轮下来，其实就是最大的数据在最前面，这时候，无论怎么比较都是那个最大数字了。所以没有必要进行k次，只要进行min(k，arr.length)即可。
 *    而且我们没必要将数字向后移动，只需要记录第i次比较之后最大值就好。
 *   记录方案：如果k==1，那么直接第一次比较就可以返回
 *   否则记录count，然后如果每次比较之后，生出的value和上次胜出的value的值相等，那么count++，否则count恢复为1。
 *
 */
class SolutionLT1535 {

    public static void main(String[] args) {
        SolutionLT1535 lt = new SolutionLT1535();
        System.out.println(lt.getWinner(new int[]{2,1,3,5,4,6,7},2));
        System.out.println(lt.getWinner(new int[]{3,2,1},10));
        System.out.println(lt.getWinner(new int[]{1,9,8,2,3,7,6,4,5},7));
        System.out.println(lt.getWinner(new int[]{1,11,22,33,44,55,66,77,88,99},1000000));

    }


    public int getWinner(int[] arr, int k) {
        int pre=Math.max(arr[0],arr[1]);//如果只要胜利1次，那么就直接返回即可。
        if(k==1){
            return pre;
        }
        int count=1;
        for (int i=2;i<arr.length;i++){
            int newMax=Math.max(pre,arr[i]);//每次比较都拿pre和i位置进行比较，然后获取到最大的那个数据
            if (pre==newMax){//如果最大值和之前的最大值相等，说明胜利了。
                count++;
            }else{//失败了，那么就记录新的最大值。
                count=1;
                pre=newMax;
            }
            if(count==k){//如果当前比较的次数和k想当，那么说明胜利了K次了。直接返回
                return pre;
            }
        }
        //如果那么多次比较，还没到k次，那么直接返回那个最大值即可。
        return pre;
    }
}