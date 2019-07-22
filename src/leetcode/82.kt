package leetcode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution82 {
    class ListNode(var `val`: Int) {
        var next: leetcode.ListNode? = null
    }
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var i=head?.`val`
        var dumpy=head
        if(head!=null){
            head.next?.`val`==i
        }
        return null
    }
}

fun main() {

}
