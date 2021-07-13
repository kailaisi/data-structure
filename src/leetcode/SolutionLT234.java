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
 * 解题思路：判断是否回文，其实相当于从中间位置开始，然后将前后的进行折叠即可。那么是否可以进行快慢指针，将满指针的数据存入到栈中。
 * * 时间复杂度：O（N）：
 * * 空间复杂度：O（1）
 */
class SolutionLT234 {
    public static void main(String[] args) {
        SolutionLT234 lt = new SolutionLT234();
        System.out.println(lt.isPalindrome(new ListNode(1)));//false
        System.out.println(lt.isPalindrome(new ListNode(1, new ListNode(2))));//false
        //    System.out.println(lt.isPalindrome(new ListNode(1, new ListNode(2,new ListNode(3)))));//false
        //   System.out.println(lt.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));//false
        System.out.println(lt.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1)))))));//false
    }

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        Stack<ListNode> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            stack.push(slow);
            slow = slow.next;
        }
        while (slow != null) {
            if (stack.isEmpty() || stack.pop().val != slow.val) {
                return false;
            }
            slow = slow.next;
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