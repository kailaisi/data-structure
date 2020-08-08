package sort

/**
 *描述：计数排序。
 * 如果数组的数据是有一定范围的，而且取值范围不是特别大的情况下，可以通过使用计数排序来进行处理
 *  计数排序：创建一个数组，数组下标对应具体的数据，数组的值代表其出现的次数。通过统计每个数据产生的次数。
 *      然后通过遍历数组，根据其出现的次数重新进行输出
 *<p/>作者：kailaisi
 *<br/>创建时间：2020/8/7 9:25
 */
class CountSort : Sort {
    override fun sort(intArray: IntArray) {
        var max=intArray.max()!!
        var min=intArray.min()!!
        var ints = IntArray(max - min + 1)
        intArray.forEach {
            ints[it-min]++
        }
        var index=0
        for(i in 0 until ints.size){
            for(j in 0 until ints[i]){
                intArray[index]=i+min
                index++
            }
        }
    }
}

fun main() {
    val bubb = CountSort()
    val array = intArrayOf(5, 8, 6, 5, 5, 6, 6, 9, 6, 9, 9, 14, 3, 9, 2, 1, 7, 14, 15, 16, 77, 18)
    bubb.sort(array)
    print("计数排序法：${array.contentToString()}")
}