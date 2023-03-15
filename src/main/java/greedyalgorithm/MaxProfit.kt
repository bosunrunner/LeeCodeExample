package greedyalgorithm

import kotlin.math.max

class MaxProfit {
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        for (i in 1 until prices.size - 1) {
            val tem = prices[i] - prices[i - 1]
            if (tem > 0) {
                result += tem
            }
        }
        return result
    }
}