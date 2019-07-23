package array

import interf.Stack

/**
 * 描述：
 *
 * 作者：wu
 * <br></br>创建时间：2019/7/17 13:15
 */
class ArrayStack<E> @JvmOverloads constructor(capacity: Int = 10) : Stack<E> {

    internal var array: Array<E>

    init {
        array = Array(capacity)
    }

    override fun getSize(): Int {
        return array.size
    }

    override fun isEmpty(): Boolean {
        return array.isEmpty
    }

    override fun push(e: E) {
        array.add(e)
    }

    override fun pop(): E {
        return array.removeLast()
    }

    override fun peek(): E {
        return array.last
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("Stack: [")
        for (i in 0 until array.size) {
            builder.append(array.get(i))
            if (i != array.size - 1) {
                builder.append(", ")
            }
        }
        builder.append("] top")
        return builder.toString()
    }
}
