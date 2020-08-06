package sort

/**
 *描述：快速排序的双边循环发
 *<p/>作者：kailaisi
 *<br/>创建时间：2020/8/6 8:55
 */
class QuickSort : Sort {
    override fun sort(intArray: IntArray) {
        qucikSort(intArray,0,intArray.size-1)
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
        var left = startIndex
        var right = endIndex
        while (left < right) {
            //从右到左，找到比基准点小的那个数字
            while (left<right &&intArray[right] >= pivot) {
                right--
            }
            //从左到右，找到比基准点大的那个数字
            while (left<right &&intArray[left] <= pivot) {
                left++
            }
            //左右交换
            if (left < right) {
                var tmp = intArray[left]
                intArray[left] = intArray[right]
                intArray[right] = tmp
            }
        }
        //pivot和重合的指针位置进行交换
        intArray[startIndex] = intArray[left]
        intArray[left] = pivot
        //返回基准点的位置
        return left
    }
}


fun main() {
    val bubb = QuickSort()
    var array = intArrayOf(5, 8, 6, 3, 9, 2, 1, 7,14,15,16,77,18)
    bubb.sort(array)
    print("快速排序算法：${array.contentToString()}")
}