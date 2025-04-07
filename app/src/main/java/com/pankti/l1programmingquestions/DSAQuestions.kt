package com.pankti.l1programmingquestions

import com.google.gson.Gson
import java.util.LinkedList
import java.util.Stack
import kotlin.math.max
import kotlin.math.min

// Use this to check time & space complexity of your logic : https://www.bigocalc.com/

class DSAQuestions {

    fun mergeAlternately(word1: String, word2: String): String {
        var finalStr = ""
        for (i in 0..(word1.length + word2.length - 2)) {
            if (i < word1.length) {
                finalStr += word1[i]
            }
            if (i < word2.length) {
                finalStr += word2[i]
            }
        }
        return finalStr
    }

    fun reverseWords(s: String): String {
        return s.trim().split("\\s+".toRegex()) // Splits by one or more spaces
            .reversed() // Reverse the list
            .joinToString(" ")
    }

    //pending
    fun decodeString(s: String): String {
        // occurrence ,value
        var finalString = ""
        var stringList = HashMap<Int, String>()

        for (i in s) {
            if (i.isDigit()) {
                stringList.put(i.toInt(), "")
            }
        }
        return ""
    }


    class Tree(var value: Int) {
        var left: Tree? = null
        var right: Tree? = null
    }

    fun searchBST(root: Tree?, value: Int): Tree? {
        if (root == null || root.value == value) return root
        return if (value < root.value) searchBST(root.left, value) else searchBST(root.right, value)
    }

    //pending
    fun dailyTemperatures(
        temperatures: IntArray = intArrayOf(
            73, 74, 75, 71, 69, 72, 76, 73
        )
    ): IntArray {
        val finalValue = mutableListOf<Int>()
        var count = 1
        var previousValue = temperatures[0]

        temperatures.forEach { i ->
            if (previousValue != i) {

                if (previousValue < i) {
                    count = 0
                    previousValue = i
                }

                if (previousValue > i) {
                    count++
                    previousValue = i
                }

            } else {
                count = 1
            }
            finalValue.add(count)

        }
        return finalValue.toIntArray()
    }


    // Given an array of integers, return the indices of the two numbers that add up to a specific target.
    fun twoSum(list: IntArray = intArrayOf(4, 2, 7, 3, 5, 42, 6, 1), target: Int = 8): IntArray {

        // second value , first , index
        val temp = HashMap<Int, Int>()

        list.forEachIndexed { index, item ->
            val second = target - list[index] // 9-4 = 5
            if (temp.containsKey(second)) {
                return intArrayOf(temp[second] ?: 0, index)
            }
            temp[item] = index
        }
        return intArrayOf()

    }


    fun findFirstNonRepeatingCharIndex(str: String = "leetcode"): Pair<Char, Int> {
        // char, occurrence,index
        val list = LinkedHashMap<Char, Pair<Int, Int>>()

        for (i in str.indices) {
            list[str[i]] = Pair((list[str[i]]?.first ?: 0) + 1, i)
        }

        var finalValue: Pair<Char, Int>? = null

        list.forEach { (t, u) ->
            if (u.first == 1) {
                finalValue = Pair(t, u.second)
                return finalValue as Pair<Char, Int>
            }
        }

        return finalValue!!
    }

    fun findNonRepeatingCharIndex(str: String = "leetcode"): List<Pair<Char, Int>> {
        // char, occurrence,index
        val list = LinkedHashMap<Char, Pair<Int, Int>>()

        for (i in 0 until str.length) {
            list[str[i]] = Pair((list[str[i]]?.first ?: 0) + 1, i)
        }

        val finalValue: MutableList<Pair<Char, Int>> = mutableListOf()

        list.forEach { (t, u) ->
            if (u.first == 1) {
                finalValue.add(Pair(t, u.second))
            }
        }

        return finalValue
    }


    fun isValidParenthesesOrder(str: String): Boolean {
        val stack = Stack<Char>()
        val bracketsMap = mapOf(')' to '(', '}' to '{', ']' to '[')
        for (i in str) {
            if (stack.isNotEmpty() && stack.peek() != bracketsMap[i]) {
                return false
            }
            stack.push(i)
        }
        return false
    }


