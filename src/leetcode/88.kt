package leetcode

import java.util.*

class Solution88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i=0
        var j=0
        var queue = LinkedList<Int>()
        while (i<m && j<n){
            if(nums1[i]<nums2[j]){
                queue.add(nums1[i])
                i++
            }else{
                queue.add(nums2[j])
                j++
            }
        }
        while(i<m){
            queue.add(nums1[i])
            i++
        }
        while (j<n){
            queue.add(nums2[j])
            j++
        }
        for (k in 0 until m+n){
            nums1[k]=queue.poll()
            println(nums1[k])
        }
    }
}

fun main() {
    var arrayOf = intArrayOf(1, 2, 3, 0, 0, 0)
    var arrayOf1 = intArrayOf(2, 5, 6)
    Solution88().merge(arrayOf,3,arrayOf1,3)
    println(arrayOf.toString())
}