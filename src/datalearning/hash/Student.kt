package datalearning.hash

import java.util.*

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/31 15:48
 */
class Student(var grade: Int, var cls: Int, var firstName: String, var lastName: String) {
    override fun hashCode(): Int {
        var B = 31
        var hash = 0
        hash = hash.times(B).plus(grade)
        hash = hash.times(B).plus(cls)
        hash = hash.times(B).plus(firstName.hashCode())
        hash = hash.times(B).plus(lastName.hashCode())
        return hash
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null) {
            return false
        }
        if (javaClass != other.javaClass) {
            return false
        }
        var another = other as Student
        return this.grade == another.grade
                && this.cls == another.cls
                && this.firstName == another.firstName
                && this.lastName == another.lastName
    }
}

fun main() {
    var student = Student(1, 1, "a", "b")
    println(student.hashCode())
    var student2 = Student(1, 1, "a", "b")
    println(student2.hashCode())
    var hashSet = HashSet<Student>()
    hashSet.add(student)
    hashSet.add(student2)
    println(hashSet.size)
}