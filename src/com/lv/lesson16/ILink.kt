package com.lv.lesson16

/**
 * Date: 2017-05-02
 * Time: 10:30
 * Description: 迭代器节点
 */
class ILink(var dData:Int,var next:ILink?=null) {
    fun display(){
        print("$dData  ")
    }
}