package sort

/**
 *描述：测试数据
 *<p/>作者：
 *<br/>创建时间：2020/8/4 9:27
 */
fun main() {
    var ints = intArrayOf(5, 8, 6, 3, 9, 2, 1, 7)
    var sort:Sort = BubbleSort()
  //  sort.sort(ints)
    println("冒泡排序："+ints.contentToString())
    sort=BubbleSortSecond()
    sort.sort(ints)
    println("冒泡排序优化："+ints.contentToString())
    ints= intArrayOf(2,1,3,4,5,6,7,8)
    sort=BubbleSortThird()
    sort.sort(ints)
    println("冒泡排序优化："+ints.contentToString())
}