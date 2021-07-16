package leetcode;

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
 * 解题思路：判断是否回文，其实相当于从中间位置开始，然后将前后的进行折叠即可。
 * 那么是否可以进行快慢指针，将慢指针在遍历的过程中，进行指针的反转，这样，当指到中间位置的时候，直接向两侧遍历即可。
 * * 时间复杂度：O（N）：
 * * 空间复杂度：O（1）
 */
class SolutionLT234Second {
    public static void main(String[] args) {
        SolutionLT234Second lt = new SolutionLT234Second();
        System.out.println(lt.isPalindrome(new ListNode(1)));//true
        System.out.println(lt.isPalindrome(new ListNode(1, new ListNode(2))));//false
        System.out.println(lt.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3)))));//false
        System.out.println(lt.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));//true
        System.out.println(lt.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))))));//true
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            //快指针
            fast = fast.next.next;
            //反转，使得原来的slow指向之前的pre，而新的slow指向下一个
            //下一个
            ListNode tmp = slow.next;
            //指针反转
            slow.next = pre;
            //保存pre
            pre = slow;
            //指向下一个指针
            slow = tmp;
        }
        if (fast == null) {//slow是中间靠右的位置
            fast = slow;
            slow = pre;
        } else {//slow是正中间位置。
            fast = slow.next;
            slow = pre;
        }
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
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