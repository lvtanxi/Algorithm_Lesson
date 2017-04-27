package com.lv.lesson10

import com.lv.util.outPut
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Date: 2017-04-26
 * Time: 15:47
 * Description: 栈和队列_算数表达式(中缀表达式转换成后缀表达式)
 */
class ArithmeticExpressions {
    //模拟存放字运算符的栈
    private val statckArray: ArrayList<Char> = ArrayList()
    //最后返回的字符串
    private val sb = StringBuilder()
    //添加元素
    fun push(char: Char) = statckArray.add(char)
    //弹出最后一个元素
    fun pop() = statckArray.removeAt(statckArray.lastIndex)
    //是否为空
    fun isEmpty() = statckArray.isEmpty()
    //打印栈
    fun dispalyStatck(string: String) {
        print(string)
        statckArray.outPut()
    }

    /**
     * 中缀表达式转换成后缀表达式
     * @param input 中缀表达式
     */
    fun doTrans(input: String): String {
        //清空StringBuffer中的
        sb.setLength(0)
        //遍历字符串
        for (ch in input.toCharArray()) {
            //判断字符的类型
            when (ch) {
                // + - 默认为一级运算符号
                '+', '-' -> gotOper(ch, 1)
                // * / 默认为二级运算符号
                '*', '/' -> gotOper(ch, 2)
                // (的时候直接添加进去
                '(' -> push(ch)
                // )的时候弹出元素
                ')' -> gotParen()
                //普通元素直接拼接
                else -> sb.append(ch)
            }
        }
        //把栈中的元素通过后进先出的原则进行拼接
        while (!isEmpty()) {
            sb.append(pop())
        }
        return sb.toString()
    }

    //把栈中的元素通过后进先出的原则进行拼接
    private fun gotParen() {
        while (!isEmpty()) {
            val pop = pop()
            if (pop == '(')
                break
            sb.append(pop)
        }
    }

    //根据字符和运算等级来拼接字符
    private fun gotOper(opThis: Char, prec1: Int) {
        while (!isEmpty()) {
            // 弹出最后一个运算符
            val pop = pop()
            //判断是(括号,因为优先级最高,所以添加弹出的元素，然后跳出循环了
            if (pop == '(') {
                push(pop)
                break
            }
            //确定最后一个运算符的运算等级
            val prec2 = if (pop == '+' || pop == '-') 1 else 2
            //获取最后一个运算符的等级小于传进来的等级，则添加运算符，跳出循环，否则就把最后一个元素的值拼接到目标字符串上
            if (prec2 < prec1) {
                push(pop)
                break
            }
            //拼接运算符号
            sb.append(pop)
        }
        //最后把传进来的字符串放进栈中
        push(opThis)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            while (true) {
                println("亲，请输入中缀字符串：")
                val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
                val input = bufferedReader.readLine()
                if (input.isEmpty())
                    return
                val expressions = ArithmeticExpressions()
                val doTrans = expressions.doTrans(input)
                println("转化结果：$doTrans")
                val arithmeticStackX = ArithmeticStackX()
                val doPasrse = arithmeticStackX.doPasrse(doTrans)
                println("最后结果了：$doPasrse")
            }
        }
    }

}