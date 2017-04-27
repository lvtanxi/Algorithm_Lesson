package com.lv.lesson13

/**
 * Date: 2017-04-27
 * Time: 16:22
 * Description: 模拟队列
 */
class LinkQueue {
    private val theList: PFirstLastList = PFirstLastList()

    fun push(dd: Int) = theList.push(dd)

    fun pop() = theList.pop()

    fun display() = theList.dispaly()

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val linkQueue = LinkQueue()
            linkQueue.push(1)
            linkQueue.push(2)
            linkQueue.push(3)
            linkQueue.push(4)
            linkQueue.display()
            linkQueue.push(5)
            linkQueue.display()
            linkQueue.pop()
            linkQueue.display()
        }
    }
}