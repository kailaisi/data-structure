package leetcode

import java.util.*

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/19 18:30
 */
class Solution1 {
    fun backspaceCompare(S: String, T: String): Boolean {
        var sStack = LinkedList<Char>()
        var tStack = LinkedList<Char>()
        S.iterator().forEach {
            if (it == '#') {
                sStack.poll()
            } else {
                sStack.push(it)
            }
        }
        T.iterator().forEach {
            if (it == '#') {
                tStack.poll()
            } else {
                tStack.push(it)
            }
        }
        var flag = true
       if(tStack.size!=sStack.size) return false
        while (!tStack.isEmpty()){
            if(tStack.pop()!=sStack.pop()){
                return false
            }
        }
        return true
    }
}

fun main() {
    println(Solution1().backspaceCompare("y#fo##f", "y#f#o##f"))
}