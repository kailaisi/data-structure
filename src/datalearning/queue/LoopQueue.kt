package datalearning.queue

import datalearning.interf.Queue
import kotlin.Array
/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/17 16:20
 */
class LoopQueue<E>(capacity: Int = 10) : Queue<E> {

    var data: Array<E?> = arrayOfNulls<Any>(capacity.plus(1)) as Array<E?>
    var front: Int = 0
        private set
    var tail = 0
        private set
    private var size = 0

    fun getCapacity() = data.size - 1

    override fun getSize(): Int = size

    override fun isEmpty(): Boolean = tail == front

    override fun enqueue(element: E) {
        if ((tail + 1) % data.size == front) {
            resize(2 * getCapacity() + 1)
        }
        data[tail] = element
        tail = (tail + 1) % data.size
        size++
    }

    private fun resize(resize: Int) {
        var newData = arrayOfNulls<Any>(resize.plus(1)) as Array<E?>
        for (i in 0 until size) {
            newData[i] = data[(i + front) % data.size]
        }
        data = newData
        front = 0
        tail = size
    }

    override fun dequeueu(): E {
        if (isEmpty()) {
            throw IllegalStateException("大兄弟，队列都空了。。")
        }
        var e = data[front]
        data[front] = null
        front = (front + 1) % data.size
        size--
        return e!!
    }

    override fun getFront(): E {
        if (isEmpty()) {
            throw IllegalStateException("大兄弟，队列都空了。。")
        }
        return data[front]!!
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("datalearning.queue.LoopQueue: front[")
        for (i in 0 until size) {
            builder.append(data[(i+front)%data.size])
        }
        builder.append("] tail")
        return builder.toString()
    }

}

fun main() {
    val queue = LoopQueue<Int>()
    for (i in 0..10) {
        queue.enqueue(i)
    }
    for (i in 0 until 4){
        queue.dequeueu()
    }
    println(queue)
}