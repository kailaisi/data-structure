package sort

/**
 *描述：堆排序，基于堆的实现
 *<p/>作者：kailaisi
 *<br/>创建时间：2020/8/7 8:40
 * 说明：堆排序是利用二叉堆的特性来进行处理
 * 先通过构建最大堆，然后通过将顶点的位置放到末尾，然后调整二叉堆，将次一个大的节点放到堆顶。循环往复，从而调整数据
 */
class HeapSort : Sort {
    override fun sort(array: IntArray) {
        //从最后一个非叶子节点开始依次做下沉操作。这里相当于是从底部开始构建有序的堆
        for (i in (array.size - 2) / 2 downTo 0) {
            downAdjust(array, i, array.size)
        }
        println(array.contentToString())
        //循环删除堆顶元素，移到集合尾部，然后调整堆产生新的堆顶
        for (i in array.size - 1 downTo 1) {
            //将堆顶位置和最后一个元素交换
            var tmp = array[i]
            array[i] = array[0]
            array[0] = tmp
            //通过下沉，重新调整最大堆
            downAdjust(array, 0, i)
        }
        println(array.contentToString())
    }

    /**
     * 下沉操作。需要将parent位置的数据下沉。
     * 这里构建的是最大堆，最大的数据在根节点上
     */
    private fun downAdjust(intArray: IntArray, parentIndex: Int, length: Int) {
        val tmp = intArray[parentIndex]
        var parent = parentIndex
        var child = 2 * parentIndex + 1
        while (child < length) {
            //找到子节点中的最大的那个数的位置
            if (child + 1 < length && intArray[child + 1] > intArray[child]) {
                //右节点大
                child++
            }
            if (tmp >= intArray[child]) {
                //父节点比最大的子节点都大，说明已经满足要求，则不处理了
                break
            }
            //将父节点和最大的子节点交换位置
            intArray[parent] = intArray[child]
            //继续迭代，将当前的节点下沉
            parent = child
            child = 2 * child + 1
        }
        intArray[parent] = tmp
    }
}

fun main() {
    val intArray = intArrayOf(5, 8, 6, 5, 5, 6, 6, 9, 6, 9, 9, 14, 3, 9, 2, 1, 7, 14, 15, 16, 77, 18)
    val sort = HeapSort()
    sort.sort(intArray)
    println(intArray.contentToString())
}