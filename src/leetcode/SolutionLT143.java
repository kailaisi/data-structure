package leetcode;

import java.util.Stack;

/**
 * 143. 重排链表
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 解题思路：这里的难点在于如何能够将链表末尾的数据能够和开始的部分进行交叉进行处理。而且末尾数据是依次往前。
 * 可以考虑将所有的链表数据放入到栈中，然后每次都弹出一个，然后和首部数据进行相连，直到发现二者重合（也就是链表和当前pop的数据一样了，就结束）
 * 时间复杂度：O(n)  需要进行一次遍历
 * 空间复杂度：O(1)  不需要额外的空间进行存储
 */
class SolutionLT143 {

    public static void main(String[] args) {
        SolutionLT143 lt = new SolutionLT143();
        lt.reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
        lt.reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
    }

    public void reorderList(ListNode head) {
        Stack<ListNode> listNodeStack = new Stack<>();
        ListNode root = head;
        ListNode list = head;
        while (list != null) {
            //保存到栈中
            listNodeStack.push(list);
            list = list.right;
        }
        while (head != null) {
            ListNode pop = listNodeStack.pop();
            // TODO: 2021/7/8  这里的暂停条件要处理
            if (pop != head && head.right != pop) {
                //改变指针指向
                ListNode temp = head.right;
                head.right = pop;
                pop.right = temp;
                //这里要指向pop的右侧
                head = temp;
            } else {
                head.right = null;
                head = head.right;
            }
        }
        System.out.println(root);
    }


    public static class ListNode {
        int val;
        ListNode right;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode right) {
            this.val = val;
            this.right = right;
        }
    }
}
