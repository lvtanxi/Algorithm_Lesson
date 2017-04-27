# java的算法基础

## 概念
> 数据结构：对计算机内存中的数据的一种安排（集合、数组）
> 算法：对结构中的数据进行各种处理（排序）

## 应用方面
1. 现实世界的数据存储
2. 程序员的工具
3. 现实世界的建模

## 数据结构

名称 | 优点 | 缺点
---|--- |---
数组 | 插入快 | 查找慢、删除慢、大小固定
有序数组 | 比无序数组查找快 | 删除慢、插入慢、大小固定
栈 | 提供后进先出的存取方式 | 存取其他项慢
队列 | 提供先进先出的存取方式 | 存取其他项慢
链表 | 插入、删除快 | 查找慢
二叉树 | 插入、查找、删除都快(树平衡的情况下) | 删除算法复杂
红黑树 | 插入、查找、删除都快 | 算法复杂
2-3-4树 | 插入、查找、删除都快 | 算法复杂
Hash表 | 插入快、通过关键字存取快 | 删除慢
堆 | 插入、删除、对最大数据项存取快 | 对其他数据项存取慢
图 | 对现实世界建模 | 算法复杂




## 算法概述

> 算法（Algorithm）是指解题方案的准确而完整的描述，是一系列解决问题的清晰指令，算法代表着用系统的方法描述解决问题的策略机制。也就是说，能够对一定规范的输入，在有限时间内获得所要求的输出。如果一个算法有缺陷，或不适合于某个问题，执行这个算法将不会解决这个问题。不同的算法可能用不同的时间、空间或效率来完成同样的任务。一个算法的优劣可以用空间复杂度与时间复杂度来衡量。
>

### 有序数组的二分查找

```
/**
 * Date: 2017-04-24
 * Time: 10:32
 * Description: 二分查找
 */
object OrderArrayTest {
    @JvmStatic
    fun main(args: Array<String>) {
        //初始化数组
        val orderArray = IntArray(20)
        for (item in 0..19) {
            orderArray[item] = item
        }
        val binarySearch = binarySearch(orderArray, 1)
        println(binarySearch)
        println(binarySearchDef(orderArray,13))
    }

    /**
     * 不带递归的查找方式
     */
    fun binarySearch(array: IntArray, vaule: Int): Int {
        var low = 0
        var high = array.lastIndex
        var middle: Int
        while (low <= high) {
            middle = (low.plus(high)).div(2)
            if (vaule == array[middle])
                return middle
            else if (vaule < array[middle])
                high = middle - 1
            else
                low = middle + 1
        }
        return -1
    }

    /**
     * 递归的查找方式
     */
    fun binarySearch(array: IntArray, vaule: Int, beginIndex: Int, endIndex: Int): Int {
        val midIndex = (beginIndex.plus(endIndex)).div(2)
        if (vaule < array[beginIndex] || vaule > array[endIndex] || beginIndex > endIndex)
            return -1
        if (vaule < array[midIndex])
            return binarySearch(array, vaule, beginIndex, midIndex - 1)
        else if (vaule > array[midIndex])
            return binarySearch(array, vaule, midIndex + 1, endIndex)
        else
            return midIndex
    }

    /**
     * 默认递归的查找方式
     */
    fun binarySearchDef(array: IntArray, vaule: Int): Int {
        return binarySearch(array, vaule, 0, array.size-1)
    }

}
```

### 简单排序_冒泡排序[BubbleSort](http://blog.csdn.net/kimylrong/article/details/17122671)

1. 比较两个对象
2. 如果左边大于右边，则调换位置
3. 向右移动一个位置，比较接下来的的两个对象

```
object BubbleSortTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val arrayOf = intArrayOf(49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51)
        bubbleSort(arrayOf)
        arrayOf.forEach(::println)
    }

    fun bubbleSort(array: IntArray) {
        var temp:Int
        for (i in 0..array.lastIndex) {
            for (j in 0..array.lastIndex - i-1) {
                if (array[j] > array[j + 1]) {
                    temp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = temp
                }
            }
        }
    }
}
```

### 简单排序_选择排序[SelectionSort](http://www.cnblogs.com/shen-hua/p/5424059.html)

> 每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，直到全部记录排序完毕。也就是：每一趟在n-i+1(i=1，2，…n-1)个记录中选取关键字最小的记录作为有序序列中第i个记录。基于此思想的算法主要有简单选择排序、树型选择排序和堆排序。

