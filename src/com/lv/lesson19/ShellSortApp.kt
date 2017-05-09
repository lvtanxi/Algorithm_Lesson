package com.lv.lesson19

import com.lv.util.outPut
import java.util.*

/**
 * Date: 2017-05-08
 * Time: 16:00
 * Description: 希尔排序
 */
class ShellSortApp {
    private val theArray = ArrayList<Int>()

    fun insert(value: Int) = theArray.add(value)

    fun display() = theArray.outPut()

    fun shellSort() {
        //比较数字的下标
        var inner: Int
        var temp: Int
        var h = 1 //比较间隔,一般情况是总长度的1/3+1
        while (h <= (theArray.size.div(3))) {
            h = h.times(3).plus(1)//计算最大间隔
        }
        //循环间隔进行间隔有序排序
        while (h > 0) {
            //进行间隔排序
            for (index in h..theArray.lastIndex) {
                temp = theArray[index]
                inner = index
                while ((inner > h - 1) && (theArray[inner - h] >= temp)) {
                    theArray[index] = theArray[inner - h]
                    inner -= h
                }
                theArray[inner] = temp
            }
            h = (h.minus(1)).div(3)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val shellSortApp = ShellSortApp()
            var index = 0
            val random = Random()
            var nextInt: Int
            while (index < 100) {
                nextInt = random.nextInt(500)
                if (!shellSortApp.theArray.contains(nextInt)) {
                    shellSortApp.insert(nextInt)
                    index++
                }
            }
            shellSortApp.display()
            shellSortApp.shellSort()
            shellSortApp.display()
        }
    }
}