package sort

/**
 *描述：冒泡排序
 *<p/>作者：kailaisi
 *<br/>创建时间：2020/8/4 9:21
 * 思想：第一次遍历，从头到尾，比较前后两个，如果前面的大， 就移动位置。通过一次循环，将最大的数据放到了最后的位置
 *       第二次遍历，从前到后比较，会将第二大的数据放到倒数第二的位置
 */
class BubbleSort : Sort {
    override fun sort(array: IntArray) {
        var size = array.size
        for (i in 0 until size-1) {
            for (j in 0 until size - i-1) {
                if (array[j] > array[j + 1]) {
                    val tmp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = tmp
                }
            }
        }
    }
}