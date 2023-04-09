package greedyalgorithm

import kotlin.math.max

class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith(compareBy { it[0] })
        val result = mutableListOf<IntArray>()
        result.add(intervals[0])
        for (i in 1 until intervals.size) {
            if (intervals[i][0] <= result[result.size-1][1]) {
                result[result.size-1][1] = Math.max(intervals[i][1], result[result.size-1][1])
            } else {
                result.add(intervals[i])
            }
        }
        return result.toTypedArray()

    }
}

fun main() {
    MergeIntervals().merge(arrayOf(intArrayOf(1,3), intArrayOf(2,6), intArrayOf(8,10), intArrayOf(15,18)))
}