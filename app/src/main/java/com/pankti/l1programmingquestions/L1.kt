package com.pankti.l1programmingquestions

import com.google.gson.Gson
import java.util.PriorityQueue
import java.util.Queue
import java.util.Stack

fun main() {
    l1StrContainsVowels()
    l1FibonacciSeries()
    l1FibonacciSeriesWithRecursion()
    l1ReverseString()
    l1ReverseNumber()
    l1SwapValuesWithoutUsingThirdVariable()
    l1CheckIfStringPalindrome()
    l1CheckIfNumberPalindrome()
    l1CheckIfPrimeNumber()
    l1RemoveLeadingExtraSpaceFromString()
    l1SortList()
    l1Factorial()
    l1SecondLastLargestNumberInList()
    l1FindCharInStringAndOccurrences()
    l1Users()
    l1DSQueue()
    l1DSStack()
    l1DSHashMap()
    l1DSBinaryTree()
    l1DSBubbleSort()
    l1DSSelectionSort()
    l1DSInsertionSort()
}

// -------------------------------------------------------------------------------------------------

fun l1DSInsertionSort(list: ArrayList<Int> = arrayListOf(4, 2, 7, 3, 5, 42, 6, 1, 3)) {
    println(list)
    val n = list.size

    // Loop through each element starting from the second
    for (i in 0 until n) {
        val key = list[i]
        print("Key: $key ")
        var j = i - 1
        print("j: $j ")

        // Move elements of arr[0..i-1], that are greater than key, to one position ahead
        // of their current position
        while (j >= 0 && list[j] > key) {
            list[j + 1] = list[j]
            print(" ${list[j]} ")
            j -= 1
        }

        // Place the key at its correct position
        list[j + 1] = key

        // Print the array after placing the key in the right position
        println("| $key: $list")
    }
}


// -------------------------------------------------------------------------------------------------

private fun l1DSSelectionSort(list: ArrayList<Int> = arrayListOf(4, 2, 7, 3, 5, 42, 6, 1, 3)) {
    //  Time complexity: O(N^2)
    // condition with index

    val sortedList = list
    println("Original list: $sortedList")

    for (i in 0 until sortedList.size) {

        var smallestItem = i

        for (j in i + 1 until sortedList.size) {
            if (sortedList[j] < sortedList[smallestItem]) {
                smallestItem = j
            }
        }

        // swap
        val temp = sortedList[smallestItem] //1
        sortedList[smallestItem] = sortedList[i] //2
        sortedList[i] = temp//1

        println("$list")
    }
    println("Sorted list : $sortedList")
}

// -------------------------------------------------------------------------------------------------

private fun l1DSBubbleSort(list: ArrayList<Int> = arrayListOf(7, 8, 2, 3, 1)) {
    //  Time complexity: O(N^2)
    // condition with index
    val sortedList = list

    println("Original list : $list")

    for (i in 0 until sortedList.size - 1) {

        // Inner loop to compare adjacent elements
        for (j in 0 until sortedList.size - i - 1) {

            if (sortedList[j] > sortedList[j + 1]) {
                print("i : $i | j : $j | ${sortedList.size - 1 - i} |")

                // Swap elements if they're in the wrong order
                val temp: Int = sortedList[j] // 8
                sortedList[j] = sortedList[j + 1]//2
                sortedList[j + 1] = temp //8
                print(" <${sortedList[j]} - ${sortedList[j + 1]}> ")

                // Print the array after each swap
                println("-----> $i th iteration : ${sortedList}")

            }

        }

    }

    println("Sorted list : $sortedList")
}

// -------------------------------------------------------------------------------------------------

fun l1DSBinaryTree() {
    val root = TreeNode(10)
    root.left = TreeNode(29)
    root.right = TreeNode(48)

    // Accessing the nodes
    println("Root: ${root.data}")           // Output: 10
    println("Left child: ${root.left?.data}")  // Output: 5
    println("Right child: ${root.right?.data}") // Output: 15
}

