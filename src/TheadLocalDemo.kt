import java.util.Random
import java.util.stream.IntStream

object TheadLocalDemo {

    @JvmStatic
    fun main(args: Array<String>) {
        val stringLocal = object : ThreadLocal<String>() {
            override fun initialValue(): String {//可以进行初始化，防止在未set的时候，直接get导致的空指针崩溃
                return "initValue"
            }
        }
        val intLocal = ThreadLocal<Int>()
        val random = Random()
        IntStream.range(0, 5).forEach { value ->
            Thread {
                intLocal.set(random.nextInt(100))
                println(stringLocal.get())
                println(intLocal.get())
                stringLocal.remove()
            }.start()
        }
    }
}
