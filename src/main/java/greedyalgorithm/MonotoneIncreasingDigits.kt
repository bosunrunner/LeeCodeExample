package greedyalgorithm

import java.lang.String
import java.util.*
import kotlin.Int

class MonotoneIncreasingDigits {
    fun monotoneIncreasingDigits(N: Int): Int {
        val charArray = N.toString().toCharArray()
        val strings = Array(charArray.size){i -> charArray[i].toString() }
        var start = strings.size
        for (i in strings.size - 1 downTo 1) {

            if (strings[i].toInt() < strings[i - 1].toInt()) {
                strings[i - 1] = (strings[i - 1].toInt() - 1).toString() + ""
                start = i
            }
        }
        for (i in start until strings.size) {
            strings[i] = "9"
        }
        return String.join("", *strings).toInt()
    }
}

fun main() {
    print(MonotoneIncreasingDigits().monotoneIncreasingDigits(332))
}