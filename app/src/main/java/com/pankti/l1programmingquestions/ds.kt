package com.pankti.l1programmingquestions

import kotlin.math.max
import kotlin.math.min
import kotlin.text.iterator

/**
 * Finds the maximum number of consecutive 1's in the array if at most `k` 0's can be flipped.
 * Uses a sliding window approach to maintain a window with at most `k` zeroes.
 *
 * @param nums The input binary array (containing only 0s and 1s)
 * @param k The maximum number of 0s you are allowed to flip to 1
 * @return The length of the longest subarray containing only 1s after at most `k` flips
 */
fun longestOnes(nums: IntArray, k: Int): Int {


    // Edge case: return 0 if input array is empty
    if (nums.isEmpty()) return 0

    var startIndex = 0           // Start of the sliding window
    var totalZeros = 0           // Current count of zeros in the window
    var maxSubarrayCount = 0     // Track the maximum length of valid subarray

    // Iterate through each element using index and value
    nums.forEachIndexed { index, item ->

        // If the current element is 0, we consider it a flip and count it
        if (item == 0) totalZeros++


        // If the window has more than k zeros, shrink it from the left
        if (totalZeros > k) {
            // If the element at the start of the window was a 0, reduce the flip count
            if (nums[startIndex] == 0) totalZeros--

            // Move the window start forward
            startIndex++
        }

        // Update the max window size if current window is valid
        maxSubarrayCount = maxOf(maxSubarrayCount, index - startIndex + 1)
    }

    // Return the maximum number of 1s that can be achieved with at most k flips
    return maxSubarrayCount
}


/**
 * Finds the maximum number of vowels in any substring of length `k` within string `s`.
 * Uses a sliding window approach to efficiently compute the result in O(n) time.
 *
 * @param s The input string
 * @param k The fixed size of the substring window
 * @return The maximum number of vowels found in any window of length k
 */
fun maxVowels(s: String, k: Int): Int {
    // Define a set of vowels for quick lookup
    val vowels = hashSetOf('a', 'e', 'i', 'o', 'u')

    // Edge case: empty string
    if (s.isEmpty()) return 0

    // Edge case: single character string
    if (s.length == 1) return if (vowels.contains(s[0])) 1 else 0

    var totalVowel = 0   // Vowel count in the current window
    var maxVowel = 0     // Max vowel count across all windows

    // Step 1: Count vowels in the first window of size k
    for (i in 0 until k) {
        if (vowels.contains(s[i])) totalVowel++
    }

    // Set initial maxVowel based on the first window
    maxVowel = totalVowel

    // Step 2: Slide the window through the rest of the string
    for (i in k until s.length) {
        // Add the character entering the window (right end)
        if (vowels.contains(s[i])) totalVowel++

        // Remove the character leaving the window (left end)
        if (vowels.contains(s[i - k])) totalVowel--

        // Update maxVowel if the current window has more vowels
        maxVowel = maxOf(maxVowel, totalVowel)
    }

    // Return the highest number of vowels found in any window
    return maxVowel
}


/**
 * Finds the maximum average of any subarray of size `k` in the input array.
 *
 * Uses a sliding window approach to compute averages in O(n) time.
 *
 * @param nums The input array of integers
 * @param k The fixed size of the subarray
 * @return The maximum average value found among all subarrays of size k
 */
fun findMaxAverage(nums: IntArray = intArrayOf(1, 12, -5, -6, 50, 3), k: Int = 4): Double {

    // Edge case: if the array has only one element, return that element as the average
    if (nums.size == 1) return nums[0].toDouble()

    var result: Double = -1.0       // Will store the final max average result
    var totalSum = 0.0              // Current sum of the sliding window of size k
    var maxAverage = 0.0            // Temporary max average during the loop

    // Step 1: Calculate the sum of the first 'k' elements (initial window)
    for (i in 0 until k) {
        totalSum += nums[i]
    }

    // Calculate average of first window
    maxAverage = totalSum / k
    result = maxAverage

    // Step 2: Slide the window one element at a time
    // For each step, subtract the element going out and add the element coming in
    if (nums.size > k) {
        for (i in k until nums.size) {
            totalSum += nums[i] - nums[i - k]           // Update window sum
            result = maxOf(maxAverage, totalSum / k)    // Check if new average is higher
            maxAverage = result                         // Update max average
        }
    }

    // Return the maximum average found
    return result
}


/**
 * Finds the maximum area of water that can be contained between two lines.
 * The input represents an array of vertical lines where the index is the position
 * and the value is the height of the line.
 *
 * Uses a two-pointer approach to optimize the solution in O(n) time.
 *
 * @param height Array representing heights of vertical lines
 * @return The maximum area of water that can be trapped
 */
