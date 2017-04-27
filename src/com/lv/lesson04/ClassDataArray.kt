package com.lv.lesson04

/**
 * Date: 2017-04-24
 * Time: 11:19
 * Description:
 */
class ClassDataArray(max: Int) {
    private val persons: Array<Person?> = arrayOfNulls(max)
    private var mElems = 0
    fun find(name: String): Person? {
        persons.filter { it?.lastName == name }.forEach { return it }
        return null
    }

    fun insert(person: Person) {
        persons[mElems] = person
        mElems++
    }

    fun delete(name: String): Boolean {
        var index = 0
        for ((postion,item) in persons.withIndex()){
            if(item?.lastName==name) {
                index = postion
                break
            }
        }
        if (index == mElems)
            return false
        for (key in index..mElems){
            persons[key] = persons[key+1]//冒泡排序
        }
        mElems--
        return true
    }

    fun dispaly(){
        persons.forEach(::println)
    }


}