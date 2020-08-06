package sort

/**
 *描述：快速排序的单边循环法
 *<p/>作者：kailaisi
 *<br/>创建时间：2020/8/6 8:55
 * 从左边开始一个个比较
 */
class QuickSortSecond : Sort {
    override fun sort(intArray: IntArray) {
        qucikSort(intArray, 0, intArray.size - 1)
    }

    /**
     * 分而治之的思想，将left到right位置的进行排序
     */
    private fun qucikSort(intArray: IntArray, left: Int, right: Int) {
        //循环停止的条件
        if (left >= right) {
            return
        }
        //获取基准元素的位置。
        val pivot = partition(intArray, left, right)
        //迭代左右两边，进行排序
        qucikSort(intArray, left, pivot - 1)
        qucikSort(intArray, pivot + 1, right)
    }

    /**
     * 这里会进行一次排序，然后将比基准点大的数据放到右侧，比基准点小的放到左边。然后返回基准点坐在的位置。
     */
    private fun partition(intArray: IntArray, startIndex: Int, endIndex: Int): Int {
        //取第一个位置的数据当做基准点
        var pivot = intArray[startIndex]
        //mark相当于标记了比基准点数据小的边界位置。
        var mark = startIndex
        var left = startIndex
        while (left <= endIndex) {
            if (intArray[left] < pivot) {
                //发现了比基准点小的数据，那么就mark++，然后将mark位置的数据和left节点数据进行交换
                mark++
                val tmp = intArray[mark]
                intArray[mark] = intArray[left]
                intArray[left] = tmp
            }
            left++
        }
        //将基准点的位置和mark位置进行交换
        intArray[startIndex] = intArray[mark]
        intArray[mark] = pivot
        return mark
    }
}


fun main() {
    val bubb = QuickSortSecond()
    var array = intArrayOf(5, 8, 6, 5, 5, 6, 6, 9, 6, 9, 9, 14, 3, 9, 2, 1, 7, 14, 15, 16, 77, 18)
    bubb.sort(array)
    print("快速排序单边算法：${array.contentToString()}")
}