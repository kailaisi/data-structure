package tree

import java.util.*
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
            if (e > node.e) {
                search(node.right, e)
            } else {
                search(node.left, e)
            }
        }
    }

    /**
     * 前序遍历
     */
    fun preOrder() {
        preOrder(root)
    }

    fun preOrderNR() {
        var stack = Stack<Node>()
        stack.push(root)
        while (!stack.isEmpty()) {
            val pop = stack.pop()
            println(pop.e)
            if (pop.right != null) {
                stack.push(pop.right)
            }
            if (pop.left != null) {
                stack.push(pop.left)
            }
        }
    }

    /**
     * 中序遍历
     */
    fun inOrder() {
        inOrder(root)
    }

    /**
     * 非递归中序
     */
    fun inOrderNR() {
        var stack = Stack<Node>()
        var input = root
        while (!stack.isEmpty()) {
            var pop = stack.pop()
            println(pop.e)
            if (pop.right != null) {
                stack.push(pop.right)
            }
            if (pop.left != null) {
                stack.push(pop.left)
            }
        }
    }

    /**
     * 广度遍历
     */
    fun levelOrder() {
        var list = LinkedList<Node?>()
        list.add(root)
        while (!list.isEmpty()) {
            var node = list.pop()
            if (node?.left != null) {
                list.add(node.left)
            }
            if (node?.right != null) {
                list.add(node.right)
            }
        }
    }

    fun min(): E {
        if (size == 0) {
            throw IllegalStateException("大兄弟，没数据，你查什么啊")
        }
        return min(root).e
    }

    private fun min(node: Node?): Node {
        return if (node?.left == null) node!! else min(node.left)
    }

    fun max(): E {
        if (size == 0) {
            throw IllegalStateException("大兄弟，没数据，你查什么啊")
        }
        return max(root)
    }

    private fun max(node: Node?): E {
        return if (node?.right == null) node?.e!! else max(node.right)
    }

    /**
     * 后序排序
     */
    fun postOrder() {
        postOrder(root)
    }

    private fun postOrder(node: Node?) {
        if (node != null) {
            postOrder(node.left)
            postOrder(node.right)
            println(node.e)
        }
    }

    private fun inOrder(node: Node?) {
        if (node != null) {
            inOrder(node.left)
            println(node.e)
            inOrder(node.right)
        }
    }

    private fun preOrder(node: Node?) {
        if (node != null) {
            println(node.e)
            preOrder(node.left)
            preOrder(node.right)
        }
    }

    fun removeMin(): E {
        var ret = min()
        root = removeMin(root)
        return ret
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

    fun removeMax(): E {
        var ret = max()
        root = removeMax(root)
        return ret
    }

    private fun removeMax(node: Node?): Node? {
        if (node?.right == null) {
            val left = node?.left
            node?.left = null
            size--
            return left
        }
        node.right = removeMax(node.right)
        return node
    }

    fun remove(e: E) {
        root = remove(root, e)
    }

    private fun remove(node: Node?, e: E): Node? {
        if (node == null) {
            return null
        }
        when {
            e < node.e -> {
                node.left = remove(node.left, e)
                return node
            }
            e > node.e -> {
                node.right = remove(node.right, e)
                return node
            }
            else -> {//node.e=e
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
                node.left=null
                node.right=null
                return min
            }
        }

    }

    override fun toString(): String {
        var builder = StringBuilder()
        generateBST(root, 0, builder)
        return builder.toString()
    }

    private fun generateBST(node: Node?, deep: Int, builder: StringBuilder) {
        if (node == null) {
            for (i in 0 until deep) {
                builder.append("--")
            }
            builder.append("null\n")
            return
        }
        for (i in 0 until deep) {
            builder.append("--")
        }
        builder.append("${node.e}\n")
        generateBST(node.left, deep + 1, builder)
        generateBST(node.right, deep + 1, builder)
    }
}

fun main() {
    val bst = BST<Int>()
    for (i in 0..20) {
        var e = Random.nextInt(50)
        print("$e ->")
        bst.add(e)
    }
    println()
    while (!bst.isEmpty()) {
        print("${bst.removeMax()}->")
    }
    println()
}