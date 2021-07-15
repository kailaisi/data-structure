package leetcode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * 解题思路：暴力法    判断是否回文，其实相当于从中间位置开始，然后将前后的进行折叠即可。
 * 可以将链表的数据存入数组，然后从中间开始往前往后，逐一进行比较
 * * 时间复杂度：O（N）：需要一次遍历
 * * 空间复杂度：O（N）：需要用列表来保存
 */
class SolutionLT234 {
    public static void main(String[] args) {
        SolutionLT234 lt = new SolutionLT234();
        System.out.println(lt.isPalindrome(new ListNode(1)));//true
        System.out.println(lt.isPalindrome(new ListNode(1, new ListNode(2))));//false
        System.out.println(lt.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3)))));//false
        System.out.println(lt.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));//true
        System.out.println(lt.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))))));//true
    }

    public boolean isPalindrome(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        //个数是10   那么就比较position的到i=0-4    9-i
        //个数是9   那么就比较position的到i=0-3    9-i  0 1 2 3    5  6  7  8
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            if (list.get(i).val != list.get(size - i - 1).val) {
                return false;
            }
        }
        return true;
    }

    public static class ListNode {
        public int val;
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