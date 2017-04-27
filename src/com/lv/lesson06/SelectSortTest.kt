package com.lv.lesson06

import com.lv.util.outPut

/**
 * Date: 2017-04-24
 * Time: 17:05
 * Description: 选择排序
 */
object SelectSortTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val arrayOf = intArrayOf(1, 3, 2, 45, 65, 33, 12)
        arrayOf.outPut()
        selectSort(arrayOf)
        arrayOf.outPut()
    }

    fun selectSort(array: IntArray) {
        var min: Int
        var temp: Int
        for (out in 0..array.lastIndex) {
            min = out
            //第二个循环是找出第out+1位到最后的最小值
            (min.plus(1)..array.lastIndex)
                    .asSequence()
                    .filter { array[it] < array[min] }
                    .forEach { min = it }
            if (out != min) {
                temp = array[out]
                array[out] = array[min]
                array[min] = temp
            }
        }
    }
}