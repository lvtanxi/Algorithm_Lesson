package com.lv.lesson20

import com.lv.util.outPut
import java.util.*

/**
 * Date: 2017-05-09
 * Time: 10:28
 * Description: 快速排序(优化-插入排序+ 三项数据取中)
 */
class ArrayIns3 {
    private val theArray = ArrayList<Int>()

    fun insert(value: Int) = theArray.add(value)

    fun display() = theArray.outPut()


    /**
     * 执行快速排序的方法
     */
    fun recQuickSort(left: Int = 0, right: Int = theArray.lastIndex) {
        if (right.minus(left).plus(1) < 10) {
            insertSort(left, right) //插入排序
            return
        }
        val median = medianOf3(left, right)
        val partition = partition(left, right, median)
        recQuickSort(left, partition - 1)//前一部分递归
        recQuickSort(partition + 1, right)//后一部分抵罪
    }

    /**
     * 三项数据取中
     */
    private fun medianOf3(left: Int, right: Int): Int {
        val center = (left.plus(right)).div(2)
        if (theArray[left] > theArray[center])
            swap(left, center)
        if (theArray[left] > theArray[right])
            swap(left, right)
        if (theArray[center] > theArray[right])
            swap(center, right)
        swap(center, right - 1)
        return theArray[right - 1]
    }

    /**
     * 插入排序
     */
    private fun insertSort(left: Int, right: Int) {
        var inner: Int
        var temp: Int
        for (index in left.plus(1)..right) {
            temp = theArray[index]
            inner = index
            while (inner > left && theArray[inner - 1] >= temp) {
                theArray[inner] = theArray[inner - 1]
                --inner
            }
            theArray[inner] = temp
        }
    }

    /**
     * 划分实现
     */
    private fun partition(left: Int, right: Int, pivot: Int): Int {
        var leftPtr = left
        var rightPtr = right.minus(1)
        while (true) {
            while (theArray[++leftPtr] < pivot) {
            }
            while (theArray[--rightPtr] > pivot) {
            }
            if (leftPtr >= rightPtr)
                break
            swap(leftPtr, rightPtr)
        }
        swap(leftPtr, right - 1)
        return leftPtr
    }

    private fun swap(dex1: Int, dex2: Int) {
        val temp = theArray[dex1]
        theArray[dex1] = theArray[dex2]
        theArray[dex2] = temp
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arrayPar = ArrayIns3()
            var index = 0
            val random = Random()
            var nextInt: Int
            while (index < 26) {
                nextInt = random.nextInt(200)
                if (!arrayPar.theArray.contains(nextInt)) {
                    arrayPar.insert(nextInt)
                    index++
                }
            }
            arrayPar.display()
            arrayPar.recQuickSort()
            arrayPar.display()
        }
    }
}