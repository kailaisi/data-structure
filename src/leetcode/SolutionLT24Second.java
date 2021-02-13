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
 * 思路：递归大部分可以使用迭代方式去解决的。这里我们创建一个虚拟的header。然后每次交换下一个节点以及下下个节点指针，然后将header指向末尾，再次遍历进行转换。
 * 时间复杂度：O(n)。需要对每个节点都进行指针的更新操作
 *  *  空间复杂度：O(1)。
 */
class SolutionLT24Second {

    public static void main(String[] args) {
        SolutionLT24Second lt = new SolutionLT24Second();
        ListNode head=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4))));
        ListNode listNode = lt.swapPairs(head);
        head=new ListNode(1);
        listNode = lt.swapPairs(head);
        head=null;
        listNode = lt.swapPairs(head);
        System.out.println(listNode.val);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode temp=dummyHead;
        while (temp.next!=null && temp.next.next!=null){
            ListNode node1=temp.next;
            ListNode node2 = temp.next.next;
            temp.next=node2;
            node1.next=node2.next;
            node2.next=node1;
            temp=node1;
        }
        return dummyHead.next;
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