package link

import interf.Stack
import java.lang.StringBuilder

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/18 11:30
 */
class LinkedListStack<E> : Stack<E> {

    private var linkedList=LinkedList<E>()

    override fun getSize(): Int =linkedList.size

    override fun isEmpty(): Boolean=linkedList.isEmpty()

    override fun push(e: E) =linkedList.addFirst(e)

    override fun pop(): E =linkedList.removeFirst()!!

    override fun peek(): E =linkedList.getFirst()!!

    override fun toString(): String {
        return StringBuilder("Stack:Top[").append(linkedList).append("]").toString()
    }
}

fun main() {
    val stack = LinkedListStack<Int>()
    for (i in 0..10) {
        stack.push(i)
        println(stack)
    }
    for (i in 0..10) {
        stack.pop()
        println(stack)
    }
}