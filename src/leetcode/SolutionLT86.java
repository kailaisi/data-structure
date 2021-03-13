package leetcode;

/**
 * 86. 分隔链表
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * 提示：
 * 链表中节点的数目在范围 [0, 200] 内
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 * 解题思路：我们可以用两个链表来保存，然后等拆分完之后再合并两个列表
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class SolutionLT86 {
    public static void main(String[] args) {
        SolutionLT86 lt = new SolutionLT86();
        ListNode root = new ListNode(2);
        root.next = new ListNode(1);

        ListNode listNode = lt.partition(root, 2);


        root = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        root.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        lt.partition(root, 3);
        System.out.println(listNode);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode header1 = new ListNode(0);
        ListNode header2 = new ListNode(0);
        ListNode tail1 = header1;
        ListNode tail2 = header2;
        while (head != null) {
            if (head.val < x) {
                tail1.next = head;
                tail1 = tail1.next;
            } else {
                tail2.next = head;
                tail2 = tail2.next;
            }
            head = head.next;
        }
        //拼接两个字符串
        tail1.next = header2.next;
        //这个处理是防止，tail2指到的node节点，后面有其他节点，因为赋值的时候，是直接赋值，所以需要进行一下处理
        tail2.next = null;
        return header1.next;
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