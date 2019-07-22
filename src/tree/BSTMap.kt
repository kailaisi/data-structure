package tree

import interf.Map

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/22 11:46
 */
class BSTMap<K : Comparable<K>, V> : Map<K, V> {
    private var size = 0
    private var root: Node? = null

    override fun add(k: K, v: V) {
        root = add(root, k, v)
    }

    /**
     * 递归增加，返回的是节点
     */
    private fun add(node: Node?, k: K, v: V): Node {
        if (node == null) {
            size++
            return Node(k, v)
        }
        when {
            k > node.k -> node.right = add(node.right, k, v)
            k < node.k -> node.left = add(node.left, k, v)
            else -> node.k = k
        }
        return node
    }

    private fun getNode(node: Node?, k: K): Node? {
        if (node == null) {
            return null
        }
        return when (k) {
            node.k -> node
            k < node.k -> getNode(node.left, k)
            else -> getNode(node.right, k)
        }
    }

    override fun remove(k: K): V? {
        var node = getNode(root, k)
        if (node != null) {
            return remove(root, k)!!.v
        }
        return null
    }

    private fun remove(node: Node?, k: K): Node? {
        if (node == null) {
            return null
        }
        if (k < node.k) {
            node.left = remove(node.left, k)
            return node
        } else if (k > node.k) {
            node.right = remove(node.right, k)
            return node
        } else {
            if (node.left == null) {
                val right = node.right
                node.right = null
                size--
                return right
            }
            if (node.right == null) {
                val left = node.left
                node.left = null
                size--
                return left
            }
            val min = min(node.right)
            min.right = removeMin(node.right)
            min.left = node.left
            node.left = null
            node.right = null
            return min
        }
    }

    private fun min(node: Node?): Node {
        return if (node?.left == null) node!! else min(node.left)
    }

    /**
     * node删除之后，返回删除之后的node的节点
     */
    private fun removeMin(node: Node?): Node? {
        if (node?.left == null) {
            val rightNode = node?.right
            node?.right = null
            size--
            return rightNode
        }
        node.left = removeMin(node.left)
        return node
    }

    override fun contains(k: K): Boolean = getNode(root, k) != null

    override fun get(k: K): V? = getNode(root, k)?.v

    override fun set(k: K, v: V) {
        var node = getNode(root, k)
        node?.v = v
    }

    override fun getSize(): Int = size

    override fun isEmpty(): Boolean = size == 0

    inner class Node(var k: K, var v: V, var left: Node? = null, var right: Node? = null)

}

fun main() {
    var bstMap = BSTMap<Int, Int>()
    bstMap.set(1, 1)
    println(bstMap.get(1))
}