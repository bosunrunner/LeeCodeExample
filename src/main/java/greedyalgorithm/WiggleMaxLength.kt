package greedyalgorithm

class WiggleMaxLength {

    fun wiggleMaxLength(nums: IntArray): Int {
        // 贪心算法
        if (nums.size <= 1) {
            return nums.size
        }
        var result = 1
        var preCiff = 0

        var i = 0
        while (i < nums.size - 1) {
            val currCiff = nums[i + 1] - nums[i]
            if ((preCiff <= 0 && currCiff > 0) || (preCiff >= 0) && currCiff < 0) {
                result++
                preCiff = currCiff
            }
            i++
        }
        return result

    }
}