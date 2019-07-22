package leetcode

import java.util.*

class Solution804 {
    fun uniqueMorseRepresentations(words: Array<String>): Int {
        var strs = arrayOf(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..")
        var set = TreeSet<String>()
        words.iterator().forEach {
            set.add(buildString {
                it.iterator().forEach {
                    append(strs[it - 'a'])
                }
            })
        }
        return set.size
    }
}

fun main() {
  println(Solution804().uniqueMorseRepresentations(arrayOf( "gin", "zen", "gig", "msg")))
}