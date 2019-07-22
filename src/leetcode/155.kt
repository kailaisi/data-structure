package leetcode

import java.lang.IllegalStateException
import java.util.*

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/19 18:16
 */
class MinStack() {
    /** initialize your data structure here. */
    var help = Stack<Int>()
    var model = Stack<Int>()

    fun push(x: Int) {
        model.add(x)
        if (help.isEmpty() || x <= help.peek()) {
            help.add(x)
        }
    }

    fun pop() {
        if (model.isEmpty()) return
        val pop = model.pop()
        if (help.peek() == pop) {
            help.pop()
        }
    }

    fun top(): Int {
        if (model.isEmpty()) {
            throw IllegalStateException("数据错误")
        }
        return model.peek()
    }

    fun getMin(): Int {
        if (help.isEmpty()) {
            throw IllegalStateException("数据错误")
        }
        return help.peek()
    }

}
