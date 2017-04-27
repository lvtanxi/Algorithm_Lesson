package com.lv.lesson05

import com.lv.util.outPut

/**
 * Date: 2017-04-24
 * Time: 15:20
 * Description: 冒泡排序
 */
object BubbleSortTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val arrayOf = intArrayOf(49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51)
        arrayOf.outPut()
        bubbleSort(arrayOf)
        arrayOf.outPut()
    }

    fun bubbleSort(array: IntArray) {
        var temp:Int
        for (i in 0..array.lastIndex) {
            for (j in 0..array.lastIndex - i-1) {
                if (array[j] > array[j + 1]) {
                    temp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = temp
                }
            }
        }
    }
}