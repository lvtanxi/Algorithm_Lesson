package com.lv.lesson17

import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Date: 2017-05-02
 * Time: 14:57
 * Description: 变位字
 */
object AngramApp {
    var size: Int = 0
    var count: Int = 0
    var arrayChar = CharArray(0)
    @JvmStatic
    fun main(args: Array<String>) {
        val input = getInputString()
        size = input.length
        arrayChar = input.toCharArray()
        doAngram(arrayChar.lastIndex)
    }

    //变位颠倒
    fun doAngram(newSize: Int) {
        if (newSize <= 1)
            return
        for (index in 0..newSize) {
            doAngram(newSize.minus(1))
            if (newSize==2)
                displayWord()
            rotate(newSize)
        }
    }

    private fun rotate(newSize: Int) {
        val position = size.minus(newSize)
        val temp = arrayChar[position]
        for (index in position.plus(1)..arrayChar.lastIndex) {
            arrayChar[index.minus(1)] = arrayChar[index]
        }
        arrayChar[arrayChar.lastIndex] = temp
    }

    private fun displayWord() {
        if(count < 9)
            print(" ")
        if (count < 99)
            print("  ")
        print("${++count}  ")

        arrayChar.forEach(::print)
        print("   ")
        if(count.rem(6)==0)
            println()
    }


    fun getInputString(): String {
        println("请输入一个字符串：")
        val reader = BufferedReader(InputStreamReader(System.`in`))
        return reader.readLine()
    }
}