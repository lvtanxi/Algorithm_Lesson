package com.lv.lesson09

import com.lv.util.outPut

/**
 * Date: 2017-04-25
 * Time: 16:49
 * Description: 模拟队列
 */
class Queue {
    //队列缓存区
    private val queArray: ArrayList<Int> = ArrayList()
    //添加
    fun push(value: Int) = queArray.add(value)
    //删除
    fun pop() = queArray.removeAt(0)
    //查看
    fun outPut()=queArray.outPut()

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val queue = Queue()
            queue.push(10)
            queue.push(20)
            queue.push(30)
            queue.push(40)
            println("删除了${queue.pop()}")
            println("删除了${queue.pop()}")
            println("删除了${queue.pop()}")
            queue.push(50)
            queue.push(60)
            queue.push(70)
            queue.push(80)
            queue.push(90)
           queue.outPut()
        }
    }

}