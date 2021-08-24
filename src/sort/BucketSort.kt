package sort

import java.util.*

/**
 *描述：桶排序。
 * 创建一堆桶，每个桶负责一个对应的区间，然后将每个桶内部进行排序。最后将桶的数据结合起来进行处理
 * 桶排序和
 *<p/>作者：kailaisi
 *<br/>创建时间：2020/8/7 9:25
 */
class BucketSort {
    fun sort(inputArray: DoubleArray): DoubleArray {
        //得到数组的最大值最小值
        var max = inputArray.maxOrNull()!!
        var min = inputArray.minOrNull()!!
        //创建数组来存放最大最小值范围之内的数据
        val d = max - min
        //桶的个数
        var bucketNum = inputArray.size
        val bucketList = arrayListOf<LinkedList<Double>>()
        for (i in 0 until bucketNum) {
            //创建的对应的桶
            bucketList.add(LinkedList<Double>())
        }
        inputArray.forEach {
            val num: Int = ((it - min) * (bucketNum - 1) / d).toInt()
            bucketList[num].add(it)
        }
        bucketList.forEach { it.sort() }
        var outputArray=DoubleArray(inputArray.size)
        var index = 0
        bucketList.forEach {
            it.forEach {
                outputArray[index++]=it
            }
        }
        return outputArray
    }
}

fun main() {
    val bubb = BucketSort()
    doubleArrayOf()
    val array = doubleArrayOf(5.0, 8.0, 6.0, 5.0, 5.0, 6.0, 6.0, 9.0, 6.0, 9.0, 9.0, 14.0, 3.0, 9.0, 2.0, 1.0, 7.0)
    var sort = bubb.sort(array)
    print("计数排序法：${sort.contentToString()}")
}