    //pending
    fun nextGreaterElement(
        first: IntArray = intArrayOf(4, 1, 2), second: IntArray = intArrayOf(1, 3, 4, 2)
    ): IntArray {

        val arr = mutableListOf<Int>()

        first.forEach { item ->
            var max = -1
            for (i in second) {
                if (item < i) {
                    max = i
                    break
                }
            }
            arr.add(max)
        }
        return arr.toIntArray()
    }


    fun linkedListQ() {
        val linkedList = LinkedList<String>()
        linkedList.add("2")
        linkedList.add("3")
        linkedList.add("4")

        print(linkedList)
        print(linkedList.reversed())

    }


    // Best for: Sorted Array Searching, Rotated Array Search.
    fun binarySearch(arr: IntArray, target: Int): Int {
        var left = 0
        var right = arr.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                arr[mid] == target -> return mid
                arr[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return -1
    }


    fun findDifference(
        nums1: IntArray = intArrayOf(1, 2, 3), nums2: IntArray = intArrayOf(2, 4, 6)
    ): List<List<Int>> {

        val set1 = nums1.toHashSet()
        val set2 = nums2.toHashSet()
        // Find elements unique to each array
        val diff1 = set1 - set2 // Elements in nums1 but not in nums2
        val diff2 = set2 - set1 // Elements in nums2 but not in nums1

        return listOf(diff1.toList(), diff2.toList())
    }


    fun gcdOfStrings(str1: String = "LEET", str2: String = "CODE"): String {
        // Check if they share a common pattern
        if (str1 + str2 != str2 + str1) return ""

        // Find GCD of lengths
        val gcdLength = gcd(str1.length, str2.length)

        // The GCD substring is the prefix of that length
        return str1.substring(0, gcdLength)
    }

    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
//    candies.sorted()
//    val resultList = mutableListOf<Boolean>()
//
//    val biggestItem = candies.sorted()[candies.size-1]
//    println(biggestItem)
//    println(Gson().toJson(candies))
//    for (i in 0 until candies.size) {
//        if (candies[i] + extraCandies < biggestItem) resultList.add(false)
//        else resultList.add(true)
//    }
//    return resultList
        val max = candies.maxOrNull() ?: 0
        return candies.map { it + extraCandies >= max }
    }


    fun canPlaceFlowers(
        flowerbed: IntArray = intArrayOf(1, 0, 0, 0, 0, 0, 1),
        n: Int = 2
    ): Boolean {
        if (n == 0) return true
        if (n > flowerbed.size) return false
        if (flowerbed.isEmpty()) return false
        if (flowerbed.size == 1 && flowerbed[0] == 1) return false
        if (flowerbed.size == 2 && flowerbed[0] == 1) return false

        var count = 0
        for (i in flowerbed.indices) {

            if (flowerbed[i] == 0) {
                val current = flowerbed[i]
                val left = if (i == 0) 0 else flowerbed[i - 1]
                val right = if (i == flowerbed.size - 1) 0 else flowerbed[i + 1]

                if (current.canPlant(left, right)) {
                    flowerbed[i] = 1
                    count++
                }
            }
        }

        return count >= n
    }

    fun Int.canPlant(left: Int, right: Int): Boolean {
        return (left == 0 && right == 0)
    }

    fun reverseVowels(s: String = "leetcode"): String {
        if (s == " ") return " "
        //vowel : a,e,i,o,u
        //reverse only vowels in string
        var str = s
        var vowels = Stack<Char>()
        for (i in str) {
            if (i.toString().contains(Regex(pattern = "[aeiouAEIOU]"))) {
                vowels.push(i)
            }
        }

        var reversedVowelString = ""

        if (vowels.isNotEmpty()) {
            for (i in 0 until str.length) {
                if (str[i].toString().contains(Regex(pattern = "[aeiouAEIOU]"))) {
                    reversedVowelString += "" + vowels.pop()

                } else {
                    reversedVowelString += str[i]
                }
            }
        } else reversedVowelString = s
        return reversedVowelString
    }

