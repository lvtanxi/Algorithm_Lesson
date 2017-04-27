package com.lv.util



/**
 * Date: 2017-04-25
 * Time: 11:45
 * Description:
 */

fun ArrayList<*>.outPut(){
    this.forEach {
        print(it)
        print(",")
    }
    println()
}

fun IntArray.outPut(){
    this.forEach {
        print(it)
        print(",")
    }
    println()
}