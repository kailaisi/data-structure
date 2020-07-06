package leetcode

import java.util.*

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/19 17:39
 */
class Solution {
    fun isValid(s: String): Boolean {
        if(s.length%2==1) return false
        val stack = Stack<Char>()
        for (i in 0 until s.length) {
            var c = s[i]
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c)
            } else {
                if (stack.isEmpty()) return false
                var pop = stack.pop()
                if (c == ')' && pop != '(') return false
                if (c == ']' && pop != '[') return false
                if (c == '}' && pop != '{') return false
            }
        }
        return stack.isEmpty()
    }
}

fun main() {
    println(Solution().isValid("{}()[]"))
}