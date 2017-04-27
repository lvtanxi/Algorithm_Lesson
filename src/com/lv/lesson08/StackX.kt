package com.lv.lesson08

/**
 * Date: 2017-04-25
 * Time: 14:56
 * Description: 栈模拟
 */
class StackX {
    //模拟木桶
    private val stackArray: ArrayList<Int> = ArrayList()

    //添加元素
    fun push(value: Int) {
        if (!isFull())//如果满了就不添加了
            stackArray.add(value)
    }

    //弹出最后一个
    fun pop() = stackArray.removeAt(stackArray.lastIndex)

    //查看最后一个
    fun peek() = stackArray[stackArray.lastIndex]

    //是否为空
    fun isEmpty() = stackArray.isEmpty()

    //是否满了
    fun isFull() = stackArray.size > 30

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val stackX = StackX()
            stackX.push(20)
            stackX.push(40)
            stackX.push(60)
            stackX.push(80)
            while (!stackX.isEmpty()) {
                val pop = stackX.pop()
                println(pop)
            }
            println("是否空了${stackX.isEmpty()}")
            println("是否满了${stackX.isFull()}")
            stackX.push(10)
            stackX.push(30)
            println("查看${stackX.peek()}")
        }
    }

}