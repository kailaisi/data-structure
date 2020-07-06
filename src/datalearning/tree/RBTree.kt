package datalearning.tree

import Utils
import datalearning.interf.Map

/**
 *描述：红黑树，绝对平衡的二分搜索树。主要是进行了旋转操作。相对于AVL添加，删除更有优势，查询的话（可能会是2Log(n)）,相对于AVL树有稍微一点点差距
 *<p/>作者：wu
 *<br/>创建时间：2019/7/22 11:46
 */
class RBTree<K : Comparable<K>, V> : Map<K, V> {
    companion object {
        val RED = true
        val BLACK = false
    }

    private var size = 0
    private var root: Node? = null

    fun isRed(node: Node?): Boolean {
        return node?.color ?: BLACK
    }

    /**
     * 向红黑树中添加节点
     */
    override fun add(k: K, v: V) {
        root = add(root, k, v)
        root?.color = BLACK
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
            else -> node.v = v
        }
         var now=node
         if (isRed(now.right) && !isRed(now.left)) {
             now = leftRotate(now)
         }
         if (isRed(now?.left) && isRed(now?.left?.left)) {
             now = rightRotate(now!!)
         }
         if (isRed(now?.left) && isRed(now?.right)) {
             flipColor(now!!)
         }
        return now!!
    }

    /**
     * 对node节点进行左旋转
     *         node                       x
     *        / \                       /   \
     *       T1  x                   node   T3
     *          / \          --->    / \
     *       T2   T3                T1 T2
     */
    private fun leftRotate(node: Node): Node? {
        var x = node.right
        node.right = x?.left
        x?.left = node
        x?.color = node.color
        node.color = RED
        return x
    }

    /**
     * 对node节点进行右旋转
     *         node                       x
     *        / \                       /   \
     *       x   T2                   y     node
     *      / \           --->              /  \
     *    y   T1                           T1  T2
     */
    private fun rightRotate(node: Node): Node? {
        var x = node.left
        node.left = x?.right
        x?.right = node
        x?.color = node.color
        node.color = RED
        return x
    }

    /**
     * 进行颜色翻转
     */
    private fun flipColor(node: Node) {
        node.color = RED
        node.left?.color = BLACK
        node.right?.color = BLACK
    }

    private fun getNode(node: Node?, k: K): Node? {
        if (node == null) {
            return null
        }
        return when {
            node.k == k -> node
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

    inner class Node(var k: K, var v: V) {
        var left: Node? = null
        var right: Node? = null
        var color = RED
    }

}

fun main() {
    var list = Utils.readFile("F:\\workspace\\web\\data-structure\\Array\\src\\pride.txt")
    println("list size:${list.size}")
    val bst = RBTree<String, Int>()
    list.forEach {
        if (bst.contains(it)) {
            bst.set(it, 1.plus(bst.get(it) ?: 0))
        } else {
            bst.add(it, 1)
        }
    }
    println("total dif words:${bst.getSize()}")
    println("frequency of pride ${bst.get("pride")}")
    println("frequency of prejudice ${bst.get("prejudice")}")
}