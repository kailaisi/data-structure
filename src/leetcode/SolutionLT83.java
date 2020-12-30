package leetcode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * 题解：通过判断，如果两个节点相等，则将下一个指针指向下一个的下一个
 */
class SolutionLT83 {
    public static void main(String[] args) {
        SolutionLT83 lt = new SolutionLT83();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        //  n3.next = n4;
        n4.next = n5;
        ListNode node = lt.deleteDuplicates(n1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode h = head;
        while (h.next != null) {
            if (h.next.val == h.val) {
                h.next = h.next.next;
            } else {
                h = h.next;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

