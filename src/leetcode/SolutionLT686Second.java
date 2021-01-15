package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 *
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 *
 * 例 1：
 *
 * 输入: m = 3, n = 3, k = 5
 * 输出: 3
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 *
 * 第5小的数字是 3 (1, 2, 2, 3, 3).
 * 例 2：
 *
 * 输入: m = 2, n = 3, k = 6
 * 输出: 6
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 *
 * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
 *  解题思路：维护一个PriorityQueue。保证其最大数量为k，超过k的话就抛出去一个。
 */
class SolutionLT686Second {

    public static void main(String[] args) {
        SolutionLT686Second lt = new SolutionLT686Second();
        System.out.println(lt.findKthNumber(3,3,5));
        System.out.println(lt.findKthNumber(2,3,6));
        System.out.println(lt.findKthNumber(3,1,2));
    }

    public int findKthNumber(int m, int n, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<m;i++){
            for (int j = 0; j < n; j++) {
                queue.add((i+1)*(j+1));
                if (queue.size()>k){
                    queue.poll();
                }
            }
        }
        return queue.peek();
    }
}