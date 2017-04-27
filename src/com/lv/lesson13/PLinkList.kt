package com.lv.lesson13

/**
 * Date: 2017-04-27
 * Time: 15:09
 * Description:
 */
data class PLinkList(var first: PLink? = null) {

    fun isEmpty() = first == null

    fun insterFirst(dd: Int) {
        val pLink = PLink(dd, first)
        first = pLink
    }

    fun deleteFirst(): Int? {
        val temp = first
        first = first?.next
        return temp?.dData
    }

    fun display() {
        var current = first
        while (current != null) {
            current.dispalyLink()
            current = current.next
        }
        println()
    }

}