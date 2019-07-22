package leetcode

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/22 14:52
 */
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution83 {
    inner class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun deleteDuplicates(head: ListNode?): ListNode? {
        if(head==null){
            return null
        }
        var pre=head!!
        while(pre.next!=null){
            if(pre.next!!.`val`==pre.`val`){
                pre.next=pre.next!!.next
            }else{
                pre=pre.next!!
            }
        }
        return head
    }
}