```
object SelectSortTest {
    @JvmStatic
    fun main(args: Array<String>) {
        val arrayOf = intArrayOf(1, 3, 2, 45, 65, 33, 12)
        outPut(arrayOf)
        selectSort(arrayOf)
        outPut(arrayOf)
    }

    fun selectSort(array: IntArray) {
        var min: Int
        var temp: Int
        for (out in 0..array.lastIndex) {
            min = out
            //找出第out+1位到最后的最小值
            (min.plus(1)..array.lastIndex)
                    .asSequence()
                    .filter { array[it] < array[min] }
                    .forEach { min = it }
            //看看是不是最小的，如果是最小的就交换位置
            if (out != min) {
                temp = array[out]
                array[out] = array[min]
                array[min] = temp
            }
        }
    }
    fun outPut(array: IntArray){
        array.forEach{
            print(it)
            print(",")
        }
        println()
    }
}
```

### 简单排序_插入排序[InsertSort](http://blog.csdn.net/lg1259156776/article/details/48689323)

> 每步将一个待排序的对象,按其排序码大小,插入到前面已经排好序的一组对象的适当位置上,直到对象全部插入为止。不过逆序的时候没有选择或者冒泡排序快

```
object InsertSort {
    @JvmStatic
    fun main(args: Array<String>) {
        val arrayOf = intArrayOf(1, 3, 2, 45, 65, 33, 12)
        arrayOf.outPut()
        insertSort(arrayOf)
        arrayOf.outPut()
    }

    fun insertSort(array: IntArray) {
        var temp: Int
        var tagIndex: Int
        //这里的下标从1开始，因为默认取出一个
        for (i in 1..array.lastIndex) {
            temp = array[i]
            tagIndex = i
            //这里是从向前取数，有点倒叙的意思
            while (tagIndex > 0 && array[tagIndex - 1] >= temp) {
                array[tagIndex] = array[tagIndex - 1]
                tagIndex--
            }
            array[tagIndex] = temp
        }
    }
}
```

### 栈和队列_栈

> 栈是一种特殊的线性表。其特殊性在于限定插入和删除数据元素的操作只能在线性表的一端进行，其表现形式是后进先出(像木桶装东西)


```
class StackX {
    //模拟木桶
    private val stackArray: ArrayList<Int> = ArrayList()
    //添加元素
    fun push(value: Int) {
        if (!isFull())//如果满了就不添加了
            stackArray.add(value)
    }
    //弹出最后一个
    fun pop(): Int {
        return stackArray.removeAt(stackArray.lastIndex)
    }
    //查看最后一个
    fun peek(): Int {
        return stackArray[stackArray.lastIndex]
    }
    //是否为空
    fun isEmpty(): Boolean {
        return stackArray.isEmpty()
    }
    //是否满了
    fun isFull(): Boolean {
        return stackArray.size > 30
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val stackX = StackX()
            stackX.push(20)
            stackX.push(40)
            stackX.push(60)
            stackX.push(80)
            while (!stackX.isEmpty()) {
                val pop = stackX.pop()
                println(pop)
            }
            println("是否空了${stackX.isEmpty()}")
            println("是否满了${stackX.isFull()}")
            stackX.push(10)
            stackX.push(30)
            println("查看${stackX.peek()}")

        }
    }

}
```

### 栈和队列_队列

> 队列是一种特殊的线性表，它只允许在表的前端进行删除操作，而在表的后端进行插入操作。变现为先进先出（像排队打饭）

```
class Queue {
    //队列缓存区
    private val queArray: ArrayList<Int> = ArrayList()
    //添加
    fun push(value: Int) = queArray.add(value)
    //删除
    fun pop() = queArray.removeAt(0)
    //查看
    fun outPut()=queArray.outPut()

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val queue = Queue()
            queue.push(10)
            queue.push(20)
            queue.push(30)
            queue.push(40)
            println("删除了${queue.pop()}")
            println("删除了${queue.pop()}")
            println("删除了${queue.pop()}")
            queue.push(50)
            queue.push(60)
            queue.push(70)
            queue.push(80)
            queue.push(90)
           queue.outPut()
        }
    }

}
```

### 栈和队列_优先级队列[PriorityQueue](http://blog.csdn.net/hiphopmattshi/article/details/7334487)

