package leetcode

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/24 15:00
 */
class NumArray2(nums: IntArray) {
    var sum = IntArray(nums.size+1)

    init {
        sum[0] = 0
        for (i in 1 until sum.size) {
            sum[i] = sum[i - 1].plus(nums[i-1])
        }
    }

    fun sumRange(i: Int, j: Int): Int {
        return sum[j + 1] - sum[i]
    }
}

fun main() {
    var ints = intArrayOf(-2, 0, 3, -5, 2, -1)
    var array2 = NumArray2(ints)
    println(array2.sumRange(2,5))
}