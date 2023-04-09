package greedyalgorithm

class SplitLabels {
    fun partitionLabels(s: String): List<Int> {
        val result = mutableListOf<Int>()
        val maxSub = Array(26) { 0 }
        for (i in s.indices) {
            maxSub[s[i] - 'a'] = i  // 统计字符中每个字符出现的最远位置
        }
        var left = 0
        var right = 0
        for (i in s.indices) {
            right = Math.max(right, maxSub[s[i] - 'a'])
            if (right == i) {
                result.add(right - left + 1)
                left = i + 1
            }
        }
        return result
    }
}