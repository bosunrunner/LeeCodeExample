package greedyalgorithm

class MaxSubArray {
    fun maxSubArray(nums: IntArray): Int {
        // 贪心算法
        var result = Int.MIN_VALUE
        if (nums.size==1){
            return nums[0]
        }
        var count = 0
        var i = 0
        while (i<nums.size){
            count+=nums[i]
            if (result<count){
                result = count
            }
            if (count<0){
                count =0
            }
            i++
        }
        return result
    }
}