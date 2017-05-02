package com.lv.lesson17

import com.lv.util.outPut
import java.util.*

/**
 * Date: 2017-05-02
 * Time: 16:19
 * Description: 递归二分查找
 */
object BinarySearchApp {
    @JvmStatic
    fun main(args: Array<String>) {
        val orderArray = IntArray(20)
        val random = Random()
        var nextInt: Int
        var index = 0
        while (index < orderArray.lastIndex) {
            nextInt = random.nextInt(100)
            if (!orderArray.contains(nextInt)){
                orderArray[index] = nextInt
                index++
            }
        }
        orderArray.sort()
        orderArray.outPut()
        val binarySearch = binarySearch(orderArray, 14)
        println(binarySearch)
    }

    fun binarySearch(array: IntArray, key: Int): Int {
        return binarySearch(array, key, 0, array.lastIndex)
    }

    fun binarySearch(array: IntArray, key: Int, lowerBound: Int, upperBound: Int): Int {
        if (lowerBound > upperBound)
            return -1
        val curIn = (lowerBound.plus(upperBound)).div(2)
        if (array[curIn] == key)
            return curIn
        else if (array[curIn] < key)
            return binarySearch(array, key, curIn + 1, upperBound)
        else if (array[curIn] > key)
            return binarySearch(array, key, lowerBound, curIn - 1)
        return -1
    }

}