package com.lv.lesson07

import com.lv.util.outPut

/**
 * Date: 2017-04-25
 * Time: 11:20
 * Description:插入排序  交换
 */
object InsertSort {
    @JvmStatic
    fun main(args: Array<String>) {
        val arrayOf = intArrayOf(1, 3, 2, 45, 65, 33, 12)
        arrayOf.outPut()
        insertSort(arrayOf)
        arrayOf.outPut()
    }

    fun insertSort(array: IntArray) {
        var temp: Int
        var tagIndex: Int
        //这里的下标从1开始，因为默认取出一个
        for (i in 1..array.lastIndex) {
            temp = array[i]
            tagIndex = i
            //这里是从向前取数，有点倒叙的意思
            while (tagIndex > 0 && array[tagIndex - 1] >= temp) {
                array[tagIndex] = array[tagIndex - 1]
                tagIndex--
            }
            array[tagIndex] = temp
        }
    }
}