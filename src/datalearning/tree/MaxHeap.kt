package datalearning.tree

import datalearning.array.Array
import kotlin.random.Random


/**
 *描述：基于数组的最大堆。顶点的值大于左右两边的子节点
 * 实质：完全二叉树。增加和移除顶部的时间负责度都是log(n)级别的
 *<p/>作者：kailaisi
 *<br/>创建时间：2019/7/22 18:31
 */
class MaxHeap<E : Comparable<E>>(capacity: Int = 10) {
    var data: Array<E>

    init {
        data = Array(capacity)
    }

    public constructor(array: kotlin.Array<E>) : this() {
        data = Array(array)
        for (i in parent(array.size - 1) downTo 0) {
            siftDown(i)
        }
    }


    fun getSize() = data.size

    fun isEmpty() = data.isEmpty

    fun add(e: E) {
        //先将数据添加到最后
        data.add(e)
        //通过不断的上浮，将节点放到合适的位置。
        siftUp(data.size - 1)
    }

    /**
     * 查找到最大元素
     */
    fun findMax(): E {
        if (data.size == 0) {
            throw IllegalArgumentException("空数据啊，大兄弟")
        }
        return data[0]
    }

    /**
     * 移除最大值
     */
    fun extratMax(): E {
        var max = findMax()
        data.swap(0, data.size - 1)
        data.removeLast()
        siftDown(0)
        return max
    }

    /**
     * 取出堆中最大元素，并替换成元素e
     */
    fun replace(e: E): E? {
        var max = findMax()
        data.set(0, e)
        siftDown(0)
        return max
    }

    private fun siftUp(i: Int) {
        var index = i
        while (index > 0 && data.get(parent(index)) < data[index]) {
            data.swap(index, parent(index))
            index = parent(index)
        }
    }

    private fun siftDown(k: Int) {
        var down = k
        while (leftChild(down) < data.size) {
            var child = leftChild(down)
            if (child + 1 < data.size && data[child + 1] > data[child]) {
                child = rightChild(down)
            }
            if (data[down] > data[child]) {
                break
            }
            data.swap(down, child)
            down = child
        }

    }

    /**
     * 获取父类
     */
    private fun parent(index: Int): Int {
        if (index == 0) throw IllegalArgumentException("大兄弟，0是没有父节点的啊")
        return (index.minus(1)).div(2)
    }

    /**
     * 获取左孩子
     */
    private fun leftChild(index: Int) = index.times(2) + 1

    /**
     * 获取右孩子
     */
    private fun rightChild(index: Int) = index.times(2) + 2
}

fun main() {
    var num = 100000
    var maxHeap = MaxHeap<Int>()
    for (i in 0 until num) {
        var e = Random.nextInt(Int.MAX_VALUE)
        maxHeap.add(e)
        print("$e->")
    }
    println()
    var array = IntArray(num)
    for (i in 0 until num) {
        array[i] = maxHeap.extratMax()!!
        print("${array[i]}->")
    }

    for (i in 0 until num - 1) {
        if (array[i] < array[i + 1]) {
            throw IllegalArgumentException("出错了呢")
        }
    }

}