package com.lv.lesson08

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Date: 2017-04-25
 * Time: 15:31
 * Description: 利用栈反转字符串
 */
class StackW {
    private val stackArray: ArrayList<Char> = ArrayList()

    fun push(char: Char) = stackArray.add(char)

    fun pop() = stackArray.removeAt(stackArray.lastIndex)

    fun peek() = stackArray[stackArray.lastIndex]

    fun isEmpty() = stackArray.isEmpty()

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("亲，请输入您想反转的字符串：")
            val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
            val input = bufferedReader.readLine()
            if (input.isEmpty())
                return
            val stackW = StackW()
            val sb = StringBuilder()
            for (c in input.toCharArray()) {
                stackW.push(c)
            }
            while (!stackW.isEmpty()) {
                sb.append(stackW.pop())
            }
            println("这是我写的：$sb")
            println("这是原生的：${input.reversed()}")
        }
    }

}