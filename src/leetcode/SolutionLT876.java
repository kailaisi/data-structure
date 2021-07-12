package leetcode;

import java.util.Arrays;

/**
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * 提示：
 * 给定链表的结点数介于 1 和 100 之间。
 * 解题思路：暴力法，可以先计数，然后再处理长度
 * * 时间复杂度：O（N）：
 * * 空间复杂度：O（1）
 */
class SolutionLT876 {
    public static void main(String[] args) {
        SolutionLT876 lt = new SolutionLT876();
        System.out.println(lt.middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))).val);//aba  3
        System.out.println(lt.middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))).val);//aba  3
        System.out.println(lt.middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))).val);//aba   4
    }

    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode root = head;
        //个数
        while (head != null) {
            count++;
            head = head.next;
        }
        //中间个数
        int num =(int) Math.ceil((count+1) / 2.0);
        //找到中间点
        while (num > 1) {
            root = root.next;
            num--;
        }
        return root;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}