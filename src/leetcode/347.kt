package leetcode

import java.util.*

/**
 *描述：思路：进行优先级进行排序，低频率的在队列头，高频率的在队列尾部。每次进行比较，如果新的数据比原来的k个的第一个频率高，那么进行入队操作。
 * 这时候，由于存的是优先级队列，会自动进行排序，将低频率的放在队列头
 *<p/>作者：wu
 *<br/>创建时间：2019/7/23 11:49
 */
class Solution347 {
    inner class Feq(var e: Int = 0, var feq: Int = 0)

    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        val treeMap = TreeMap<Int, Int>()
        nums.forEach {
            treeMap[it] = treeMap.getOrDefault(it, 0).plus(1)
        }
        var queue = PriorityQueue<Int>(Comparator { o1, o2 -> treeMap[o1]!!.minus(treeMap[o2]!!) })
        treeMap.keys.forEach {
            if (queue.size < k) {
                queue.add(it)
            } else {
                if (treeMap[it]!! >treeMap[queue.peek()]!!) {
                    queue.remove()
                    queue.add(it)
                }
            }
        }
        var list = LinkedList<Int>()
        while (!queue.isEmpty()) {
            list.add(queue.remove())
        }
        return list
    }
}

fun main() {
    var arrayOf = intArrayOf(1, 1, 1, 2, 2, 3)
    var list = Solution347().topKFrequent(arrayOf, 2)
    list.forEach { print("$it->") }
}