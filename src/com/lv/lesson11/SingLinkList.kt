package com.lv.lesson11

/**
 * Date: 2017-04-27
 * Time: 09:50
 * Description: 单向链表
 */
data class SingLinkList(var first: SingLink? = null) {
    //插入数据
    fun insertFirst(id: Int, dd: Double) {
        first = SingLink(id, dd, first)
    }
    //删除第一个数据
    fun deteleFirst(): SingLink? {
        val temp = first
        first = first?.next
        return temp
    }
    //根据key查找数据
    fun find(key: Int): SingLink? {
        var current = first
        if (current != null) {
            while (current!!.iData != key) {
                if (current.next != null)
                    current = current.next
                else
                    return null
            }
        }
        return current
    }

    fun delete(key: Int): SingLink? {
        var current = first
        var previous = first
        while (current != null) {
            if (current.iData == key)
                break
            previous = current
            current = current.next
        }
        previous?.next = current?.next
        return current
    }


    fun dispalyList() {
        var current = first
        if (current != null) {
            while (current!!.next != null) {
                println(current.toString())
                current = current.next
            }
        }
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val linkList = SingLinkList()
            linkList.insertFirst(1, 2.2)
            linkList.insertFirst(2, 4.4)
            linkList.insertFirst(3, 6.6)
            linkList.insertFirst(4, 8.8)
            linkList.dispalyList()
            val link = linkList.delete(3)
            println(link?.toString())
            linkList.dispalyList()
            val link2 = linkList.deteleFirst()
            println(link2?.toString())
            linkList.dispalyList()
            val find = linkList.find(2)
            println(find?.toString())
        }
    }
}