fun maxArea(height: IntArray): Int {
    // Edge case: if empty or specific small case like [1,1], return area 1
    if (height.isEmpty() || (height.size == 2 && height.first() == 1 && height[1] == 1)) return 1

    var minIndex = 0              // Left pointer
    var maxIndex = height.size - 1 // Right pointer
    var maxArea = 0              // Store the maximum area found so far

    // Loop while pointers haven't crossed
    while (minIndex < maxIndex) {
        // Calculate the height as the smaller of the two lines
        val l = min(height[minIndex], height[maxIndex])

        // Calculate the width (distance between the two lines)
        val b = maxIndex - minIndex

        // Update maxArea if the current container is larger
        maxArea = max(maxArea, l * b)

        // Move the pointer that's at the shorter line inward,
        // since moving the taller line won't help increase the area
        if (height[minIndex] < height[maxIndex]) {
            minIndex++
        } else {
            maxIndex--
        }
    }

    return maxArea
}

/**
 * Checks if string `s` is a subsequence of string `t`.
 * A subsequence means all characters of `s` appear in `t` in the same order, but not necessarily contiguously.
 *
 * @param s The string to check as a subsequence
 * @param t The target string to search within
 * @return True if `s` is a subsequence of `t`, false otherwise
 */
fun isSubsequence(s: String, t: String): Boolean {
    // An empty string is always a subsequence
    if (s.isEmpty()) return true

    val sArr = s.toCharArray()  // Convert s to char array
    val tArr = t.toCharArray()  // Convert t to char array

    var sIndex = 0  // Pointer for s
    var tIndex = 0  // Pointer for t

    // Iterate through t to match characters of s
    while (tIndex < t.length) {
        // If characters match, move sIndex to look for next character in s
        if (sIndex < s.length && tArr[tIndex] == sArr[sIndex]) {
            sIndex++
        }

        // If we've matched all characters in s, it's a subsequence
        if (sIndex == s.length) return true

        // Always move tIndex forward
        tIndex++
    }

    // If loop ends without matching full s, it's not a subsequence
    return false
}


/**
 * Moves all zeroes in the array to the end while maintaining the relative order of non-zero elements.
 * This is done in-place using the two-pointer technique.
 *
 * @param nums The input array to be modified in-place
 */
fun moveZeroes(nums: IntArray): IntArray {

    println(nums.joinToString())
    var zeroIndex = -1

    nums.forEachIndexed { index, item ->
        if (item != 0) {
            if (zeroIndex != -1) {
                var temp = nums[index]
                nums[index] = nums[zeroIndex]
                nums[zeroIndex] = temp
                zeroIndex++
            }
        } else {
            if (zeroIndex == -1) zeroIndex = index
        }
    }
    return nums
}

/**
 * Compresses a character array in-place using the following rule:
 * For a group of repeating characters, replace it with the character followed by the count.
 * Only if count > 1. Returns the new length after compression.
 *
 * Example:
 * Input: ['a','a','b','b','c','c','c']
 * Output: ['a','2','b','2','c','3'], returns 6
 *
 * @param chars The input character array
 * @return The length of the compressed character array
 */
fun compress(chars: CharArray): Int {
    var writeIndex = 0  // Where to write compressed output
    var readIndex = 0   // Where to read characters

    while (readIndex < chars.size) {
        val currentChar = chars[readIndex]
        var count = 0

        // Count occurrences of the current character
        while (readIndex < chars.size && chars[readIndex] == currentChar) {
            count++
            readIndex++
        }

        // Write the character
        chars[writeIndex++] = currentChar

        // Write the count if greater than 1
        if (count > 1) {
            for (c in count.toString()) {
                chars[writeIndex++] = c
            }
        }
    }

    return writeIndex  // New length of the compressed array
}

/**
 * Checks if the input array contains an increasing triplet subsequence.
 * That means: there exist indices i < j < k such that nums[i] < nums[j] < nums[k]
 *
 * @param nums The input array of integers
 * @return True if such a triplet exists, false otherwise
 */
fun increasingTriplet(nums: IntArray = intArrayOf(1, 2, 3, 4, 5)): Boolean {
    if (nums.isEmpty() || nums.size == 1 || nums.size == 2) return false
    var first = Int.MAX_VALUE
    var second = Int.MAX_VALUE

    // check prev and next with current and run the loop
    for (i in nums) {
        when {
            (i <= first) -> first = i
            (i <= second) -> second = i
            else -> return true

        }
    }
    return false
}

/**
 * Returns an array where each element is the product of all elements in the input array
 * except the one at that index, without using division and in O(n) time.
 *
 * @param nums Input array of integers
 * @return Result array where result[i] = product of all elements except nums[i]
 */
