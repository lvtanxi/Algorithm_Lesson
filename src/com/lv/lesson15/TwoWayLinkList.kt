package com.lv.lesson15

/**
 * Date: 2017-05-02
 * Time: 09:23
 * Description: 双向链表
 */
class TwoWayLinkList(var first: TwoWayLink? = null, var last: TwoWayLink? = null) {
    fun isEmpty() = first == null
    /**
     * 从头部插入
     */
    fun pushFirst(dd: Int) {
        val link = TwoWayLink(dd,next = first)
        if (isEmpty())
            last = link
        else
            first?.previous = link
        first = link
    }

    /**
     * 从尾部插入
     */
    fun pushLast(dd: Int) {
        val link = TwoWayLink(dd)
        if (isEmpty()) {
            first = link
        } else {
            last?.next = link
            link.previous = last
        }
        last = link
    }

    /**
     * 根据位置插入数据
     */
    fun pushAfter(key: Int, dd: Int): Boolean {
        var current = first
        while (current?.dData != key) {
            current = current?.next
            if (current == null)
                return false
        }
        val link = TwoWayLink(dd)
        if (current == last) {
            link.next = null
            last = link
        } else {
            link.next = current.next
            current.next?.previous = link
        }
        link.previous = current
        current.next = link
        return true
    }

    /**
     * 根据key删除数据
     */
    fun deleteByKey(key: Int): TwoWayLink? {
        var current = first
        while (current?.dData != key) {
            current = current?.next
            if (current == null)
                return null
        }
        if (current == first)
            first = current.next
        else
            current.previous?.next = current.next

        if (current == last)
            last = current.previous
        else
            current.next?.previous = current.previous
        return current
    }

    /**
     * 从前向后显示
     */
    fun displayForward() {
        var current = first
        while (current != null) {
            current.display()
            current = current.next
        }
        println()
    }

    /**
     * 从后向前显示
     */
    fun displayBackward() {
        var current = last
        while (current != null) {
            current.display()
            current = current.previous
        }
        println()
    }


    /**
     * 从头部删除元素
     */
    fun deleteFirst(): TwoWayLink? {
        if (isEmpty())
            return null
        val temp = first
        if (first?.next == null)
            last = null
        else
            first?.next?.previous = null
        first = first?.next
        return temp
    }

    /**
     * 从尾部删除元素
     */
    fun deleteLast(): TwoWayLink? {
        if (isEmpty())
            return null
        val temp = last
        if (first?.next == null)
            first = null
        else
            last?.previous?.next = null
        last = last?.previous
        return temp
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val linkList = TwoWayLinkList()
            linkList.pushFirst(22)
            linkList.pushFirst(44)
            linkList.pushFirst(66)

            linkList.pushLast(11)
            linkList.pushLast(33)
            linkList.pushLast(55)
            linkList.displayForward()
            linkList.displayBackward()

            linkList.deleteFirst()
            linkList.displayForward()
            linkList.deleteLast()
            linkList.displayForward()
            linkList.deleteByKey(11)
            linkList.displayForward()
            linkList.pushAfter(22,88)
            linkList.displayForward()
        }
    }
}