> 优先级队列是不同于先进先出队列的另一种队列。每次从队列中取出的是具有最高优先权的元素。

```
class PriorityQueue {
    private val queArray: ArrayList<Int> = ArrayList()

    fun insert(item: Int) {
        val index = findIndex(item)
        queArray.add(index, item)
        queArray.outPut()
    }

    fun pop() = queArray.removeAt(queArray.lastIndex)

    fun outPut()=queArray.outPut()

    //需找插入的位置
    private fun findIndex(item: Int): Int {
        queArray.withIndex().forEach {
            if (it.value < item)
                return it.index
        }
        return queArray.lastIndex + 1
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val priorityQueue = PriorityQueue()
            priorityQueue.insert(9)
            priorityQueue.insert(8)
            priorityQueue.insert(5)
            priorityQueue.insert(6)
            priorityQueue.insert(7)
            priorityQueue.pop()
            priorityQueue.outPut()
        }
    }
}
```

### 栈和队列_算数表达式[ArithmeticExpressions](http://blog.csdn.net/jane_no1/article/details/53504013)

> 在计算机中会采用的是后缀表达式(ABC*+)来完成我们日常生活中的中缀表达式(A+B*C)。本节重点是将中缀表达式转化成后缀表达式，以A+B*(C-D)为例

