package greedyalgorithm

class LemonadeChange {
    fun lemonadeChange(bills: IntArray): Boolean {
        var fiveNum = 0
        var tenNum = 0
        var twentyNum = 0
        for (i in bills.indices){
            when(bills[i]){
                5 ->{
                    fiveNum++
                }
                10 ->{
                    if (fiveNum>0){
                        fiveNum--
                        tenNum++
                    }else{
                        return false
                    }
                }
                20 ->{
                    if (tenNum>0&&fiveNum>0){
                        tenNum--
                        fiveNum++
                    }else if (fiveNum>=3){
                        fiveNum-=3
                    }else{
                        return false
                    }
                }
            }
        }
        return true
    }
}