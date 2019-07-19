package link

/**
 *描述：时间复杂度分析：
 *   增加、删除、查找：时间复杂度o(n)
 *<p/>作者：wu
 *<br/>创建时间：2019/7/18 9:42
 */
class LinkedList<E> {

    inner class Node(var e: E? = null, var next: Node? = null)

    private var dummyHead: Node? = Node(null, null)
    var size = 0
        private set

    fun isEmpty() = size == 0

    fun addFirst(e: E?) {
        dummyHead?.next = Node(e, dummyHead?.next)
        size++
    }

    fun add(index: Int, e: E?) {
        if (index > size || index < 0) {
            throw IllegalArgumentException("大兄弟，没那么多数据")
        }
        var pre = dummyHead
        for (i in 0 until index) {
            pre = pre?.next
        }
        pre?.next = Node(e, pre?.next)
        size++
    }

    fun addLast(e: E?) {
        add(size, e)
    }

    fun get(index: Int): E? {
        if (index < 0 || index >= size) {
            throw IllegalArgumentException("大兄弟，没那么多数据，超标了")
        }
        var current = dummyHead?.next
        for (i in 0..index) {
            current = current?.next
        }
        return current?.e
    }

    fun getLast() = get(size - 1)


    fun getFirst() = get(0)

    fun set(index: Int, e: E?) {
        if (index < 0 || index >= size) {
            throw IllegalArgumentException("大兄弟，没那么多数据，超标了")
        }
        var current = dummyHead?.next
        for (i in 0..index) {
            current = current?.next
        }
        current?.e = e
    }

    fun contains(e: E): Boolean {
        var current = dummyHead?.next
        while (current != null) {
            if (e == current.e) {
                return true
            }
            current = current.next
        }
        return false
    }

    fun remove(index: Int): E? {
        if (index < 0 || index >= size) {
            throw IllegalArgumentException("大兄弟，没那么多数据，超标了")
        }
        var current = dummyHead
        for (i in 0 until index) {
            current = current?.next
        }
        var remove = current?.next
        current?.next = remove?.next
        remove?.next = null
        size--
        return remove?.e
    }

    fun removeFirst(): E? {
        return remove(0)
    }

    fun removeLast(): E? {
        return remove(size - 1)
    }

    override fun toString(): String {
        val builder = StringBuilder("LinkList:[")
        var next = dummyHead?.next
        for (i in 0 until size) {
            builder.append(next?.e)
            if (i != size - 1) {
                builder.append(" -> ")
            }
            next = next?.next
        }
        builder.append("]")
        return builder.toString()
    }
}

fun main() {
    var linkedList = LinkedList<Int>()
    for (i in 0..5) {
        linkedList.addFirst(i)
        println(linkedList)
    }
    linkedList.add(6, 10)
    println(linkedList)
    linkedList.remove(3)
    println(linkedList)
    linkedList.removeFirst()
    println(linkedList)
    linkedList.removeLast()
    println(linkedList)
}

