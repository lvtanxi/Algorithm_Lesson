package com.lv.lesson14

/**
 * Date: 2017-04-28
 * Time: 14:16
 * Description: 有序链表节点
 */
data class OrderLink(var dData: Int, var next: OrderLink? = null) {
    fun display(){
        print("$dData ")
    }
}