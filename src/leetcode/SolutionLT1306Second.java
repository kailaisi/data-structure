package leetcode;

import datalearning.interf.Queue;
import datalearning.queue.LinkedListQueue;

import java.util.LinkedList;

/**
 * 1306. 跳跃游戏 III
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 * <p>
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 * <p>
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 2：
 * <p>
 * 输入：arr = [4,2,3,0,3,1,2], start = 0
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 0 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 3：
 * <p>
 * 输入：arr = [3,0,2,1,2], start = 2
 * 输出：false
 * 解释：无法到达值为 0 的下标 1 处。
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 * <p>
 * 解题思路：可以通过以start为节点开始，往左和往右去查找，然后看是否满足对应的节点位置的值为0。
 * 为了防止出现死循环的情况：比如说我从1位置跳到了3位置，然后又从3位置跳到1位置，我们可以用一个数组来记录当前位置之前是否遍历过，如果遍历过，则直接按照false处理
 * 从一个节点开始，我们需要往左往右去查找，第一种思路是通过迭代来处理，如果我们不使用迭代，而是使用while循环的话，需要记录左右两边需要遍历的位置，
 * 我们可以使用queue，每次左右两个节点放入到队列，然后不断的查看节点是否满足条件。直到queue为空为止.
 * 跳出迭代循环的条件：1.  超出数组范围   2：当前位置已经遍历过    3：当前位置的值为0
 * 时间复杂度：
 * 空间复杂度：
 */
class SolutionLT1306Second {
    public static void main(String[] args) {
        SolutionLT1306Second lt = new SolutionLT1306Second();
        System.out.println(lt.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));//true
        System.out.println(lt.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0));//true
        System.out.println(lt.canReach(new int[]{3, 0, 2, 1, 2}, 2));//false
    }

    public boolean canReach(int[] arr, int start) {
        int length = arr.length;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] sees = new boolean[length];
        while (!queue.isEmpty()) {//
            Integer integer = queue.removeFirst();
            int i = arr[integer];
            if (i == 0) {
                return true;
            } else {
                if (sees[integer]) {//当前节点已经遍历过了,不需要从处理

                } else {
                    if (integer - i >= 0) {
                        queue.add(integer - i);
                    }
                    if (integer + i < length) {
                        queue.add(integer + i);
                    }
                    sees[integer] = true;
                }
            }
        }
        return false;
    }

}