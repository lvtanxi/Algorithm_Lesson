package com.lv.lesson16

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Date: 2017-05-02
 * Time: 10:32
 * Description: 迭代器
 */
class ILinkList(var first: ILink? = null) {

    fun getFisrt() = first

    fun setFirstData(link: ILink?) {
        first = link
    }

    fun isEmpty() = first == null

    fun display() {
        var current = first
        while (current != null) {
            current.display()
            current = current.next
        }
        println()
    }

    fun getIterator() = LinkIterator(this)

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val iLinkList = ILinkList()
            val iterator = iLinkList.getIterator()
            iterator.insertAfter(20)
            iterator.insertAfter(40)
            iterator.insertAfter(80)
            iterator.insertBefore(60)
            var flag = true
            //s:显示链表内容，r:重置.n:移动到下一个节点,g:获取当前节点,b:在当前节点前插入,a:在当前节点之后插入,d:删除当前节点
            while (flag) {
                println("亲，请输入中缀字符串：")
                val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
                val input = bufferedReader.readLine()
                if (input.isEmpty())
                    return
                when (input) {
                    "s" -> iLinkList.display()
                    "r" -> iterator.reset()
                    "n" -> iterator.nextLink()
                    "g" -> iterator.getCurrentLink()
                    "b" -> iterator.insertBefore(100)
                    "a" -> iterator.insertAfter(200)
                    "d" -> iterator.deleteCurrent()
                    "e" -> flag = false
                }
            }
        }
    }

}

class LinkIterator(val linkList: ILinkList, var current: ILink? = null, var previous: ILink? = null) {
    init {
        reset()
    }

    fun reset() {
        current = linkList.getFisrt()
        previous = null
    }

    fun isEnd() = current?.next == null

    fun nextLink() {
        if(linkList.isEmpty()||isEnd())
            return
        previous = current
        current = current?.next
    }

    fun getCurrentLink() = current
    /**
     * 在迭代器正在访问的节点之后插入一个新节点
     */
    fun insertAfter(dd: Int) {
        val iLink = ILink(dd)
        if (linkList.isEmpty()) {
            linkList.setFirstData(iLink)
            current = iLink
        } else {
            iLink.next = current?.next
            current?.next = iLink
            nextLink()
        }
    }

    /**
     * 在迭代器正在访问的节点之前插入一个新节点
     */
    fun insertBefore(dd: Int) {
        val iLink = ILink(dd)
        if (previous == null) {
            iLink.next = linkList.getFisrt()
            linkList.setFirstData(iLink)
            reset()
        } else {
            iLink.next = previous?.next
            previous?.next = iLink
            current = iLink
        }
    }

    fun deleteCurrent() {
        if (current == null)
            return
        if (previous == null) {
            linkList.setFirstData(current?.next)
            reset()
        } else {
            previous?.next = current?.next
            if (isEnd())
                reset()
            else
                current = current?.next
        }
    }
}
