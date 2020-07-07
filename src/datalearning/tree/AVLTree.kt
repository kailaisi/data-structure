package datalearning.tree

import datalearning.test.Utils
import datalearning.interf.Map
import java.lang.RuntimeException
import kotlin.math.abs
import kotlin.math.max

/**
 *描述：平衡二叉树,将二分搜索树进行平衡处理。将各个时间复杂度都变为了logN
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
        //维护平衡，LL
        if (balanceFactor > 1 && getBalanceFacotr(node.left) >= 0) {
            return rightRotate(node)
        }
        //RR
        if (balanceFactor < -1 && getBalanceFacotr(node.right) <= 0) {
            return leftRotate(node)
        }
        //LR
        if (balanceFactor > 1 && getBalanceFacotr((node.left)) < 0) {
            node.left = leftRotate(node.left!!)
            return rightRotate(node)
        }
        //RL
        if (balanceFactor < -1 && getBalanceFacotr(node.right) > 0) {
            node.right = rightRotate(node.right!!)
            return leftRotate(node)
        }
        return node
    }

    /**
     * 对node节点进行右旋转
     *         y                           x
     *        / \                       /   \
     *       x   T4                    z     y
     *      / \             --->      / \   / \
     *     z   T3                    T1 T2 T3 T4
     *    / \
     *   T1  T2
     */
    private fun rightRotate(y: Node): Node {
        var x = y.left!!
        var T3 = x.right
        x.right = y
        y.left = T3
        //更新height,需要先更新y的高度，然后更新x的高度，应为x的高度和y有关
        y.height = max(getHight(y.left), getHight(y.right)).plus(1)
        x.height = max(getHight(x.left), getHight(x.right)).plus(1)
        return x
    }

    /**
     * 对node节点进行左旋转
     *         y                           x
     *        / \                       /   \
     *       T4  x                      y     z
     *          / \          --->      / \   / \
     *       T3     z                T4 T3 T1 T2
     *             / \
     *           T1  T2
     */
    private fun leftRotate(y: Node): Node {
        var x = y.right!!
        var T3 = x.left
        x.left = y
        y.right = T3
        //更新height,需要先更新y的高度，然后更新x的高度，应为x的高度和y有关
        y.height = max(getHight(y.left), getHight(y.right)).plus(1)
        x.height = max(getHight(x.left), getHight(x.right)).plus(1)
        return x
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
            return remove(root, k)?.v
        }
        return null
    }

    private fun remove(node: Node?, k: K): Node? {
        if (node == null) {
            return null
        }
        var retNode: Node?
        when {
            k < node.k -> {
                node.left = remove(node.left, k)
                retNode = node
            }
            k > node.k -> {
                node.right = remove(node.right, k)
                retNode = node
            }
            else -> when {
                node.left == null -> {
                    val right = node.right
                    node.right = null
                    size--
                    retNode = right
                }
                node.right == null -> {
                    val left = node.left
                    node.left = null
                    size--
                    retNode = left
                }
                else -> {
                    val min = min(node.right)
                    min.right = remove(node.right, min.k)
                    min.left = node.left
                    node.left = null
                    node.right = null
                    retNode = min
                }
            }
        }
        if (retNode==null){
            return null
        }
        //更新node的height
        retNode.height = 1 + max(getHight(retNode.left), getHight(retNode.right))
        var balanceFactor = getBalanceFacotr(retNode)
        //维护平衡，LL
        if (balanceFactor > 1 && getBalanceFacotr(retNode.left) >= 0) {
            return rightRotate(retNode!!)
        } else
        //RR
            if (balanceFactor < -1 && getBalanceFacotr(retNode.right) <= 0) {
                return leftRotate(retNode!!)
            }
        //LR
        if (balanceFactor > 1 && getBalanceFacotr((retNode.left)) < 0) {
            retNode.left = leftRotate(retNode.left!!)
            return rightRotate(retNode)
        }
        //RL
        if (balanceFactor < -1 && getBalanceFacotr(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right!!)
            return leftRotate(retNode)
        }
        return retNode
    }

    private fun min(node: Node?): Node {
        return if (node?.left == null) node!! else min(node.left)
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
    for (s in list){
        avlTree.remove(s)
        if(!avlTree.isBST()||!avlTree.isBalanced()){
            throw RuntimeException("Error")
        }
    }
}