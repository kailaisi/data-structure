package leetcode

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/22 15:03
 */

class MyLinkedList() {

    inner class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }


    /** Initialize your data structure here. */
    var dummy: ListNode = ListNode(-1)
    private var size = 0
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */

    fun get(index: Int): Int {
        if (index >= size || index < 0) {
            return -1
        }
        var curr = dummy.next
        for (i in 0 until index) {
            curr = curr?.next
        }
        return curr!!.`val`
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    fun addAtHead(`val`: Int) {
        addAtIndex(0, `val`)
    }

    /** Append a node of value val to the last element of the linked list. */
    fun addAtTail(`val`: Int) {
        addAtIndex(size, `val`)
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    fun addAtIndex(index: Int, `val`: Int) {
        if (index > size) {
            return
        }
        var pre = dummy
        for (i in 0 until index) {
            pre = pre.next!!
        }
        var node = ListNode(`val`)
        node.next = pre.next
        pre.next = node
        size++
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    fun deleteAtIndex(index: Int) {
        if (index >= size || index < 0) {
            return
        }
        var pre = dummy
        for (i in 0 until index) {
            pre = pre.next!!
        }
        var del = pre.next!!
        pre.next = del.next
        del.next = null
        size--
    }

    override fun toString(): String {
        var cur = dummy.next
        var builder = StringBuilder()
        builder.append("MyListLink:Top  ")
        while (cur != null) {
            builder.append("${cur.`val`}->")
            cur = cur.next
        }
        return builder.toString()
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * var obj = MyLinkedList()
 * var param_1 = obj.get(index)
 * obj.addAtHead(`val`)
 * obj.addAtTail(`val`)
 * obj.addAtIndex(index,`val`)
 * obj.deleteAtIndex(index)
 */
fun main() {
    val linkedList = MyLinkedList()
    linkedList.addAtIndex(-1,0)
    println(linkedList.get(0))
    linkedList.deleteAtIndex(-1)
}