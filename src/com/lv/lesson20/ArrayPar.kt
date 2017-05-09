package com.lv.lesson20

import com.lv.util.outPut
import java.util.*

/**
 * Date: 2017-05-08
 * Time: 17:07
 * Description: 数组划分
 */
class ArrayPar {
    private val theArray = ArrayList<Int>()

    fun size() = theArray.size

    fun insert(value: Int) = theArray.add(value)

    fun display() = theArray.outPut()
    /**
     * 划分实现
     */
    fun partitionIt(left: Int, right: Int, pivot: Int): Int {
        //主要是怕数据下标越界，为后面的先++或者--做准备
        var leftPatr = left.minus(1)
        var rightPatr = right.plus(1)
        while (true) {
            //从左向右找大于特定的数据项
            while (leftPatr < right && theArray[++leftPatr] < pivot) {
                //循环结束就表示找到一个大于特定值得数据项
            }
            //从右向左找小于特定的数据项
            while (rightPatr > left && theArray[--rightPatr] > pivot) {
                //循环结束就表示找到一个小于特定值得数据项
            }
            if (leftPatr >= rightPatr)
                break
            swap(leftPatr, rightPatr)
        }
        return leftPatr
    }

    fun swap(dex1: Int, dex2: Int) {
        val temp = theArray[dex1]
        theArray[dex1] = theArray[dex2]
        theArray[dex2] = temp
    }
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val arrayPar = ArrayPar()
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
            val partitionIt = arrayPar.partitionIt(0, arrayPar.size().minus(1), 99)
            println(partitionIt)
            arrayPar.display()
        }
    }

}