package com.lv.lesson17

/**
 * Date: 2017-05-02
 * Time: 17:06
 * Description: 汉诺塔
 */
object Towers {
    @JvmStatic
    fun main(args: Array<String>) {
        val currentTimeMillis = System.currentTimeMillis()
        doTower(3,'A','B','C')
        println(System.currentTimeMillis().minus(currentTimeMillis))
    }

    fun doTower(topN:Int,from:Char,inter:Char,to:Char){
        if (topN==1) {
            println("Disk 1 from $from to $to")
        }else{
            doTower(topN.minus(1),from,to,inter)
            println("Disk $topN from $from to $to")
            doTower(topN.minus(1),inter,from,to)
        }
    }

}