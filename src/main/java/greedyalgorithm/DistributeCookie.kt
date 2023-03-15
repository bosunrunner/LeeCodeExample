package greedyalgorithm

class DistributeCookie {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        // 贪心算法
        g.sort()
        s.sort()
        var result = 0
        var index = s.size -1
        for (i in g.indices.reversed()){
            if (index>=0 && s[index]>=g[i]){
                result ++
                index --
            }
        }
        return result
    }
}