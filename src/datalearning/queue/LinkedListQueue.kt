package datalearning.queue

import datalearning.interf.Queue

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/18 13:12
 */
class LinkedListQueue<E> : Queue<E> {

    inner class Node(var e: E? = null, var next: Node? = null)

    var head: Node? = null
    var tail: Node? = null
    private var size:Int=0

    override fun getSize(): Int =size

    override fun isEmpty(): Boolean =size==0

    override fun enqueue(element: E) {
        if(tail==null){
            tail=Node(element)
            head=tail
        }else{
            tail?.next=Node(element)
            tail=tail?.next
        }
        size++
    }

    override fun dequeueu(): E {
        if(isEmpty()){
            throw IllegalArgumentException("大兄弟，没数据了啊")
        }
        val retNode = head
        head=head?.next
        retNode?.next=null
        if(head==null){
            tail=null
        }
        size--
        return retNode?.e!!
    }

    override fun getFront(): E {
        if(isEmpty()){
            throw IllegalArgumentException("大兄弟，没数据了啊")
        }
        return head?.e!!
    }

    override fun toString(): String {
        var builder = StringBuilder("Queue: front ")
        var node=head
        while (node!=null){
            builder.append(node.e).append("->")
            node=node.next
        }
        builder.append(" NULL tail")
        return builder.toString()
    }

}

fun main() {
    var queue = LinkedListQueue<Int>()
    for(i in 0..10){
        queue.enqueue(i)
        print(queue)
    }
    for (i in 0..5){
        queue.dequeueu()
        print(queue)
    }
}