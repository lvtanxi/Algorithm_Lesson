package com.lv.lesson01

import java.util.*

/**
 * Date: 2017-04-18
 * Time: 15:27
 * Description:
 */
object StudentTest {
    @JvmStatic fun main(args:Array<String>){
        val student = Student("SOO1", "张三丰","男","西安市高新四路50号", Date())
        println(student)
    }
}