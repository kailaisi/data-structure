package datalearning.link

import datalearning.interf.Map
import java.lang.IllegalArgumentException

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/22 11:03
 */
class LinkedListMap<K, V> : Map<K, V> {
    private var dummyHead: Node = Node()
    private var size = 0


    override fun add(k: K, v: V) {
        var node = getNode(k)
        if (node == null) {
            dummyHead.next = Node(k, v, dummyHead.next)
            size++
        } else {
            node.v = v
        }

    }

    private fun getNode(k: K): Node? {
        var cur = dummyHead.next
        while (cur != null) {
            if (cur.k == k) {
                return cur
            }
            cur = cur.next
        }
        return null
    }

    override fun remove(k: K): V? {
        var pre = dummyHead
        while (pre.next != null) {
            if (pre.next!!.k == k) {
                var del = pre.next
                pre.next = del!!.next
                del.next = null
                return del.v
            }
        }
        return null
    }

    override fun contains(k: K): Boolean = getNode(k) != null

    override fun get(k: K): V? = getNode(k)?.v

    override fun set(k: K, v: V) {
        val node = getNode(k)
        if (node != null) {
            node.v = v
        } else {
            throw IllegalArgumentException("$k doesn't exist")
        }
    }

    override fun getSize(): Int = size

    override fun isEmpty(): Boolean = size == 0


    inner class Node(var k: K? = null, var v: V? = null, var next: Node? = null) {
        override fun toString(): String {
            return "$k:$v"
        }
    }
}

fun main() {
}