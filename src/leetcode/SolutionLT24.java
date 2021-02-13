package leetcode;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
 * 思路：这里给定的链表是两两交换，当我们交换了某两个位置之后，后面的可以使用递归去交换。
 * 递归停止的条件是：当前或者下一个节点为null，然后交换两个位置数据，并将最后一个指针指向了后面的链表返回的表头数据
 *  时间复杂度：O(n)。需要对每个节点都进行指针的更新操作
 *  空间复杂度：O(n)。空间复杂度取决于递归调用的栈空间
 */
class SolutionLT24 {

    public static void main(String[] args) {
        SolutionLT24 lt = new SolutionLT24();
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode listNode = lt.swapPairs(head);
        head=new ListNode(1);
        listNode = lt.swapPairs(head);
        head=null;
        listNode = lt.swapPairs(head);
        System.out.println(listNode.val);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        head.next = swapPairs(head.next.next);
        temp.next = head;
        return temp;
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