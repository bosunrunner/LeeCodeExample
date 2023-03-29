package greedyalgorithm


class CanJumpII {

    fun jump(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        // 贪心算法 中心思想：走一步要看两步
        var currentStep = 0
        var nextStep = 0
        var result = 0

        for (i in nums.indices) {
            nextStep = Math.max(i + nums[i], nextStep)

            if (i == currentStep) {
                if (currentStep != nums.size - 1) {
                    result++
                    currentStep = nextStep
                    if (currentStep >= nums.size - 1) break
                } else break

            }
        }
        return result
    }
}