package leetcode

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/31 10:34
 */
class Solution387 {
    fun firstUniqChar(s: String): Int {
        var ints = IntArray(26)
        s.forEach {
            ints[it-'a']++
        }
        s.forEachIndexed { index, it ->
                if(ints[it-'a']==1){
                    return index
                }
        }
        return -1
    }
}