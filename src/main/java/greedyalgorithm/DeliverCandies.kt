package greedyalgorithm

class DeliverCandies {

    fun candy(ratings: Array<Int>): Int {
        val candiesArray: IntArray = IntArray(ratings.size)
        candiesArray[0] = 1
        for (i in 1 until ratings.size){
            if (ratings[i]>ratings[i-1]){
                candiesArray[i] = candiesArray[i-1]+1
            }else{
                candiesArray[i] = 1
            }
        }
        var i = ratings.size -2
        while (i>=0){
            if (ratings[i]>ratings[i+1]){
                candiesArray[i] = Math.max(candiesArray[i],candiesArray[i+1]+1)
            }
            i--
        }
        return candiesArray.sum()
    }
}

fun main() {
   val result=  DeliverCandies().candy(arrayOf(1,0,2))
    print(result)
}