package com.lv.lesson10

/**
 * Date: 2017-04-25
 * Time: 14:56
 * Description: 栈模拟并计算后缀表达式
 */
class ArithmeticStackX {
    //模拟木桶
    private val stackArray: ArrayList<Int> = ArrayList()

    //添加元素
    fun push(value: Int) {
        if (!isFull())//如果满了就不添加了
            stackArray.add(value)
    }

    //弹出最后一个
    fun pop() = stackArray.removeAt(stackArray.lastIndex)

    //是否满了
    fun isFull() = stackArray.size > 100

    //计算结果
    fun doPasrse(string: String): Int {
        //零时缓存连续弹出的两个数字以及计算结果
        var num1: Int
        var num2: Int
        var interAns: Int
        //对传进来的后缀字符串进行遍历
        for (ch in string.toCharArray()) {
            //判断是否是数字
            if (ch in '0'..'9') {
                push(ch.toInt().minus('0'.toInt())) //这一步很关键，默认的Char 转Int会变成hashcode对应的值，所以要减去0的hashcode值
            } else {
                num1 = pop()
                num2 = pop()
                //根据运算符号进行计算
                when (ch) {
                    '+' -> interAns = num2.plus(num1)
                    '-' -> interAns = num2.minus(num1)
                    '*' -> interAns = num2.times(num1)
                    '/' -> interAns = num2.div(num1)
                    else -> interAns = 0
                }
                //每次结果要放回去，以便后面再计算
                push(interAns)
            }
        }
        //获取最后计算结果
        return pop()
    }

}