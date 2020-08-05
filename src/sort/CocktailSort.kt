package sort

/**
 *描述：鸡尾酒排序
 *<p/>作者：kailaisi
 *<br/>创建时间：2020/8/4 9:21
 * 思想：鸡尾酒排序是对冒泡排序的另一种优化。
 * 优化方案：先从左往右，再从右往左。对于像{2,3,4,5,6,7,8,1}的数组，会有奇效。
 * 遍历次数变为了siez/2。
 * 每一轮的排序，前后i个位置的数据都已经是最大和最小的了。
 * 所以j正向开始的位置分别为i，结束位置为size-i-1;
 * 反向开始的位置分别为size-i-1,结束位置为i
 *
 */
class CocktailSort : Sort {
    override fun sort(array: IntArray) {
        var size = array.size
        for (i in 0 until size / 2) {
            var sort = true
            for (j in i until size - 1 - i) {
                if (array[j] > array[j + 1]) {
                    val tmp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = tmp
                    sort = false
                }
            }
            if (sort) {
                println("当前第${i}层从左往右的循环，跳出了")
                return
            }
            sort = true
            for (j in size - 1 - i downTo i + 1) {
                //注意这里第一个数据是size-1-i。所以应该比较的是j和j-1
                if (array[j] < array[j - 1]) {
                    val tmp = array[j]
                    array[j] = array[j - 1]
                    array[j - 1] = tmp
                    sort = false
                }
            }
            if (sort) {
                println("当前第${i}层从右往左的循环，跳出了")
                return
            }
        }
    }
}

fun main() {
    val bubb = CocktailSort()
    var array = intArrayOf(2, 3, 4, 5, 6, 7, 8, 1)
    bubb.sort(array)
    print("鸡尾酒排序算法：${array.contentToString()}")
}