package com.lv.lesson13

/**
 * Date: 2017-04-27
 * Time: 16:15
 * Description: 双端链表
 */
class PFirstLastList {
    var first: PLink? = null
    var last: PLink? = null

    fun isEmpty() = first == null

    fun push(dd: Int) {
        val pLink = PLink(dd)
        if (isEmpty())
            first = pLink
        else
            last?.next = pLink
        last = pLink
    }

    fun pop(): Int? {
        val temp = first?.dData
        if (first?.next == null)
            last = null
        first = first?.next
        return temp
    }

    fun dispaly() {
        var current = first
        while (current != null) {
            current.dispalyLink()
            current = current.next
        }
        println()
    }

}