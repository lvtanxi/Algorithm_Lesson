package com.lv.lesson13

/**
 * Date: 2017-04-27
 * Time: 15:05
 * Description:
 */
data class PLink(var dData:Int,var next:PLink?=null) {
    fun dispalyLink(){
        print("$dData  ")
    }
}