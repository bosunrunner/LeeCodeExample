package greedyalgorithm

class FindMinArrowShots {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortWith(compareBy { it[0] })
        if (points.isEmpty()) return 0
        var result = 1
        for (i in 1 until points.size) {
            if (points[i][0] > points[i - 1][1]) {
                result++
            } else {
                points[i][1] = Math.min(points[i][1], points[i - 1][1])
            }
        }
        return result
    }
}