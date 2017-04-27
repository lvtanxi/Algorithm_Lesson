package com.lv.lesson09

import com.lv.util.outPut

/**
 * Date: 2017-04-26
 * Time: 10:55
 * Description: 优先级队列
 */
class PriorityQueue {
    private val queArray: ArrayList<Int> = ArrayList()

    fun insert(item: Int) {
        val index = findIndex(item)
        queArray.add(index, item)
        queArray.outPut()
    }

    fun pop() = queArray.removeAt(queArray.lastIndex)

    fun outPut()=queArray.outPut()

    //需找插入的位置
    private fun findIndex(item: Int): Int {
        queArray.withIndex().forEach {
            if (it.value < item)
                return it.index
        }
        return queArray.lastIndex + 1
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val priorityQueue = PriorityQueue()
            priorityQueue.insert(9)
            priorityQueue.insert(8)
            priorityQueue.insert(5)
            priorityQueue.insert(6)
            priorityQueue.insert(7)
            priorityQueue.pop()
            priorityQueue.outPut()
        }
    }
}