fun productExceptSelf(nums: IntArray = intArrayOf(1, 2, 3, 4)): IntArray {
    val n = nums.size
    val left = IntArray(n) { 1 }
    val right = IntArray(n) { 1 }
    val result = IntArray(n)

    // Fill left[]: product of all elements to the left of index i
    for (i in 1 until n) {
        left[i] = left[i - 1] * nums[i - 1]
    }

    // Fill right[]: product of all elements to the right of index i
    for (i in n - 2 downTo 0) {
        right[i] = right[i + 1] * nums[i + 1]
    }

    // Final result[i] = left[i] * right[i]
    for (i in 0 until n) {
        result[i] = left[i] * right[i]
    }

    return result
}

/**
 * Reverses only the vowels in the input string, leaving other characters unchanged.
 *
 * @param s Input string
 * @return A new string with vowels reversed in their positions
 */
fun reverseVowels(s: String = "leetcode"): String {

    // Input: s = "IceCreAm"  Output: "AceCreIm"
    // Input: s = "leetcode" Output: "leotcede"

    val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    val chars = s.toCharArray()
    var left = 0
    var right = chars.size - 1

    // Two-pointer approach to swap vowels from both ends
    while (left < right) {
        // Move left pointer until a vowel is found
        while (left < right && chars[left] !in vowels) left++

        // Move right pointer until a vowel is found
        while (left < right && chars[right] !in vowels) right--

        // Swap the vowels at left and right positions
        val temp = chars[left]
        chars[left] = chars[right]
        chars[right] = temp

        // Move both pointers inward
        left++
        right--
    }

    // Convert character array back to string
    return String(chars)
}

/**
 * Determines if n new flowers can be planted in the flowerbed without violating the rule:
 * No two flowers can be planted in adjacent plots.
 *
 * @param flowerbed An IntArray where 0 = empty, 1 = planted
 * @param n The number of flowers to plant
 * @return true if it's possible to plant n flowers, otherwise false
 */
fun canPlaceFlowers(flowerbed: IntArray = intArrayOf(0, 1, 0), n: Int = 1): Boolean {
    if (flowerbed.isEmpty()) return false
    if (flowerbed.size == 1 && flowerbed[0] == 0) return true
    if (flowerbed.size == 2 && (flowerbed[0] == 1 || flowerbed[1] == 1)) return false
    if (flowerbed.size == 2 && (flowerbed[0] == 0 && flowerbed[1] == 0)) return true

    var plant = 0
    for (i in 1 until flowerbed.size) {

        if (flowerbed[i - 1] != 1 && flowerbed[i] != 1) {
            if ((i < flowerbed.size - 1) && flowerbed[i + 1] != 1) {
                plant++
            }
        }
    }

    return plant >= n
}

/**
 * Determines if each child will have the greatest number of candies after receiving extraCandies.
 *
 * For each element in the candies array, check if that child's candies + extraCandies
 * is greater than or equal to the current maximum in the array.
 *
 * @param candies Array of candies each child currently has.
 * @param extraCandies The number of extra candies to give each child.
 * @return A list of Booleans indicating whether each child can have the greatest number of candies.
 */
fun kidsWithCandies(candies: IntArray = intArrayOf(2, 3, 5, 1, 3), extraCandies: Int = 3): List<Boolean> {
    // Input: candies = [2,3,5,1,3], extraCandies = 3  Output: [true,true,true,false,true]
    // Input: candies = [4,2,1,1,2], extraCandies = 1 Output: [true,false,false,false,false]
    // Input: candies = [12,1,12], extraCandies = 10

    if (candies.isEmpty()) return listOf()
    val maxNumber = candies.max()
    var list = mutableListOf<Boolean>()

    for (i in candies) {
        if ((i + extraCandies) >= maxNumber) list.add(true) else list.add(false)
    }

    return list
}

/**
 * Returns the greatest common divisor (GCD) string of two input strings.
 * A string x is said to divide string s if s is a concatenation of x one or more times.
 *
 * For example:
 * str1 = "ABCABC", str2 = "ABC" → GCD is "ABC"
 * str1 = "LEET", str2 = "CODE" → No common divisor string → returns ""
 */
fun gcdOfStrings(str1: String = "LEET", str2: String = "CODE"): String {
    // Helper function to compute GCD of two integers
    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }

    // If concatenated in both orders are not same, there is no common base string
    if (str1 + str2 != str2 + str1) {
        return ""
    }

    val gcdLength = gcd(str1.length, str2.length)
    return str1.substring(0, gcdLength)
}

