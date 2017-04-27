package com.lv.lesson12

/**
 * Date: 2017-04-27
 * Time: 13:53
 * Description: 双端链表节点
 */
// 双端链表节点
data class DLink(var dData: Int, var next: DLink? = null) {
    fun dispalyLink(){
        print("$dData  ")
    }
}