package com.lv.lesson15

/**
 * Date: 2017-05-02
 * Time: 09:20
 * Description: 双向链表节点
 */
data class TwoWayLink(var dData: Int, var next: TwoWayLink? = null, var previous: TwoWayLink? = null) {
    fun display() {
        print("$dData  ")
    }
}