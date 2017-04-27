package com.lv.lesson01

import java.util.*

/**
 * Date: 2017-04-18
 * Time: 15:24
 * Description: 学生
 */
data class Student (
        var sid:String?,//序号
        var name:String?,//姓名
        var gender:String?,//性别
        var contact:String?,//联系方式
        var birthday:Date? //出生日期
)