package tree

import kotlin.random.Random

/**
 *描述：二叉搜索树
 *<p/>作者：wu
 *<br/>创建时间：2019/7/19 10:13
 */
class BST<E : Comparable<E>>() {
    inner class Node(var e: E, var left: Node? = null, var right: Node? = null)

    private var root: Node? = null
    private var size: Int = 0
    fun size() = size
    fun isEmpty() = size == 0

    fun add(e: E) {
        root = add(root, e)
    }

    /**
     * 递归增加，返回的是节点
     */
    private fun add(node: Node?, e: E): Node {
        if (node == null) {
            size++
            return Node(e)
        }
        if (e > node.e) {
            node.right = add(node.right, e)
        } else if (e < node.e) {
            node.left = add(node.left, e)
        }
        return node
    }

    fun contains(e: E): Boolean {
        return search(root, e)
    }

    private fun search(node: Node?, e: E): Boolean {
        return if (node == null) {
            false
        } else if (node.e == e) {
            true
        } else {
            if (e>node.e) {
                search(node.right, e)
            } else {
                search(node.left, e)
            }
        }
    }

}

fun main() {
    var random = Random(50)
    val bst = BST<Int>()
    for (i in 0..50) {
        bst.add(random.nextInt())
    }
    println(bst.contains(10))
}