// Reverses the given array in-place by swapping elements from both ends toward the center.
fun reverseArray(list: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)): Array<Int> {
    if (list.isEmpty()) return list
    if (list.size == 1) return list

    for (i in 0 until list.size / 2) {
        // Swap the i-th element from the start with the i-th element from the end
        val temp = list[i]
        list[i] = list[list.size - 1 - i]
        list[list.size - 1 - i] = temp
    }
    return list
}

/**
 * Finds the longest consecutive subarray from an unsorted array of integers.
 * First, it sorts the array, then iterates through it to track the longest sequence
 * where each number is exactly 1 greater than the previous.
 * */
fun findMaxConsecutiveSubArrayFromArray(list: Array<Int> = arrayOf(4, 1, 7, 5, 8, 2, 3, 9, 10, 11, 12))
        : Array<Int> {
    if (list.isEmpty()) return arrayOf()
    if (list.size == 1) return list

    list.sort() // Sort the array to bring consecutive numbers together

    var prev = list[0]
    var subList = mutableListOf<Int>(list[0]) // Tracks current consecutive sequence
    var maxLengthSubList = subList.toMutableList() // Tracks longest found sequence

    for (i in 1 until list.size) {
        if ((prev + 1) == list[i]) {
            subList.add(list[i]) // Continue building the current sequence
        } else {
            // Update maxLengthSubList if current sequence is longer
            maxLengthSubList = if (subList.size > maxLengthSubList.size) subList else maxLengthSubList
            subList = mutableListOf(list[i]) // Start a new sequence
        }
        prev = list[i]
    }

    // Final check after the loop to ensure last sequence is considered
    if (subList.size > maxLengthSubList.size) {
        maxLengthSubList = subList.toMutableList()
    }
    return maxLengthSubList.toTypedArray()
}

/**
 * Finds the longest substring with all unique characters from the given string.
 * It iterates through the string while building a temporary substring without duplicates,
 * and updates the result when a repeating character is found.
 **/
fun largestUniqueSubstringFromGivenString(s: String = "yournameispankti"): String {
//    Input: "abcabcbb" → Output: "abc"
//    Input: "bbbbb" → Output: "b"
//    Input: "pwwkew" → Output: "wke"
//    Input: "abcddefgh" → Output: "defgh"
//    Input: "aabcbcdeffgh" → Output: "bcdefgh"

    if (s.isEmpty()) return ""
    if (s.length == 1) return s

    var subStr = StringBuilder()
    subStr.append(s[0]) // Start with the first character

    var largestUniqueSubString = "" // To store the longest unique substring found

    for (i in 1 until s.length) {
        if (!subStr.contains(s[i])) {
            subStr.append(s[i]) // Append non-repeating character to current substring
        } else {
            // Update result if current substring is longer
            largestUniqueSubString = if (subStr.length > largestUniqueSubString.length) subStr.toString() else largestUniqueSubString
            // Start new substring from current character
            subStr = StringBuilder()
            subStr.append(s[i])
        }
    }

    // Final check in case the last unique substring is the longest
    if (subStr.length > largestUniqueSubString.length) {
        largestUniqueSubString = subStr.toString()
    }
    return largestUniqueSubString
}

/**
 * Merges two strings by alternating characters from each.
 * If one string is longer, the remaining characters are appended at the end.
 *
 * @param word1 First input string
 * @param word2 Second input string
 * @return Merged string with alternating characters from word1 and word2
 */
fun mergeAlternately(word1: String, word2: String): String {
    val finalStr = StringBuilder()

    // Loop through the maximum length of both strings
    for (i in 0 until maxOf(word1.length, word2.length)) {
        if (i < word1.length) finalStr.append(word1[i])
        if (i < word2.length) finalStr.append(word2[i])
    }
    return finalStr.toString()
}


/**
 *
 *
 * 🔹 When to Use This Pattern
 *
 * Use sliding window when:
 *
 * Subarrays / substrings
 * Fixed size (k) OR variable size
 * Optimize from O(n²) → O(n)
 *   -------------------------------------
 * This example is basic version. In real problems:
 *  *
 *  * You don’t actually create substrings
 *  * Instead, you:
 *  * Track counts (like frequency map)
 *  * Maintain sum / max / min dynamically
 * -------------------------------------
 *  Approach:
 *  Use a fixed-size sliding window of length k.
 *  Initialize two pointers: start = 0 and end = k - 1 to form the first window.
 *  While the window is within the string:
 *    - Extract and process the current substring from start to end.
 *    - Slide the window forward by incrementing both start and end.
 *  This ensures all substrings of size k are processed in O(n) time.
 *
 * */


// todo check this always
fun slidingWindowExample(s: String, k: Int) {
    var start = 0
    var end = k - 1  // initial window end

    while (end < s.length) {
        val window = s.substring(start, end + 1) // current window
        println(window)

        // Slide window: remove first char, add next char
        start++
        end++
    }
}
