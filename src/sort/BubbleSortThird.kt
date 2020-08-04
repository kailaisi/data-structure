package sort

/**
 *描述：冒泡排序的优化
 *<p/>作者：kailaisi
 *<br/>创建时间：2020/8/4 9:21
 * 优化方法：{2,1,3,4,5,6,7,8}这种序列，第一次排序，排序8，第二次是7，第三次是6.
 * 其实这部分本身已经是有序的了。所以我们可以记录最后一个改变位置的序号。那么这个序号之后的位置都经是有序的了
 * 下次遍历循环，这一部分就不需要进行排序处理了
 */
class BubbleSortThird : Sort {
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