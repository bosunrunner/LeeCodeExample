package greedyalgorithm

import kotlin.math.cos

class CanCompleteCircuit {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        // 贪心算法
        var currentConsume = 0
        var totalConsume = 0
        var startIndex = 0
        for (i in gas.indices) {
            totalConsume +=gas[i]- cost[i]
            currentConsume+=gas[i]-cost[i]
            if (currentConsume<0){
                startIndex = i+1
                currentConsume =0
            }
        }
        if (totalConsume<0) return -1
        return startIndex
    }

}