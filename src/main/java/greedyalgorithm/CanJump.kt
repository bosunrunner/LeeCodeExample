package greedyalgorithm

class CanJump {
    fun canJump(nums: IntArray): Boolean {
        if (nums.size == 1) {
            return true
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        var coverRange = 0
        //在覆盖范围内更新最大的覆盖范围
        var i = 0
        while (i<=coverRange){
            coverRange = Math.max(coverRange,i+nums[i])
            if (coverRange>=nums.size-1) return true
            i++
        }
        return false
    }

}