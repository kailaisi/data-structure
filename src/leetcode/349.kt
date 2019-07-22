package leetcode

import java.util.*

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/22 13:41
 */
class Solution349 {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        var array = arrayListOf<Int>()
        var set = TreeSet<Int>()
        nums1.forEach {
            set.add(it)
        }
        nums2.forEach {
          if(set.contains(it)){
              array.add(it)
              set.remove(it)
          }
        }
        return array.toIntArray()
    }
}