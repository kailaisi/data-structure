package interf

/**
 * 描述：
 *
 * 作者：wu
 * <br></br>创建时间：2019/7/17 15:32
 */
internal interface Queue<E> {
    fun getSize(): Int
    fun isEmpty(): Boolean
    fun enqueue(element: E)
    fun dequeueu(): E
    fun getFront(): E
}
