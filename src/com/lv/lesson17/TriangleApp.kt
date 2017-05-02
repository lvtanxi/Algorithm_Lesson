package com.lv.lesson17

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Date: 2017-05-02
 * Time: 13:59
 * Description: 递归 阶乘
 */
object TriangleApp {
    @JvmStatic
    fun main(args: Array<String>) {
        var num = getNum()
        num = triangle(num)
        println(num)
        multiplicationTable(9)
    }

    fun triangle(num: Int): Int {
        if (num == 1)
            return 1
        return num.plus(triangle(num.minus(1)))
    }

    fun multiplicationTable(num: Int) {
        if (num == 1) {
            println("1 * 1 = 1")
        } else {
            val sp = StringBuilder()
            (1..num).forEach {
                sp.setLength(0)
                sp.append("$it * $num = ${it * num} ")
                if (sp.length < 11)
                    sp.append(" ")
                print(sp)
            }
            println()
            multiplicationTable(num.minus(1))
        }
    }


    fun getNum(): Int {
        println("请输入一个数字：")
        val reader = BufferedReader(InputStreamReader(System.`in`))
        val readLine = reader.readLine()
        return readLine.toInt()
    }
}