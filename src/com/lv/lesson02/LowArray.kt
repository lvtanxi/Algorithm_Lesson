package com.lv.lesson02

/**
 * Date: 2017-04-21
 * Time: 16:51
 * Description:
 */
class LowArray(size: Int) {
    private val a: LongArray = LongArray(size)

    fun setElem(index: Int, value: Long) {
        a[index] = value
    }
    fun getElem(index: Int): Long {
        if (index > a.size)
            throw RuntimeException("数组下标越界")
        return a[index]
    }

    fun elemExists(value: Long):Boolean{
        return a.filter { it == value }.isNotEmpty()
    }

}