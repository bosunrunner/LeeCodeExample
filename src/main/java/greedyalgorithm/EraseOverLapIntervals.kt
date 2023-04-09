package greedyalgorithm

class EraseOverLapIntervals {

    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0
        intervals.sortWith(compareBy { it[0] })
        var result = 1
        for (i in 1 until intervals.size) {
            if (intervals[i][0] >= intervals[i - 1][1]) {
                result++
            } else {
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1])
            }
        }
        return intervals.size - result
    }
}