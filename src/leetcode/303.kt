package leetcode

import segmenttree.Merger
import segmenttree.SegmentTree

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/24 15:00
 */
class NumArray(nums: IntArray) {
    var array: Array<Int> = nums.toTypedArray()


    var segmentTree = SegmentTree(array, object : Merger<Int> {
        override fun merge(a: Int, b: Int): Int {
            return a.plus(b)
        }
    })


    fun sumRange(i: Int, j: Int): Int {
        return segmentTree.query(i,j)
    }

}

fun main() {
    var arr=IntArray(0)
    var numArray1 = NumArray(arr)
    var numArray= numArray1
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(i,j)
 */