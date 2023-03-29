package greedyalgorithm

import kotlin.math.abs

class LargestNumAfterKNegations {

    fun largestSumAfterKNegations(nums: IntArray, k: Int): Int {
        // 贪心算法
        val tempNUms = nums.sortedWith { o1: Int, o2: Int -> abs(o2) - abs(o1) }.toIntArray()
        var K = k
        for (i in tempNUms.indices) {
            if (tempNUms[i] < 0 && K > 0) {
                tempNUms[i] *= -1
                K--
            }
        }
        if (k % 2 == 1) tempNUms[tempNUms.size - 1] *= -1

        return tempNUms.sum()

    }

}

fun main() {
    val result = LargestNumAfterKNegations().largestSumAfterKNegations(intArrayOf(4,2,3),1)
    print(result)
}