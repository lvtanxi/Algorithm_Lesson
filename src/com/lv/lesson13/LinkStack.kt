package com.lv.lesson13

/**
 * Date: 2017-04-27
 * Time: 16:08
 * Description: 模拟栈
 */
class LinkStack {
    private val linkList: PLinkList = PLinkList()

    fun push(dd: Int) = linkList.insterFirst(dd)

    fun pop() = linkList.deleteFirst()

    fun isEmpty() = linkList.isEmpty()

    fun display() = linkList.display()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val linkStack = LinkStack()
            linkStack.push(1)
            linkStack.push(2)
            linkStack.push(3)
            linkStack.push(4)
            linkStack.display()
            linkStack.push(8)
            linkStack.display()
            linkStack.pop()
            linkStack.pop()
            linkStack.display()
        }
    }

}