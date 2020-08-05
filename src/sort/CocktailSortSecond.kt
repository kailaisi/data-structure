package sort

/**
 *描述：鸡尾酒排序
 *<p/>作者：kailaisi
 *<br/>创建时间：2020/8/4 9:21
 * 思想：鸡尾酒排序优化，记录最后和最前的位置。
 *
 */
class CocktailSortSecond : Sort {
    override fun sort(array: IntArray) {
        var size = array.size
        var lastPos = 0
        var lastBorder = size - 1
        var firtPos = 0
        var firstBorder = 0
        for (i in 0 until size / 2) {
            var sort = true
            for (j in i until lastBorder) {
                if (array[j] > array[j + 1]) {
                    val tmp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = tmp
                    sort = false
                    lastPos = j
                }
            }
            lastBorder = lastPos
            println("当前右边界$lastBorder")
            if (sort) {
                println("当前第${i}层从左往右的循环，跳出了")
                return
            }
            sort = true
            for (j in size - 1 - i downTo firstBorder + 1) {
                //注意这里第一个数据是size-1-i。所以应该比较的是j和j-1
                if (array[j] < array[j - 1]) {
                    val tmp = array[j]
                    array[j] = array[j - 1]
                    array[j - 1] = tmp
                    firtPos = j
                    sort = false
                }
            }
            firstBorder = firtPos
            println("当前左边界$firstBorder")
            if (sort) {
                println("当前第${i}层从右往左的循环，跳出了")
                return
            }
        }
    }
}

fun main() {
    val bubb = CocktailSortSecond()
    var array = intArrayOf(5, 8, 6, 3, 9, 2, 1, 7,14,15,16,17,18)
    bubb.sort(array)
    print("鸡尾酒排序算法：${array.contentToString()}")
}