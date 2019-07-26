package tree

import Utils
import interf.Map
import kotlin.math.abs
import kotlin.math.max

/**
 *描述：平衡二叉树
 *<p/>作者：wu
 *<br/>创建时间：2019/7/22 11:46
 */
class AVLTree<K : Comparable<K>, V> : Map<K, V> {
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
        //更新node的height
        node.height = 1 + max(getHight(node.left), getHight(node.right))
        var balanceFactor = getBalanceFacotr(node)
        if (abs(balanceFactor) > 1) {
            println("unbalance :$balanceFactor")
        }
        return node
    }

    /**
     * 检测是否是二分搜索树
     */
    fun isBST(): Boolean {
        var list = ArrayList<K>()
        inOrder(root, list)
        for (i in 1 until list.size) {
            if (list[i - 1] > list[i]) {
                return false
            }
        }
        return true
    }

    /**
     * 判断是否是平衡二叉树
     */
    fun isBalanced() = isBalanced(root)

    private fun isBalanced(node: Node?): Boolean {
        if (node == null) {
            return true
        }
        var facotr = getBalanceFacotr(node)
        if (abs(facotr) > 1) {
            return false
        }
        return isBalanced(node.left) && isBalanced(node.right)
    }

    private fun inOrder(node: Node?, list: ArrayList<K>) {
        if (node == null) {
            return
        }
        inOrder(node.left, list)
        list.add(node.k)
        inOrder(node.right, list)
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

    private fun getHight(node: Node?): Int {
        return node?.height ?: 0
    }

    private fun getBalanceFacotr(node: Node?): Int {
        if (node == null) {
            return 0
        }
        return getHight(node.left) - getHight(node.right)
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
        var height = 1
    }

}

fun main() {
    var list = Utils.readFile("F:\\workspace\\web\\data-structure\\Array\\src\\pride.txt")
    var avlTree = AVLTree<String, Int>()
    list.forEach {
        if (avlTree.contains(it)) {
            avlTree.set(it, 1.minus(avlTree.get(it) ?: 0))
        } else {
            avlTree.add(it, 1)
        }
    }
    println("total dif words:${avlTree.getSize()}")
    println("is BST ${avlTree.isBST()}")
    println("is isBalanced ${avlTree.isBalanced()}")
}