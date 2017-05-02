package com.lv.lesson17

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Date: 2017-05-02
 * Time: 14:37
 * Description:
 */
object Factorial {
    @JvmStatic
    fun main(args: Array<String>) {
        val num = getNum()
        val factorial = factorial(num)
        println(factorial)
    }

    private fun factorial(num: Int): Int {
        if(num==0)
            return 1
        return num.times(factorial(num.minus(1)))
    }


    fun getNum(): Int {
        println("请输入一个数字：")
        val reader = BufferedReader(InputStreamReader(System.`in`))
        val readLine = reader.readLine()
        return readLine.toInt()
    }
}