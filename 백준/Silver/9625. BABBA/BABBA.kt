import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val K = readLine().toInt()
    var tmp: Long
    var A: Long = 0
    var B: Long = 1
    for (i in 2..K) {
        tmp = B
        B += A
        A = tmp
    }
    println("$A $B")
}