读取元素 | 输出字符串| 栈
---|---|---
&nbsp;A | A | &nbsp;
&nbsp;+ | A | +
&nbsp;B | AB | +
&nbsp;* | AB | +*
&nbsp;( | AB | +*(
&nbsp;C | ABC | +*(
&nbsp;- | ABC | +*(-
&nbsp;D | ABCD | +*(-
&nbsp;) | ABCD- | +*(
&nbsp; | ABCD- | +*
&nbsp;| ABCD-* | +
&nbsp;| ABCD-*+ | 

```
class ArithmeticStackX {
    //模拟木桶
    private val stackArray: ArrayList<Int> = ArrayList()

    //添加元素
    fun push(value: Int) {
        if (!isFull())//如果满了就不添加了
            stackArray.add(value)
    }

    //弹出最后一个
    fun pop() = stackArray.removeAt(stackArray.lastIndex)

    //查看最后一个
    fun peek() = stackArray[stackArray.lastIndex]

    //是否为空
    fun isEmpty() = stackArray.isEmpty()

    //是否满了
    fun isFull() = stackArray.size > 100

    //计算结果
    fun doPasrse(string: String): Int {
        //零时缓存连续弹出的两个数字以及计算结果
        var num1: Int
        var num2: Int
        var interAns: Int
        //对传进来的后缀字符串进行遍历
        for (ch in string.toCharArray()) {
            //判断是否是数字
            if (ch in '0'..'9') {
                push(ch.toInt().minus('0'.toInt())) //这一步很关键，默认的Char 转Int会变成hashcode对应的值，所以要减去0的hashcode值
            } else {
                num1 = pop()
                num2 = pop()
                //根据运算符号进行计算
                when (ch) {
                    '+' -> interAns = num2.plus(num1)
                    '-' -> interAns = num2.minus(num1)
                    '*' -> interAns = num2.times(num1)
                    '/' -> interAns = num2.div(num1)
                    else -> interAns = 0
                }
                //每次结果要放回去，以便后面再计算
                push(interAns)
            }
        }
        //获取最后计算结果
        return pop()
    }


    fun dispalyStatck(string: String) {
        print("$string：")
        stackArray.outPut()
    }

}
```

```
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
```


### 链表_单链表[SingLink](http://blog.csdn.net/jane_no1/article/details/53516994)

> 链表，它也是一种数据存储结构，在大多数情况下我们可以通过链表来代替数组的操作，比如说栈和队列的实现，除非需要频繁的通过下标随机访问数据。当链表只能在链表头进行数据的插入和删除以及通过遍历来显示某个数据项的内容时，这个链表就被称为单链表。

```
//链表节点
data class SingLink(var iData: Int, var dData: Double, var next: SingLink?=null)
```

```
data class SingLinkList(var first: SingLink? = null) {
    //插入数据
    fun insertFirst(id: Int, dd: Double) {
        first = SingLink(id, dd, first)
    }
    //删除第一个数据
    fun deteleFirst(): SingLink? {
        val temp = first
        first = first?.next
        return temp
    }
    //根据key查找数据
    fun find(key: Int): SingLink? {
        var current = first
        if (current != null) {
            while (current!!.iData != key) {
                if (current.next != null)
                    current = current.next
                else
                    return null
            }
        }
        return current
    }
    
    fun delete(key: Int): SingLink? {
        var current = first
        var previous = first
        while (current != null) {
            if (current.iData == key)
                break
            previous = current
            current = current.next
        }
        previous?.next = current?.next
        return current
    }


    fun dispalyList() {
        var current = first
        if (current != null) {
            while (current!!.next != null) {
                println(current.toString())
                current = current.next
            }
        }
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val linkList = SingLinkList()
            linkList.insertFirst(1, 2.2)
            linkList.insertFirst(2, 4.4)
            linkList.insertFirst(3, 6.6)
            linkList.insertFirst(4, 8.8)
            linkList.dispalyList()
            val link = linkList.delete(3)
            println(link?.toString())
            linkList.dispalyList()
            val link2 = linkList.deteleFirst()
            println(link2?.toString())
            linkList.dispalyList()
            val find = linkList.find(2)
            println(find?.toString())
        }
    }
}
```
### 链表_双端链表[DoubleLink](http://blog.csdn.net/jane_no1/article/details/53519348)

> 双端链表和传统的链表非常相似，唯一的不同点在于，双端链表的表头除了有一个指向第一个链接点的Link对象first外，还有一个指向链表最后一个链接点的Link对象last,双端链表可以很快的像普通链表一样在表头位置插入新节点，同时也可以在表尾直接插入新节点。虽然普通链表也可以做到在表尾插入新链接点，但是需要通过遍历链表直到表尾，这显然效率是很低的。

```
// 双端链表节点
data class DLink(var dData: Int, var next: DLink? = null) {
    fun dispalyLink(){
        print("$dData  ")
    }
}
```

```
//申明两个链节点来存储第一个和最后一个连接点
data class FirstLastLink(var first: DLink? = null, var last: DLink? = null) {
    //判断链表是否为空
    fun isEmpty() = first == null
    //在依次插入新数据
    fun insertFirst(dd: Int) {
        val dLink = DLink(dd)
        //如果为空的话，这说明第一个链节点也是最后一个链节点
        if (isEmpty())
            last = dLink
        //这是新的第一个节点
        dLink.next = first
        first = dLink
    }
    //在末尾插入数据
    fun insertLast(dd: Int) {
        val dLink = DLink(dd)
        //如果为空的话，这说明最后一个链节点也是第一个链节点
        if (isEmpty())
            first = dLink
        else
            last?.next = dLink
            //这是新的最后一个节点
        last = dLink
    }

    fun deleteFirst(): Int? {
        val temp = first?.dData
        if (first?.next == null)
            last = null
        first = first?.next
        return temp
    }

    fun dispalyList() {
        var current = first
        while (current != null) {
            current.dispalyLink()
            current = current.next
        }
        println()
    }
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val firstLastLink = FirstLastLink()
            firstLastLink.insertFirst(12)
            firstLastLink.insertFirst(13)
            firstLastLink.insertFirst(14)
            firstLastLink.insertLast(15)
            firstLastLink.last?.dispalyLink()
            println()
            firstLastLink.dispalyList()
            val deleteFirst = firstLastLink.deleteFirst()
            println(deleteFirst)
            firstLastLink.dispalyList()
        }
    }

}
```



## 大O表示法

> 大O表示法，称一个函数g(n)是O(f(n))，当且仅当存在常数c>0和n0>=0，对一切n>n0均有|g(n)|<=c|f(n)|成立，也称函数g(n)以f(n)为界或者称g(n)囿于f(n)。记作g(n)=O(f(n))。[具体查看](http://www.baike.com/wiki/%E5%A4%A7O%E8%A1%A8%E7%A4%BA%E6%B3%95)

名称 | 标识| 效率
---|---|---
线性查找 | O（N） | 还可以
二分查找 | O（log N）| 良好
无序数组的插入| O（1）| 优秀
有序数组的插入 |O（N） | 还可以
无序数组的删除 |O（N） | 还可以
有序数组的删除|O（N） | 还可以
冒泡排序 | O（N²） | 差
选择排序 | O（N²） | 差
插入排序 | O（N²） | 差 > 冒泡
链表 | O（N） | 插入快，查找和删除慢
