package com.lv.lesson18

import com.lv.util.outPut

/**
 * Date: 2017-05-03
 * Time: 11:38
 * Description:
 */
class RecursionSort(max: Int) {
    private var nItem: Int = 0
    private val array: IntArray = IntArray(max)

    fun insert(value: Int) = array.set(nItem++, value)

    fun display() = array.outPut()

    fun mergeSort() {
        val workSpace = IntArray(nItem)
        recMergeSort(workSpace, 0, nItem.minus(1))
    }

    private fun recMergeSort(workSpace: IntArray, lower: Int, upper: Int) {
        if (lower == upper)
            return
        val mid = (lower.plus(upper)).div(2)
        recMergeSort(workSpace, lower, mid)
        recMergeSort(workSpace, mid.plus(1), upper)
        merge(workSpace, lower, mid.plus(1), upper)
    }

    private fun merge(workSpace: IntArray, lowPtr: Int, midPtr: Int, upper: Int) {
        var lowPtrP = lowPtr
        var midPtrP = midPtr
        val mid = midPtr.minus(1)
        var j = 0
        while (lowPtrP <= mid && midPtrP <= upper)
            workSpace[j++] = if (array[lowPtr] < array[midPtr]) array[lowPtrP++] else array[midPtrP++]
        while (lowPtrP <= mid)
            workSpace[j++] = array[lowPtrP++]
        while (midPtrP <= upper)
            workSpace[j++] = array[midPtrP++]
        for (index in 0..j) {
            array[lowPtr + index] = workSpace[index]
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val recursionSort = RecursionSort(10)
            recursionSort.insert(80)
            recursionSort.insert(38)
            recursionSort.insert(49)
            recursionSort.insert(25)
            recursionSort.insert(3)
            recursionSort.insert(75)
            recursionSort.display()
            recursionSort.mergeSort()
            recursionSort.display()
        }
    }
}