package datalearning.queue

import datalearning.interf.Queue
import datalearning.tree.MaxHeap

/**
 *描述：基于堆的优先级队列
 *<p/>作者：wu
 *<br/>创建时间：2019/7/23 11:21
 */
class PriorityQueue<E : Comparable<E>> : Queue<E> {
    private var maxHeap = MaxHeap<E>()

    override fun getSize(): Int = maxHeap.getSize()


    override fun isEmpty() = maxHeap.isEmpty()

    override fun enqueue(element: E) = maxHeap.add(element)

    override fun dequeueu(): E = maxHeap.extratMax()

    override fun getFront(): E = maxHeap.findMax()
}