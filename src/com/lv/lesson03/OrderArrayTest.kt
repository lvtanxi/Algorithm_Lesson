package com.lv.lesson03

/**
 * Date: 2017-04-24
 * Time: 10:32
 * Description: 二分查找
 */
object OrderArrayTest {
    @JvmStatic
    fun main(args: Array<String>) {
        //初始化数组
        val orderArray = IntArray(20)
        for (item in 0..19) {
            orderArray[item] = item
        }
        val binarySearch = binarySearch(orderArray, 1)
        println(binarySearch)
        println(binarySearchDef(orderArray,19))
    }

    /**
     * 不带递归的查找方式
     */
    fun binarySearch(array: IntArray, vaule: Int): Int {
        var low = 0
        var high = array.lastIndex
        var middle: Int
        while (low <= high) {
            middle = (low.plus(high)).div(2)
            if (vaule == array[middle])
                return middle
            else if (vaule < array[middle])
                high = middle - 1
            else
                low = middle + 1
        }
        return -1
    }

    /**
     * 递归的查找方式
     */
    fun binarySearch(array: IntArray, vaule: Int, beginIndex: Int, endIndex: Int): Int {
        val midIndex = (beginIndex.plus(endIndex)).div(2)
        if (vaule < array[beginIndex] || vaule > array[endIndex] || beginIndex > endIndex)
            return -1
        if (vaule < array[midIndex])
            return binarySearch(array, vaule, beginIndex, midIndex - 1)
        else if (vaule > array[midIndex])
            return binarySearch(array, vaule, midIndex + 1, endIndex)
        else
            return midIndex
    }

    /**
     * 默认递归的查找方式
     */
    fun binarySearchDef(array: IntArray, vaule: Int): Int {
        return binarySearch(array, vaule, 0, array.lastIndex)
    }

}