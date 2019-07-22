package interf

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/22 10:50
 */
interface Map<K, V> {
    fun add(k: K, v: V)
    fun remove(k: K): V?
    fun contains(k: K): Boolean
    fun get(k: K): V?
    fun set(k: K, v: V)
    fun getSize(): Int
    fun isEmpty(): Boolean
}