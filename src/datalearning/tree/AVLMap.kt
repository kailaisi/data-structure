package datalearning.tree

import datalearning.avl.AVLTree
import datalearning.interf.Map

/**
 *描述：基于平衡树实现的Map接口
 *<p/>作者：wu
 *<br/>创建时间：2019/7/26 17:43
 */
class AVLMap<K : Comparable<K>, V> : Map<K, V> {
    private var map = AVLTree<K, V>()
    override fun add(k: K, v: V) = map.add(k, v)

    override fun remove(k: K): V? = map.remove(k)

    override fun contains(k: K): Boolean = map.contains(k)

    override fun get(k: K): V? = map.get(k)

    override fun set(k: K, v: V) = map.set(k, v)

    override fun getSize(): Int = map.getSize()

    override fun isEmpty(): Boolean = map.isEmpty()

}