class TreeNode(val data: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
// -------------------------------------------------------------------------------------------------

/**
 * A HashMap is a data structure in Java that stores key-value pairs. It provides efficient retrieval,
 * insertion, and deletion operations with an average time complexity of O(1) due to its use of hashing.
 * */
fun l1DSHashMap() {
    val map = HashMap<String, Int>()
    map["Alice"] = 25
    map["Bob"] = 30

    println("Alice's age: " + map["Alice"]) // Output: 25
    println("Bob's age: " + map["Bob"])     // Output: 30
}
// -------------------------------------------------------------------------------------------------


/**
 * A Stack is a linear data structure that follows the LIFO (Last In, First Out) principle,
 * meaning the last element added to the stack is the first one to be removed.
 * */
fun l1DSStack() {
    val stack = Stack<Int>()
    stack.push(10)
    stack.push(20)
    stack.push(30)

    println("Top element: " + stack.peek()) // Output: 30
    println("Popped element: " + stack.pop()) // Output: 30
    println("Top element after pop: " + stack.peek()) // Output: 20
}
// -------------------------------------------------------------------------------------------------

/**
 * A Queue is a linear data structure that operates on the FIFO (First In, First Out) principle.
 * This means that the first element added to the queue is the first one to be removed,
 * much like a line of people waiting for service.
 * */
fun l1DSQueue() {
    val queue: Queue<String> = PriorityQueue() // or LinkedList() to create instance
    queue.add("a")
    queue.add("b")
    queue.add("c")
    println(queue)

    println("Front element: " + queue.peek()) // Output: a
    println("Removed element: " + queue.remove()) // Output: a
    println("Front element after remove: " + queue.peek()) // Output: b

}

// -------------------------------------------------------------------------------------------------


fun l1StrContainsVowels() {
    val str = "pankti"
    println("Check If string contains vowels : " + str.checkIfContainsVowel())
    if (str.checkIfContainsVowel()) printContainsVowels(str)
}

fun String.checkIfContainsVowel(): Boolean {
    return this.contains(Regex("[aeiouAEIOU]"))
}

fun printContainsVowels(string: String) {
    val strSet = string.toCharArray()
    for (i in strSet) {
        if (i.toString().checkIfContainsVowel()) {
            println(i)
        }
    }
}

// -------------------------------------------------------------------------------------------------

fun l1FibonacciSeries() {
    //The Fibonacci series is a sequence in which each number is the sum of the two preceding ones,
    // starting with 0 and 1

    // Fibonacci series up to 5 terms
    val n = 5
    var num1 = 0
    var num2 = 1

    print("$num1 $num2 ")

    for (i in 2 until n) {
        val sum = num1 + num2
        num1 = num2
        num2 = sum
        print("$sum ")
    }
}

fun l1FibonacciSeriesWithRecursion() {
    val n = 10
    for (i in 0 until n) {
        print("${fibonacci(i)} ")
    }
}

fun fibonacci(n: Int): Int {

    //base case
    if (n == 0) return 0
    if (n == 1) return 1

    return fibonacci(n - 1) + fibonacci(n - 2)
}

// -------------------------------------------------------------------------------------------------

fun l1ReverseString() {
    val str = "Pankti Prajapati"

    println()
    // first approach
    println("Original String: $str")
    println(str.reversed())

    // second approach
    val stringBuilder: StringBuilder = StringBuilder(str)
    stringBuilder.reverse()
    println("$stringBuilder")

    // third approach
    val strSet = str.toCharArray()
    var stringLength = strSet.size

    while (stringLength > 0) {
        print("${strSet[stringLength - 1]}")
        stringLength--
    }
    println()

    // fourth approach
    val stack: Stack<Char> = Stack()
    for (i in str) {
        stack.push(i)
    }
    var reversedString = ""

    while (stack.size > 0) {
        reversedString += stack.pop()
    }

    println(reversedString)


    //fifth approach
    var strr = ""
    for (i in str.indices.reversed()){
        strr +=str[i]
    }
}

// -------------------------------------------------------------------------------------------------

fun l1ReverseNumber() {
    var number = 12345678

    println("original number : $number")

    var reversedNumber = 0
    while (number > 0) {
        reversedNumber = reversedNumber * 10 + (number % 10)
        number /= 10
    }
    println(reversedNumber)
}

// -------------------------------------------------------------------------------------------------

fun l1SwapValuesWithoutUsingThirdVariable() {
    var num1 = 10
    var num2 = 20

    println("num1 : $num1 num2 : $num2")

    num1 += num2 // 30
    num2 = num1 - num2 // 30-20 = 10
    num1 -= num2// 30-10 = 20
    println("num1 : $num1 num2 : $num2")
}

// -------------------------------------------------------------------------------------------------

fun l1CheckIfStringPalindrome() {

    //A palindrome is a number or string that reads the same forward and backward.
    // In other words, when reversed, it remains unchanged.

    val str1 = "Pankti"
    val str2 = "Naman"

    if (str1.isPalindrome()) println("String $str1 is palindrome") else println("String $str1 is not palindrome")
    if (str2.isPalindrome()) println("String $str2 is palindrome") else println("String $str2 is not palindrome")
}

fun String.isPalindrome(): Boolean {
    return this.lowercase().reversed() == this.lowercase()
}
// -------------------------------------------------------------------------------------------------

fun l1CheckIfNumberPalindrome() {

    //A palindrome is a number or string that reads the same forward and backward.
    // In other words, when reversed, it remains unchanged.
    val number1 = 12345678
    val number2 = 1234321

    if (isNumberPalindrome(number1)) println("$number1 is palindrome") else println("$number1 is not palindrome")
    if (isNumberPalindrome(number2)) println("$number2 is palindrome") else println("$number2 is not palindrome")
}

fun isNumberPalindrome(number: Int): Boolean {
    var originalNumber = number
    var reversedNumber = 0
    while (originalNumber > 0) {
        reversedNumber = reversedNumber * 10 + (originalNumber % 10)
        originalNumber /= 10
    }
    return number == reversedNumber
}

// -------------------------------------------------------------------------------------------------

fun l1CheckIfPrimeNumber() {
    // A prime number is a number greater than 1 that has no divisors other than 1 and itself.
    // A prime number is only divisible by 1 and the number itself.
    // Examples of prime numbers include 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
    // 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, etc.

    val n = 47
    if (checkIfPrimeNumber(n)) println("$n is prime number") else println("$n is prime not a number")

}

fun checkIfPrimeNumber(n: Int): Boolean {

    //special cases
    if (n == 0 || n == 1) return false
    if (n == 2) return true

    for (i in 3..<n) {
        println("i : $i ${n % i == 0}")
        if (n % i == 0) {
            return false
        }
    }
    return true
}

// -------------------------------------------------------------------------------------------------

fun l1RemoveLeadingExtraSpaceFromString() {
    val str = "      My name is pankti prajapati."
    var newStr = ""

    for (i in str) {

        if (newStr.isNotEmpty() ||( i != ' ')) {
                newStr += i
            }
    }
    println(newStr)
}

// -------------------------------------------------------------------------------------------------

fun l1SortList() {
    val arr = arrayOf(1, 3, 4, 2, 6, 2)
    val ls = listOf(1, 3, 4, 2, 6, 2)
    val arrayList = arrayListOf(1, 3, 4, 2, 6, 2)
    val map = mutableMapOf<Int, String>(1 to "p", 3 to "w", 4 to "z", 2 to "1", 6 to "u", 2 to "d")
    println("original array ${Gson().toJson(arr)}")
    println("Sorted array ${Gson().toJson(arr.sorted())}")
    println("Sorted array Desc ${Gson().toJson(arr.sortedDescending())}")

    println("original list ${Gson().toJson(ls)}")
    println("Sorted list ${Gson().toJson(ls.sorted())}")
    println("Sorted list Desc ${Gson().toJson(ls.sortedDescending())}")

    println("original arrayList ${Gson().toJson(arrayList)}")
    println("Sorted arrayList ${Gson().toJson(arrayList.sorted())}")
    println("Sorted arrayList Desc ${Gson().toJson(arrayList.sortedDescending())}")

    println("original map ${Gson().toJson(map)}")
    println("Sorted map ${Gson().toJson(map.toSortedMap())}")

    map.map {
        map[it.key] = it.value + it.key
    }

    println("Mapped map ${Gson().toJson(map.toSortedMap())}")

}

// -------------------------------------------------------------------------------------------------

fun l1Factorial(n: Int=5) {
    if (n == 0 || n == 1) {
        print("1")
        return
    }

    var i = n
    var finalValue = 1

    while (i > 0) {
        print("$i")
        if (i != 1) print(" * ")

        finalValue *= i
        i--
    }
    println()
    println("Factorial of $n is $finalValue ")
}

// -------------------------------------------------------------------------------------------------

fun l1SecondLastLargestNumberInList() {
    val list = listOf(4, 2, 7, 3, 5, 22, 71, 1, 0)
    println("Original List : ${Gson().toJson(list)}")
    findSecondLastLargeNumberInList(list)
}

fun findSecondLastLargeNumberInList(list: List<Int>) {
    if (list.isNotEmpty() && list.size >= 2) {
        println("second large number in list : ${list.sorted()[list.size - 2]}")
    }

    //prepare any one of them: bubble,merge,quick ,selection, insertion sort for sorting
}

// -------------------------------------------------------------------------------------------------

fun l1FindCharInStringAndOccurrences() {

    val str = "Pankti Shirishbhai Prajapati"
    val findChar = 'a'

    println("Original String: $str")
    val charSet = str.toCharArray()
    var occurrence = 0

    for (i in charSet) {
        if (i.equals(findChar, ignoreCase = true)) {
            occurrence++
        }
    }

    println("occurrence: $occurrence")

}

// -------------------------------------------------------------------------------------------------

enum class UserRoleType(type: Int) {
    Owner(1), Admin(2), Manager(3), Employee(4), Other(0)
}

object User {
    const val userName = "pankti"
    private var userType = UserRoleType.Owner

    fun getUserName(): String {
        return userName
    }
}

class Users : UserContract {
    companion object {
        val userType = UserRoleType.Owner
    }

    private val usersName = User.getUserName()

    override fun getUserName() {
        println("User Name : $usersName")
    }

    override fun getUserNumber(): Int {
        val i = super.getUserNumber()
        println("Interface Super method value: $i")
        return i
    }

    fun stringComparison() {
        val s1 = "pankti"
        val s2 = "pankti"

        println("s1 == s2 : ${s1 == s2}")
        println("s1 === s2 : ${s1 === s2}")
    }

    // todo lamda ,extension, higher order  function
    // todo stack, queue, linkedlist
}

interface UserContract {

    fun getUserName()
    fun getUserNumber(): Int {
        return 1234
    }

    fun print() {
        checkValid(onSuccess = {
            println(it)
        }, onFailure = {
            println(it)
        })
    }

    fun checkValid(onSuccess: (String) -> Unit = {}, onFailure: (String) -> Unit = {}) {
        onSuccess("priyanka chopra")
        onFailure("something went wrong")

    }


}

fun l1Users() {
    val users = Users()
    users.getUserName()
    users.stringComparison()
    users.print()

    val permission = Permission(name = "Pankti")
    val permission1 = Permission(age = 30)
    val permission2 = Permission(name = "Keshav", age = 50)
    println(permission)
    println(permission1)
    println(permission2)





    println("UserData : ${users.getUserNumber()}")
}

data class Permission(val name: String, val age: Int) {
    // creating secondary constructor with primary constructor
    constructor(name: String) : this(name, 0)
    constructor(age: Int) : this("", age)
}



open class ABC {

    fun a(a:Int){

    }

    open fun a(b :String){
        print("vfgsg")
    }

}

class BC() : ABC(){

    override fun a(b: String){
        print(b)
    }
}

class CCC{
    val abc : ABC = ABC()
    val bc : ABC = BC()

    fun abcS(){
        abc.a("abcvdf")
        bc.a("rfoesjgsojg")
    }
}