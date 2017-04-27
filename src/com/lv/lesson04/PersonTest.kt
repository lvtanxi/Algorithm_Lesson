package com.lv.lesson04

/**
 * Date: 2017-04-24
 * Time: 11:32
 * Description:
 */
object PersonTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val dataArray = ClassDataArray(10)
        dataArray.insert(Person("tanxi0", "lv0", 10))
        dataArray.insert(Person("tanxi1", "lv1", 11))
        dataArray.insert(Person("tanxi2", "lv2", 12))
        dataArray.insert(Person("tanxi3", "lv3", 13))
        dataArray.dispaly()
        val person = dataArray.find("tanxi3")
        println(person?.age)
        dataArray.delete("tanxi1")
        dataArray.dispaly()
    }
}