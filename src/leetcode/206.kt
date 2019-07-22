package leetcode

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/22 15:39
 */
class Solution206 {
    inner class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
    fun reverseList(head: ListNode?): ListNode? {
        var dummy=ListNode(-1)
        var cur=head
        while(cur!=null){
            var listNode = ListNode(cur.`val`)
            listNode.next=dummy.next
            dummy.next=listNode
            cur=cur.next
        }
        return dummy.next
    }
}