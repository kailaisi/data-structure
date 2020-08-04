package sort

/**
 *描述：冒泡排序的优化
 *<p/>作者：kailaisi
 *<br/>创建时间：2020/8/4 9:21
 * 优化方法：遍历的过程中，如果发现整个遍历没有进行位置的变化，证明已经是有序的了，后面就没有必要再进行排序了。
 */
class BubbleSortSecond : Sort {
    override fun sort(array: IntArray) {
        var size = array.size
        for (i in 0 until size-1) {
            var isSorted=true
            for (j in 0 until size - i-1) {
                if (array[j] > array[j + 1]) {
                    isSorted=false
                    val tmp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = tmp
                }
            }
            if(isSorted){
                println("当前第${i}层循环，跳出了")
                break
            }
        }
    }
}