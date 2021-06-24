package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 1019. 链表中的下一个更大节点
 * 给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 * 每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 * 示例 1：
 * <p>
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 * <p>
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * 示例 3：
 * <p>
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 * 提示：
 * <p>
 * 对于链表中的每个节点，1 <= node.val <= 10^9
 * 给定列表的长度在 [0, 10000] 范围内
 * 解题思路：单调栈方案。先将列表转化为数组，然后使用数组的方案建立单调栈
 * 空间复杂度：O(n)
 * 时间复杂度：O(n)
 */
class SolutionLT1019Second {
    public static void main(String[] args) {
        int[] ints = new SolutionLT1019Second().nextLargerNodes(new ListNode(2,new ListNode(1,new ListNode(5))));
        System.out.println(Arrays.toString(ints));
         ints = new SolutionLT1019Second().nextLargerNodes(new ListNode(2,new ListNode(7,new ListNode(4,new ListNode(3,new ListNode(5))))));
        System.out.println(Arrays.toString(ints));

    }

    public int[] nextLargerNodes(ListNode head) {
        //先转化为数组，因为不知道具体的大小，所以可以先保存到list
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int size = list.size();
        /*保存到int*/
        int[] ints = new int[size];
        for (int i = 0; i < size; i++) {
            ints[i]=list.get(i);
        }
        /*这里要保存位置信息*/
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            while(!stack.isEmpty() && ints[stack.peek()]<ints[i]){
                res[stack.pop()]=ints[i];
            }
            stack.push(i);
        }


        return res;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
        ListNode(int x,ListNode next){
            this.val=x;
            this.next=next;
        }
    }
}