package leetcode

import java.util.*

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/22 13:41
 */
class Solution350 {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        var array = arrayListOf<Int>()
        intArrayOf()
        var set = TreeMap<Int, Int>()
        nums1.forEach {
            set[it] = set.getOrDefault(it, 0).plus(1)
        }
        nums2.forEach {
            if (set.contains(it)) {
                array.add(it)
                set[it] = set[it]!!.minus(1)
                if(set[it]!! <=0){
                    set.remove(it)
                }
            }
        }
        return array.toIntArray()
    }
}

fun main() {
    var a= intArrayOf(4,9,5)
    var b= intArrayOf(9,4,9,8,4)
    var ints = Solution350().intersection(a, b)
    ints.forEach { print("$it->") }

}