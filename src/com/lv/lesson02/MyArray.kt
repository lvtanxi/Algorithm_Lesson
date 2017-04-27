package com.lv.lesson02

/**
 * Date: 2017-04-21
 * Time: 16:21
 * Description:
 */
object MyArray {
    @JvmStatic
    fun main(args: Array<String>) {
        val lowArray = LowArray(20)
        lowArray.setElem(0,9)
        lowArray.setElem(1,8)
        lowArray.setElem(2,7)
        lowArray.setElem(3,6)
        print(lowArray.getElem(2))
        print(lowArray.elemExists(6))
        print("can't ")
        val list = listOf(1,3,4,5,6,7,9)
        list.filter { it == 3 }.forEach(::println)
        println("Hello")
    }
}

