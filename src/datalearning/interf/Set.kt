package datalearning.interf

/**
 *描述：接口
 *<p/>作者：wu
 *<br/>创建时间：2019/7/22 8:47
 */
interface Set<E> {
    fun add(e: E)
    fun remove(e: E)
    fun getSize(): Int
    fun contains(e: E): Boolean
    fun isEmpty(): Boolean
}