package leetcode;

import java.util.TreeSet;

/**
 * 描述：
 * <p/>作者：wu
 * <br/>创建时间：2019/7/22 15:59
 */
public class Solution141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        // TODO: 2019/7/22 未实现功能
        TreeSet<Integer> set = new TreeSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur.val)) {
                return true;
            }
            set.add(cur.val);
            cur = cur.next;
        }
        return false;
    }
}
