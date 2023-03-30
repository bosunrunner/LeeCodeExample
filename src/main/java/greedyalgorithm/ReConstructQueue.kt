package greedyalgorithm

class ReConstructQueue {

    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        people.sortWith(compareBy({-it[0]},{it[1]}))

//        for (i in people.indices){
//            println("${people[i][0]}:${people[i][1]}")
//        }
//        return people
        val list = mutableListOf<IntArray>()
        for (i in people.indices){
            list.add(people[i][1],people[i])
        }
        return list.toTypedArray()

    }
}

fun main() {
    ReConstructQueue().reconstructQueue(arrayOf(intArrayOf(7,0),intArrayOf(4,4),intArrayOf(7,1),intArrayOf(5,0),intArrayOf(6,1),intArrayOf(5,2)))
}