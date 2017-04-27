package com.lv.lesson12

/**
 * Date: 2017-04-27
 * Time: 13:56
 * Description: 双端链表
 */
//申明两个链节点来存储第一个和最后一个连接点
data class FirstLastLink(var first: DLink? = null, var last: DLink? = null) {
    //判断链表是否为空
    fun isEmpty() = first == null
    //在依次插入新数据
    fun insertFirst(dd: Int) {
        val dLink = DLink(dd)
        //如果为空的话，这说明第一个链节点也是最后一个链节点
        if (isEmpty())
            last = dLink
        //这是新的第一个节点
        dLink.next = first
        first = dLink
    }
    //在末尾插入数据
    fun insertLast(dd: Int) {
        val dLink = DLink(dd)
        //如果为空的话，这说明最后一个链节点也是第一个链节点
        if (isEmpty())
            first = dLink
        else
            last?.next = dLink
        //这是新的最后一个节点
        last = dLink
    }

    fun deleteFirst(): Int? {
        val temp = first?.dData
        if (first?.next == null)
            last = null
        first = first?.next
        return temp
    }

    fun dispalyList() {
        var current = first
        while (current != null) {
            current.dispalyLink()
            current = current.next
        }
        println()
    }
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val firstLastLink = FirstLastLink()
            firstLastLink.insertFirst(12)
            firstLastLink.insertFirst(13)
            firstLastLink.insertFirst(14)
            firstLastLink.insertLast(15)
            firstLastLink.last?.dispalyLink()
            println()
            firstLastLink.dispalyList()
            val deleteFirst = firstLastLink.deleteFirst()
            println(deleteFirst)
            firstLastLink.dispalyList()
        }
    }

}