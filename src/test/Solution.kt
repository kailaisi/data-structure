package test

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var top = head
        while (head?.`val` == `val`) {
            val reNode = head
            top = top?.next
            reNode.next = null
        }
        if (head == null) {
            return head
        }
        var pre = head
        while (pre?.next != null) {
            if (pre.next?.`val` == `val`) {
                val reNode = pre.next
                pre.next = reNode?.next
                reNode?.next = null
            } else {
                pre = pre.next
            }
        }
        return head
    }
}

class Solution2 {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var dunny = ListNode(-1)
        dunny.next = head
        var pre = dunny
        while (pre.next != null) {
            if (pre.next!!.`val` == `val`) {
                pre.next = pre.next!!.next
            } else {
                pre = pre.next!!
            }
        }
        return dunny.next
    }
}

class Solution3 {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        if (head == null) {
            return null
        }
       var res = removeElements(head.next, `val`)
        return when (head.`val`) {
            `val` -> res
            else ->{
                head.next = res
                head
            }
        }
    }
}