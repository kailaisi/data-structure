package sort

/**
 *描述：计数排序。
 *<p/>作者：kailaisi
 *<br/>创建时间：2020/8/7 9:25
 * 优化：增加了一个排序的处理，排序会增加一个排名的过程
 */
class CountSortSeconed  {
    fun sort(intArray: IntArray): IntArray {
        //得到数组的最大值最小值
        var max=intArray.max()!!
        var min=intArray.min()!!
        //创建数组来存放最大最小值范围之内的数据
        var ints = IntArray(max - min + 1)
        intArray.forEach {
            ints[it-min]++
        }
        //做变形，数组对应的值代表了其对应的排名
        for(index in 1 until ints.size){
            ints[index]+=ints[index-1]
        }
        //倒叙
        var sortedArray=IntArray(intArray.size)
        for(i in sortedArray.size-1 downTo 0){
            var i1 = ints[intArray[i] - min]
            sortedArray[i1 -1]=intArray[i]
            ints[intArray[i] - min]--
        }
        return sortedArray
    }
}

fun main() {
    val bubb = CountSortSeconed()
    val array = intArrayOf(5, 8, 6, 5, 5, 6, 6, 9, 6, 9, 9, 14, 3, 9, 2, 1, 7, 14, 15, 16, 77, 18)
    var sort = bubb.sort(array)
    print("计数排序法：${sort.contentToString()}")
}