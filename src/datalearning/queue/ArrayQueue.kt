package datalearning.queue
import datalearning.array.Array
import datalearning.interf.Queue

/**
 *描述：基于数组的队列实现。
 *<p/>作者：wu
 *<br/>创建时间：2019/7/17 15:40
 */
class ArrayQueue<E>(capacity: Int = 10) : Queue<E> {
    var array: Array<E> = Array(capacity)

    override fun getSize(): Int = array.size

    override fun isEmpty(): Boolean = array.isEmpty

    override fun enqueue(element: E) = array.add(element)

    override fun dequeueu(): E = array.removeFirst()

    override fun getFront(): E = array.last

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("datalearning.interf.Queue: front[")
        for (i in 0 until array.size) {
            builder.append(array.get(i))
            if (i != array.size - 1) {
                builder.append(", ")
            }
        }
        builder.append("] tail")
        return builder.toString()
    }
}

fun main() {
    val queue = ArrayQueue<Int>()
    for (i in 0..10) {
        queue.enqueue(i)
    }
    for (i in 0 until 4){
        queue.dequeueu()
    }
    println(queue)

}