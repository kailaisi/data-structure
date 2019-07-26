import java.io.File

/**
 *描述：
 *<p/>作者：wu
 *<br/>创建时间：2019/7/25 17:40
 */
object Utils {
    fun readFile(name: String): List<String> {
        var text = File(name).readText()
        return text.split(" ")
    }
}
