package datalearning.hash

import Utils
import java.util.*

/**
 *描述：Hash表，每个链表中都是一个TreeMap
 *<p/>作者：wu
 *<br/>创建时间：2019/8/1 11:11
 */
class HashTable<K, V>() {
    companion object {
        val upperTol = 10
        val lowerTol = 2
        val capacity = intArrayOf(53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593, 49157, 98317, 19613, 393241, 785433, 1572869, 3145739,
                6291469, 12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741)
        var capacityIndex = 0
    }

    private var M = capacity[capacityIndex]
    private var hashTable = Array(M, init = { TreeMap<K, V>() })
    var size = 0
        private set

    init {
        for (i in 0 until M) {
            hashTable[i] = TreeMap<K, V>()
        }
    }

    private fun hash(key: K) = key.hashCode().and(0x7fffffff) % M
    fun add(key: K, v: V) {
        var map = hashTable[hash(key)]
        if (map.contains(key)) {
            map[key] = v
        } else {
            map[key] = v
            size++
            if (size >= upperTol.times(M) && capacityIndex + 1 < capacity.size) {
                capacityIndex++
                resize(capacity[capacityIndex])
            }
        }
    }

    private fun resize(newM: Int) {
        var newHash = Array<TreeMap<K, V>>(newM, init = {
            TreeMap()
        })
        var oldM = M
        this.M = newM
        for (i in 0 until oldM) {
            var map = hashTable[i]
            map.keys.forEach {
                newHash[hash(it)][it] = map[it] as V
            }
        }
        this.hashTable = newHash
    }

    fun remove(key: K): V? {
        var map = hashTable[hash(key)]
        var ret: V? = null
        if (map.contains(key)) {
            ret = map.remove(key)
            size--
            if (size < lowerTol.times(M) &&  capacityIndex - 1 >= 0) {
                capacityIndex
                resize(capacity[capacityIndex])
            }
        }
        return ret
    }

    fun set(key: K, v: V) {
        val map = hashTable[hash(key)]
        if (!map.contains(key)) {
            throw IllegalArgumentException("$key 不存在，你搞什么？")
        }
        map[key] = v
    }

    fun contains(key: K) = hashTable[hash(key)].contains(key)

    fun get(key: K) = hashTable[hash(key)].get(key)
}

fun main() {
    var list = Utils.readFile("F:\\workspace\\web\\data-structure\\Array\\src\\pride.txt")
    var start = System.nanoTime()
    var avlTree = HashTable<String, Int>()
    list.forEach {
        if (avlTree.contains(it)) {
            avlTree.set(it, 1.minus(avlTree.get(it) ?: 0))
        } else {
            avlTree.add(it, 1)
        }
    }
    for (s in list) {
        avlTree.contains(s)
    }
    var end = System.nanoTime()
    println("HashTable :${(end - start).div(100000000.0)}s")
}