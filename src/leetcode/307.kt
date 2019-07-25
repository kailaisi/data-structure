package leetcode

import segmenttree.Merger
import segmenttree.SegmentTree

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/24 15:00
 */
class NumArray307(nums: IntArray) {
    var array: Array<Int> = nums.toTypedArray()


    var segmentTree = SegmentTree(array, object : Merger<Int> {
        override fun merge(a: Int, b: Int): Int {
            return a.plus(b)
        }
    })

    fun update(i: Int, `val`: Int) {
        segmentTree.update(i,`val`)
    }

    fun sumRange(i: Int, j: Int): Int {
        return segmentTree.query(i,j)
    }
}

fun main() {
    var ints = intArrayOf()
    var array = NumArray307(ints)
    println(array.sumRange(0, 2))
    array.update(1,2)
    println(array.sumRange(0,2))

}