    fun productExceptSelf(nums: IntArray = intArrayOf(1, 2, 3, 4)): IntArray {

        val finalValue = mutableListOf<Int>()
        // First pass: Calculate prefix products
        var prefix = 1
        for (i in nums.indices) {
            finalValue.add(prefix) // Store product of elements before index i
            println(finalValue[i])
            prefix *= nums[i]   // Update prefix product
        }

        // Second pass: Multiply suffix products
        var suffix = 1
        for (i in nums.indices.reversed()) {
            finalValue[i] *= suffix // Multiply with suffix product
            println(finalValue[i])
            suffix *= nums[i] // Update suffix product
            println("---" + nums[i])
        }


        return finalValue.toIntArray()
    }

    fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.isEmpty() || nums.size == 1 || nums.size == 2) return false
        var first = Int.MAX_VALUE
        var second = Int.MAX_VALUE

        for (i in nums) {
            when {
                (i <= first) -> first = i
                (i <= second) -> second = i
                else -> return true

            }
        }
        return false
    }

    //working but with extra space
    fun compress(chars: CharArray): Int {
        if (chars.isEmpty()) return 0
        if (chars.size == 1) return 1

        // char and occurrence
        val list = HashMap<Char, Int>()
        for (i in chars) {
            if (list.containsKey(i)) {
                list[i] = (list[i] ?: 0) + 1
            } else {
                list[i] = 1
            }
        }

        val strList = mutableListOf<Any>()
        for (i in list) {
            strList.add(i.key)
            strList.add(i.value)
        }

        println(Gson().toJson(strList))
        println(Gson().toJson(chars))
        return strList.size
    }

//working
    /*
    fun compress(chars: CharArray): Int {
        if (chars.isEmpty()) return 0
        if (chars.size == 1) return 1

        var character = ""
        var occurrence = 1
        var str = mutableListOf<String>()

        for (i in chars) {
            if (character != i.toString()) {
                if (character.isNotEmpty()) str.add(occurrence.toString())
                occurrence = 1
                character = i.toString()
                str.add(character)
            } else {
               occurrence += 1
            }
        }
        str.add(occurrence.toString())
        println(Gson().toJson(str))
        return str.size
    }*/


// You must write an algorithm that uses only constant extra space.
    /*fun compress(chars: CharArray): Int {
        if (chars.isEmpty()) return 0
        if (chars.size == 1) return 1

        var character: Char? = null
        var occurrence = 1
        var strTotalCount = 1

        for (i in 0..chars.size-1) {
            if (character != chars[i]) {
                if (character != null) {
                    strTotalCount += 1
                }
                occurrence = 1
                character = chars[i]
                strTotalCount += 1
            } else {
                occurrence += 1
            }
        }
        return strTotalCount
    }*/


    fun uniqueOccurrences(arr: IntArray): Boolean {
        //item, occurrence
        val list = HashMap<Int, Int>()
        for (i in arr) {
            if (list.containsKey(i)) {
                list[i] = (list[i] ?: 0) + 1
            } else list[i] = 1
        }
        return (list.values.distinct().size == list.values.size)
    }


    // pending
    fun removeStars(s: String = "leet**cod*e"): String {
        if (s.isEmpty()) return s

        var finalStr = ""
        var prevItem: Char? = null
        var temp = s

        s.toCharArray().reversed().forEach { item ->
            if (item != '*' && prevItem != '*') {
                finalStr = item + finalStr
            }
            prevItem = item
        }

        return finalStr
    }


    fun asteroidCollision(asteroids: IntArray = intArrayOf(10, 2, -5)): IntArray {

        val stack = Stack<Int>()
        for (i in asteroids) {
            stack.push(i)
        }

        var asteroid: Int = stack.peek()

        while (stack.isNotEmpty()) {
            if (stack.peek() < 0) asteroid = stack.pop() // -5

            val temp = stack.peek().toInt() + (asteroid ?: 0) // 10 +-5 = 5
            if (temp <= 0) {
                asteroid = temp
                stack.pop()
            } else break

        }
        return stack.toIntArray()
    }


    //find the smallest repeating element in the array with the highest occurrence.
    fun firstSmallestRepeatingElement(array: IntArray = intArrayOf(1, 5, 3, 3, 4, 3, 5, 5, 6)) {
        val data = HashMap<Int, Int>()

        for (i in array) {
            if (data.containsKey(i)) data[i] = (data[i] ?: 0) + 1 else data[i] = 1
        }

        print(data)

        var maxOccurrence = 0
        var smallest = Int.MAX_VALUE

        for (i in data) {
            if (i.value > maxOccurrence) {
                maxOccurrence = i.value
                smallest = i.key
            } else {
                if (maxOccurrence == i.value && i.key < smallest) {
                    smallest = i.key
                }
            }
        }

        println("Smallest Item : $maxOccurrence  $smallest")

    }


