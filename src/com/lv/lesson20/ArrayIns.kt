package com.lv.lesson20

import com.lv.util.outPut
import java.util.*

/**
 * Date: 2017-05-09
 * Time: 10:28
 * Description: 快速排序
 */
class ArrayIns {
    private val theArray = ArrayList<Int>()

    fun insert(value: Int) = theArray.add(value)

    fun display() = theArray.outPut()


    /**
     * 执行快速排序的方法
     */
    fun recQuickSort(left: Int = 0, right: Int = theArray.lastIndex) {
        if (right.minus(left) <= 0)
            return
        val pivot = theArray[right]//获取分割点值
        val partition = partition(left, right, pivot)
        recQuickSort(left, partition - 1)//前一部分递归
        recQuickSort(partition+1, right)//后一部分抵罪
    }

    /**
     * 划分实现
     */
    private fun partition(left: Int, right: Int, pivot: Int): Int {
        var leftPtr = left.minus(1)
        var rightPtr = right
        while (true) {
            while (theArray[++leftPtr] < pivot) {
            }
            while (rightPtr > 0 && theArray[--rightPtr] > pivot) {
            }
            if (leftPtr >= rightPtr)
                break
            swap(leftPtr, rightPtr)
        }
        swap(leftPtr, right)
        return leftPtr
    }

    private fun swap(dex1: Int, dex2: Int) {
        val temp = theArray[dex1]
        theArray[dex1] = theArray[dex2]
        theArray[dex2] = temp
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val arrayPar = ArrayIns()
            var index = 0
            val random = Random()
            var nextInt: Int
            while (index < 16) {
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