package com.lv.lesson14

import java.util.*
import kotlin.collections.ArrayList

/**
 * Date: 2017-04-28
 * Time: 14:18
 * Description:有序链表
 */
data class OrderLinkList(var first: OrderLink? = null) {

    fun push(orderLink: OrderLink) {
        var previous: OrderLink? = null
        var current = first
        while (current != null && current.dData < orderLink.dData) {
            previous = current
            current = current.next
        }
        if (previous == null) {
            first = orderLink
            return
        }
        previous.next = orderLink
        orderLink.next = current
    }

    fun push(key: Int) {
        push(OrderLink(key))
    }

    fun bindData(array: ArrayList<OrderLink>) {
        first = null
        for (item in array) {
            push(item)
        }
    }


    fun pop(): OrderLink? {
        val temp = first
        first = first?.next
        return temp
    }

    fun display() {
        var current = first
        while (current != null) {
            current.display()
            current = current.next
        }
        println()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val orderLinkList = OrderLinkList()
         /*   orderLinkList.push(1)
            orderLinkList.push(5)
            orderLinkList.push(3)
            orderLinkList.push(2)
            orderLinkList.push(28)
            orderLinkList.display()
            orderLinkList.pop()
            orderLinkList.display()*/
            val random = Random()
            val array = ArrayList<OrderLink>()
            var link:OrderLink
            (0..100).forEach{
                link= OrderLink(random.nextInt(100))
                array.add(link)
            }
            orderLinkList.bindData(array)
            orderLinkList.display()
        }
    }
}