// non overlapping meeting room , trains, classes anything related to time
//Minimum Platforms Required for Overlapping Trains

    //two pointer approach :  O(n log n)
    fun getPlatForms(
        arrival: IntArray = intArrayOf(900, 940, 950, 1100, 1500, 1800),
        departure: IntArray = intArrayOf(910, 1200, 1120, 1130, 1900, 2000),
    ): Int {

        if (arrival.isEmpty() && departure.isEmpty()) return 0
        arrival.sorted() // O(n log n)
        departure.sorted() // // O(n log n)

        var platFormCount = 0

        var i = 0
        var j = 0

        while (i < arrival.size) {
            when {
                //900 < 910
                (arrival[i] < departure[j]) -> {
                    platFormCount++
                    println("first i: $i j: $j arrival : ${arrival[i]}  departure : ${departure[j]} platform : $platFormCount")
                    i++
                }

                else -> {
                    platFormCount--
                    println("second i: $i j: $j arrival : ${arrival[i]}  departure : ${departure[j]}  platform : $platFormCount")
                    j++
                }
            }
        }
        return 0
    }

    //Problem: Minimum Meeting Rooms Required
    fun minMeetingRooms(
        intervals: Array<IntArray> = arrayOf(
            intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(2, 5), intArrayOf(4, 5)
        )
    ): Int {

        if (intervals.isEmpty()) return 0

        var meetingRoom = 0
        var i = 0
        var j = 0

        val startTime = intervals.map { it[0] }.sorted()
        val endTime = intervals.map { it[1] }.sorted()

        while (i < intervals.size) {
            when {
                (startTime[i] < endTime[j]) -> {
                    meetingRoom++
                    i++
                }

                else -> {
                    meetingRoom--
                    j++
                }
            }
        }

        println("StartTime : $startTime")

        return meetingRoom
    }

    fun moveZeroes(nums: IntArray = intArrayOf(2, 0, 0, 4, 0, 1, 0, 3, 12)): IntArray {
        var nonZeroIndex = 0

        for (i in nums.indices) {
            if (nums[i] != 0) {
                val t = nums[i]
                nums[i] = nums[nonZeroIndex]
                nums[nonZeroIndex] = t
                print("$nonZeroIndex ")
                nonZeroIndex++
            }
        }

        println(Gson().toJson(nums))
        return nums
    }


    // t contains s  in o
    fun isSubsequence(s: String = "abc", t: String = "ahbgdc"): Boolean {

        if (s.isEmpty()) return true

        var sIndex = 0
        var tIndex = 0

        while (tIndex < t.length) {
            if (sIndex < s.length && t[tIndex] == s[sIndex]) {
                sIndex++
            }
            tIndex++

            // If all characters of 's' are found in order
            if (sIndex == s.length) return true
        }
        return false
    }


    // Container With Most Water
    fun maxArea(height: IntArray = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)): Int {
        if (height.isEmpty() || (height.size == 2 && height.first() == 1 && height[1] == 1)) return 1

        var minIndex = 0
        var maxIndex = height.size - 1
        var maxArea = 0

        while (minIndex < maxIndex) {
            val l = min(height[minIndex], height[maxIndex])
            val b = maxIndex - minIndex
            maxArea = max(maxArea, l * b)
            if (height[minIndex] < height[maxIndex]) minIndex++ else maxIndex--
        }

        return maxArea
    }


    //Max Number of K-Sum Pairs
    fun maxOperations(
        num: IntArray = intArrayOf(4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4),
        k: Int = 2
    ): Int {
        val nums = num.sorted()
        if (nums.isEmpty()) return 0
        if (nums.size == 2) return if (nums[0] + nums[1] == k) 1 else 0

        var minIndex = 0
        var maxIndex = nums.size - 1
        var count = 0

        while (minIndex < maxIndex) {
            println("minIndex : $minIndex, ${nums[minIndex]}  maxIndex : $maxIndex, ${nums[maxIndex]} count : $count")

            val sum = (nums[minIndex] + nums[maxIndex])
            when {
                (sum == k) -> {
                    count++
                    minIndex++
                    maxIndex--
                }

                sum < k -> minIndex++
                else -> maxIndex--
            }
        }

        return count
    }


    fun closeStrings(word1: String = "cabbba", word2: String = "abbccc"): Boolean {
        if (word1.length != word2.length) return false
        val temp1 = HashMap<Char, Int>()
        val temp2 = HashMap<Char, Int>()

        for (i in 0..(word1.length + word2.length)) {

            if (i < word1.length) {
                if (temp1.containsKey(word1[i])) temp1[word1[i]] =
                    (temp1[word1[i]] ?: 0) + 1 else temp1[word1[i]] = 1
            }

            if (i < word2.length) {
                if (temp2.containsKey(word2[i])) temp2[word2[i]] =
                    (temp2[word2[i]] ?: 0) + 1 else temp2[word2[i]] = 1
            }
        }

        println("word1 : $word1 $temp1")
        println("word2 : $word2 $temp2")


        // Both words should have the same unique characters
        // Frequency counts must match (in any order)
        return (temp1.size == temp2.size) && (temp1.values.sorted() == temp2.values.sorted()) && (temp1.keys.sorted() == temp2.keys.sorted())
    }

    fun findMaxAverage(nums: IntArray = intArrayOf(1, 12, -5, -6, 50, 3), k: Int = 4): Double {

        if (nums.size == 1) return nums[0].toDouble()

        var result: Double = -1.0
        var totalSum = 0.0
        var maxAverage = 0.0

        for (i in 0 until k) {
            totalSum += nums[i]
        }
        maxAverage = totalSum / k
        result = maxAverage

        if (nums.size > k) {
            for (i in k until nums.size) {
                totalSum += nums[i] - nums[i - k]
                result = maxOf(maxAverage, totalSum / k)
                maxAverage = result
            }
        }

        return result
    }


    fun maxVowels(s: String, k: Int): Int {

        val vowels = hashSetOf('a', 'e', 'i', 'o', 'u')

        // special case
        if (s.isEmpty()) return 0
        if (s.length == 1) return if (vowels.contains(s[0])) 1 else 0

        var totalVowel = 0
        var maxVowel = 0

        for (i in 0 until k) {
            if (vowels.contains(s[i])) totalVowel++
        }

        maxVowel = totalVowel

        // Sliding window for the rest of the string
        for (i in k until s.length) {
            if (vowels.contains(s[i])) totalVowel++ // Add new character
            if (vowels.contains(s[i - k])) totalVowel-- // Remove old character

            maxVowel = maxOf(maxVowel, totalVowel)
        }

        return maxVowel
    }


    // binary array : only 0,1
    fun longestOnes(nums: IntArray, k: Int): Int {

        if (nums.isEmpty()) return 0

        var startIndex = 0
        var totalZeros = 0
        var maxSubarrayCount = 0


        nums.forEachIndexed { index, item ->

            if (item == 0) totalZeros++

            if (totalZeros > k) {
                if (nums[startIndex] == 0) totalZeros--
                startIndex++
            }
            // Update the maximum subarray length
            maxSubarrayCount = maxOf(maxSubarrayCount, index - startIndex + 1)
        }
        return maxSubarrayCount
    }

    // binary array : 0,1 ,remove one element and find longest subarray with 1's
    fun longestSubarrayN2(nums: IntArray = intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1)): Int {
        if (nums.isEmpty()) return 0

        var maxSubArrayLength = 0
        var deleteItemIndex = 0

        for (i in 0 until nums.size) {
            var totalCount = 0
            nums.forEachIndexed { index, item ->
                if (index != deleteItemIndex && item == 1) {
                    totalCount++
                } else {
                    if (item == 0 && index != deleteItemIndex && totalCount > 0) {
                        maxSubArrayLength = maxOf(maxSubArrayLength, totalCount)
                        totalCount = 0
                    }
                }
            }
            maxSubArrayLength = maxOf(maxSubArrayLength, totalCount)
            //remove different item and try
            deleteItemIndex++
        }
        return maxSubArrayLength
    }


    fun longestSubarrayN(nums: IntArray): Int {
        var startIndex = 0
        var zeroCount = 0
        var maxSubArrayLength = 0

        for (i in nums.indices) {
            if (nums[i] == 0) zeroCount++

            // If more than one zero, shrink the window from the left
            while (zeroCount > 1) {
                println("startIndex: $startIndex")
                if (nums[startIndex] == 0) zeroCount--
                startIndex++
            }

            maxSubArrayLength = maxOf(maxSubArrayLength, i - startIndex)
        }

        return maxSubArrayLength
    }

    //[[1,2],[2,3],[3,4],[1,3]]
    //[[1,4],[2,3],[3,4],[1,3]] //randomly you need to remove
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        println(Gson().toJson(intervals))
        if (intervals.isEmpty()) return 0

        //We always try to keep intervals that end the earliest to make room for others.
        intervals.sortBy { it[1] }
        println(Gson().toJson(intervals))

        var endTime = intervals[0][1]
        var removeCount = 0
        println("endTime: $endTime")

        for (i in 1..<intervals.size) {
            println("${intervals[i][0]} endTime: $endTime removeCount: $removeCount")
            if (intervals[i][0] < endTime) {
                removeCount++
            } else {
                endTime = intervals[i][1]
            }
        }

        println("removeCount : $removeCount")
        return removeCount
    }


    fun findMinimumMeetingRooms(meetings: Array<IntArray>): Int {
        if (meetings.isEmpty()) return 0
        println(Gson().toJson(meetings))

        val start = meetings.map { it[0] }.sorted()
        println(Gson().toJson(start))

        val end = meetings.map { it[1] }.sorted()
        println(Gson().toJson(end))

        var meetingRooms = 0
        var startIndex = 0
        var endIndex = 0
        var maxRooms = 1

        while (startIndex < meetings.size) {

            if (start[startIndex] < end[endIndex]) {
                meetingRooms++
                maxRooms = maxOf(maxRooms, meetingRooms)
                startIndex++
            } else {
                meetingRooms--
                endIndex++
            }

            println("meetingRooms : $meetingRooms")
        }

        return maxRooms
    }

    fun findMinArrowShots(points: Array<IntArray>): Int {
        println(Gson().toJson(points))
        if (points.isEmpty()) return 0

        points.sortBy { it[1] }
        println(Gson().toJson(points))

        var arrows = 1
        var arrowPosition = points[0][1]

        for (i in 1 until points.size) {
            if (points[i][0] > arrowPosition) {
                arrows++
                arrowPosition = points[i][1]
            }
        }
        println("arrows : $arrows")
        return arrows
    }


    fun largestAltitude(gain: IntArray): Int {
        var maxAltitude = 0
        var altitude = 0

        for (i in gain) {
            altitude += i
            println("altitude $altitude")
            maxAltitude = max(maxAltitude, altitude)
        }

        println("maxAltitude: $maxAltitude")
        return maxAltitude
    }

    fun pivotIndex(nums: IntArray): Int {
        if (nums.isEmpty()) return -1
        println(Gson().toJson(nums))

        var rightSum = nums.sum() // O(n)
        println("rightSum: $rightSum")
        var leftSum = 0

        nums.forEachIndexed { index, i ->
            rightSum -= i
            if (leftSum == rightSum) {
                return index
            }
            leftSum += i
            println("leftSum: $leftSum rightSum: $rightSum")
        }
        return -1
    }

    // Given an array of integers, return the indices of the two numbers that add up to a specific target.
    fun twoSumForSortedArray(list: IntArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 42), target: Int = 8): List<Pair<Int,Int>> {
        if (list.isEmpty()) return listOf()

        var left = 0
        var right = list.size-1
        var result = mutableListOf<Pair<Int, Int>>()

        while (left < list.size) {
            val sum = list[left] + list[right]

            if (sum == target) {
                result.add(Pair(left, right))
                return result
            }

            if (sum < target) {
                left++
            }

            if (sum > target) {
                right--
            }

        }
        return result
    }

  
}
