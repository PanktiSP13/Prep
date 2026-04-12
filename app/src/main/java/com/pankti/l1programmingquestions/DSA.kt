package com.pankti.l1programmingquestions

import java.util.Stack
import kotlin.math.max
import kotlin.math.min

class DSA {

    /**
    Why: StringBuilder avoids O(n^2) string concat
    DS: StringBuilder
    TC: O(n + m) | SC: O(n + m)

    Approach:
    1. If both strings are empty, return an empty string
    2. Initialize a StringBuilder to store the result
    3. Loop from index 0 to the maximum length of both strings
    4. At each index, add character from word1 if it exists
    5. Then add character from word2 if it exists
    6. Continue alternating characters until loop ends
    7. Convert StringBuilder to string and return result
    */
    fun mergeAlternately(word1: String, word2: String): String {
        val finalStr = StringBuilder()

        for (i in 0 until maxOf(word1.length, word2.length)) {
            if (i < word1.length) {
                finalStr.append(word1[i])
            }

            if (i < word2.length) {
                finalStr.append(word2[i])
            }
        }
        return finalStr.toString()
    }


    /**
   Why: Handles multiple spaces correctly
   DS: List + StringBuilder internally
   TC: O(n) | SC: O(n)

   Approach:
   1. Check if string is not empty
   2. Split the string into words using space
   3. Traverse the list from last to first (reverse order)
   4. Add each word to result string
   5. Add space between words (avoid extra space at end)
   6. Trim and return final result
   */
    fun reverseWords(s: String): String {
        val finalStr = StringBuilder()
        if (s.isNotEmpty()) {
            val strList = s.split("\\s+".toRegex())
            println(strList.size)
            for (i in strList.size - 1 downTo 0) {
                finalStr.append(strList[i])
                if (i != 0) {
                    finalStr.append(" ")
                }
            }
        }
        return finalStr.toString().trim()
    }

    /**
   Why: In-place swap using 2 pointers
   DS: Array
   TC: O(n) | SC: O(1)

   Approach:
   1. If the string is empty or has only one character, return it as is
   2. Convert the string into a character array for easy swapping
   3. Initialize two pointers: i at the start and j at the end
   4. Move i forward until a vowel is found
   5. Move j backward until a vowel is found
   6. If both positions have vowels, swap them
   7. After swapping, move both pointers inward (i++, j--)
   8. Repeat until i >= j
   9. Convert the character array back to string and return result
   */
    fun reverseVowels(s: String): String {
        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        val arr = s.toCharArray()
        var l = 0
        var r = arr.lastIndex

        while (l < r) {
            while (l < r && arr[l] !in vowels) l++
            while (l < r && arr[r] !in vowels) r--

            val temp = arr[l]
            arr[l] = arr[r]
            arr[r] = temp

            l++; r--
        }
        return String(arr)
    }


    /**
   Why: '*' removes previous → LIFO needed
   DS: Stack
   TC: O(n) | SC: O(n)

   Approach:
   1. If the string is empty or has only one non-* character, return it as is
   2. Initialize a StringBuilder to use as a result (acts like a stack)
   3. Traverse each character of the string
   4. If the character is not '*', append it to StringBuilder
   5. If the character is '*', remove the last character from StringBuilder (if not empty)
   6. Continue this process for all characters
   7. Return the final StringBuilder as a string
   */
    fun removeStars(s: String): String {
        if (s.isEmpty()) return s
        if (s.length == 1 && s != "*") return s

        val str = StringBuilder()

        for (i in s) {
            if (i != '*') {
                str.append(i)
            } else if (str.isNotEmpty()) {
                str.deleteCharAt(str.length - 1)
            }
        }

        return str.toString()

    }


    /**
       Why: Pattern repeats → string concatenation trick
       DS: Math (Euclid GCD)
       TC: O(n) | SC: O(1)

       Approach:
       1. Check if concatenating both strings in different orders gives the same result
       (str1 + str2 should be equal to str2 + str1); if not, return empty string
       2. This ensures both strings are made by repeating a common base string
       3. Find the GCD (Greatest Common Divisor) of lengths of both strings
       4. The GCD length represents the maximum possible length of the common base string
       5. Take substring of str1 from 0 to gcd length
       6. Return this substring as the result

       */
    fun gcdOfStrings(str1: String, str2: String): String {
        if (str1 + str2 != str2 + str1) return ""

        val gcdLen = gcd(str1.length, str2.length)
        return str1.substring(0, gcdLen)
    }

    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }


    /**
    Why: Maintain position of non-zero elements
    DS: Array (in-place)
    TC: O(n) | SC: O(1)

    Approach:
    1. Initialize a pointer (nonZeroIndex) to track position for next non-zero element
    2. Traverse the array from start to end
    3. If current element is non-zero:
    - Swap it with element at nonZeroIndex
    - Increment nonZeroIndex
    4. This ensures all non-zero elements are moved to the front
    5. All zeros automatically shift to the end
    6. Do everything in-place without using extra space
     */
    fun moveZeroes(nums: IntArray): IntArray {
        var nonZeroIndex = 0

        for (i in nums.indices) {
            if (nums[i] != 0) {
                val t = nums[i]
                nums[i] = nums[nonZeroIndex]
                nums[nonZeroIndex] = t
                nonZeroIndex++
            }
        }
        return nums
    }


    /**
    Why: Match characters in order
    DS: Two pointers
    TC: O(n) | SC: O(1)

    Approach:
    1. If string s is empty, return true
    2. If t is shorter than s, return false
    3. Initialize two pointers: sIndex for s and tIndex for t
    4. Traverse string t from left to right
    5. If characters match (t[tIndex] == s[sIndex]), move sIndex forward
    6. Always move tIndex forward to keep scanning t
    7. If sIndex reaches end of s, it means all characters are found in order → return true
    8. If loop ends and s is not fully matched → return false
     */
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) return true
        if (t.length < s.length) return false

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


    /**
    Why: Maintain window sum instead of recalculating
    DS: Sliding window
    TC: O(n) | SC: O(1)


    Approach:
    1. If array has only one element, return it as double
    2. Calculate sum of first k elements (initial window)
    3. Compute average of this window and store as maxAverage/result
    4. Slide the window across the array from index k to end
    5. For each step:
    - Add next element to sum
    - Remove element that goes out of window (i - k)
    6. Calculate new average for current window
    7. Update result with maximum average found so far
    8. Continue until end of array
    9. Return the maximum average
     */
    fun findMaxAverage(nums: IntArray = intArrayOf(1, 12, -5, -6, 50, 3), k: Int = 4): Double {
        if (nums.size == 1) return nums[0].toDouble()
        var totalSum = 0.0

        for (i in 0 until k) {
            totalSum += nums[i]
        }
        var maxAverage = totalSum / k

        if (nums.size > k) {
            for (i in k until nums.size) {
                totalSum += nums[i] - nums[i - k]
                maxAverage = maxOf(maxAverage, totalSum / k)
            }
        }
        return maxAverage
    }


    /**
    Find the Highest Altitude
    DS: Prefix Sum
    TC: O(n) | SC: O(1)

    Approach:
    1. Initialize altitude = 0 (starting point)
    2. Initialize maxAltitude = 0 to track the highest point reached
    3. Traverse each value in the gain array
    4. Add current gain to altitude to get new altitude
    5. Update maxAltitude if current altitude is greater
    6. Continue for all elements
    7. Return maxAltitude as the highest altitude reached
     * */
    fun largestAltitude(gain: IntArray): Int {
        var maxAltitude = 0
        var altitude = 0

        for (i in gain) {
            altitude += i
            maxAltitude = max(maxAltitude, altitude)
        }
        return maxAltitude
    }


    /**
    Why: Left sum = Right sum trick
    DS: Variables only
    TC: O(n) | SC: O(1)

    Approach:
    1. Calculated total sum and treated it as right sum
    2. Initialized left sum as 0
    3. Traversed the array element by element
    4. Reduced current element from right sum to get right-side sum
    5. Compared left sum and right sum at each index
    6. If both matched, returned the current index as pivot
    7. Otherwise, added current element to left sum and continued
    8. Returned -1 if no pivot index was found
     */
    fun pivotIndex(nums: IntArray): Int {
        if (nums.isEmpty()) return -1

        var rightSum = nums.sum() // O(n)
        var leftSum = 0

        nums.forEachIndexed { index, i ->
            rightSum -= i
            if (leftSum == rightSum) {
                return index
            }
            leftSum += i
        }
        return -1
    }


    /**
    Rotation of array n times
     * DS : Array
     * TC: O(n) | SC: O(1)
     *
    Approach:
    1. Calculated effective rotations using k % n to handle cases where k > array size
    2. Reversed the entire array to bring last elements to the front
    3. Reversed the first k elements to restore their correct order
    4. Reversed the remaining elements to restore their original order
    5. Used a helper function to reverse elements by swapping from both ends
    6. Achieved rotation in-place without using extra space
     * */
    fun rotate(nums: IntArray, k: Int) {
        val n = nums.size
        val steps = k % n  // handle k > n

        // Step 1: Reverse whole array
        reverse(nums, 0, n - 1)

        // Step 2: Reverse first k elements
        reverse(nums, 0, steps - 1)

        // Step 3: Reverse remaining elements
        reverse(nums, steps, n - 1)
    }

    fun reverse(nums: IntArray, start: Int, end: Int) {
        var left = start
        var right = end

        while (left < right) {
            val temp = nums[left]
            nums[left] = nums[right]
            nums[right] = temp
            left++
            right--
        }
    }

    /**
   Why: Matching pairs → LIFO behavior
   DS: Stack
   TC: O(n) | SC: O(n)

   Approach:
   1. Used a stack to keep track of opening brackets
   2. Created a map to store matching pairs of closing → opening brackets
   3. Traversed each character of the string
   4. If it is an opening bracket, pushed it onto the stack
   5. If it is a closing bracket:
   - Checked if stack is empty or top doesn't match → return false
   - Otherwise, popped the top element
   6. After traversal, checked if stack is empty
   7. If empty, all brackets matched → return true, else return false
   */
    fun isValidParentheses(s: String): Boolean {
        val stack = Stack<Char>()
        val map = mapOf(')' to '(', '}' to '{', ']' to '[')

        for (ch in s) {
            if (ch in map.values) stack.push(ch)
            else {
                if (stack.isEmpty() || stack.pop() != map[ch]) return false
            }
        }
        return stack.isEmpty()
    }


    /**
    Why: Find complement in O(1) instead of nested loop
    DS: HashMap (value → index)
    TC: O(n) | SC: O(n)

    Approach:
    1. Used a HashMap to store numbers and their indices
    2. Traversed the array element by element
    3. For each element, calculated its complement (target - current value)
    4. Checked if the complement already exists in the map
    5. If found, returned indices of complement and current element
    6. If not found, stored current element with its index in the map
    7. Continued until a valid pair was found
    8. Returned empty array if no such pair exists
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i)
            }
            map[nums[i]] = i
        }
        return intArrayOf()
    }


    /**
    Why: Compare unique frequencies
    DS: HashMap + Set
    TC: O(n) | SC: O(n)

    Approach:
    1. Used a HashMap to count frequency of each element in the array
    2. Traversed the array and updated count using getOrDefault
    3. Extracted all frequency values from the map
    4. Converted frequencies into a Set to remove duplicates
    5. Compared size of Set with size of map
    6. If sizes are equal, all frequencies are unique → return true
    7. Otherwise, return false

     */
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val freq = HashMap<Int, Int>()

        for (num in arr) {
            freq[num] = freq.getOrDefault(num, 0) + 1
        }

        return freq.values.toSet().size == freq.size
    }


    /**
    Why: Compare with max element
    DS: Array
    TC: O(n) | SC: O(n)

    Approach:
    1. If the array is empty, return an empty list
    2. Find the maximum number of candies among all kids
    3. Traverse each element in the array
    4. For each kid, add extraCandies to their current candies
    5. Check if the new value is greater than or equal to the maximum
    6. Store the result (true/false) in a list
    7. Return the final list of boolean values
     */
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        if (candies.isEmpty()) return listOf()
        val maxNumber = candies.max()
        val list = candies.map { (it + extraCandies) >= maxNumber }
        return list
    }


    /**
    Why: Set difference operation
    DS: Set
    TC: O(n + m) | SC: O(n + m)

    Approach:
    1. Converted both arrays into sets to remove duplicates
    2. Found elements present in set1 but not in set2 using set difference
    3. Found elements present in set2 but not in set1 using set difference
    4. Converted both results into lists
    5. Returned both lists as a list of lists
     */
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {

        val set1 = nums1.toSet()
        val set2 = nums2.toSet()
        // Find elements unique to each array
        val diff1 = set1 - set2 // Elements in nums1 but not in nums2
        val diff2 = set2 - set1 // Elements in nums2 but not in nums1

        return listOf(diff1.toList(), diff2.toList())
    }


    /**
    Container With Most Water

    Why: Move smaller height to maximize area
    DS: Two pointers
    TC: O(n) | SC: O(1)

    Approach:
    1. Used two pointers: one at the start and one at the end of the array
    2. Calculated area using minimum of two heights and distance between them
    3. Tracked maximum area found so far
    4. Moved the pointer with smaller height inward to try getting a better area
    5. Repeated this process until both pointers meet
    6. Returned the maximum area obtained
     */
    fun maxArea(height: IntArray): Int {
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


    /**
    Why: Fixed window → add new, remove old
    DS: Sliding window
    TC: O(n) | SC: O(1)

    Approach:
    1. Used a set to quickly check if a character is a vowel
    2. Handled edge cases for empty and single-character strings
    3. Calculated number of vowels in the first window of size k
    4. Stored this as the initial maximum
    5. Slid the window across the string from index k to end
    6. Added vowel count for the new incoming character
    7. Removed vowel count for the outgoing character (i - k)
    8. Updated maximum vowel count at each step
    9. Returned the maximum vowels found in any window of size k
     */
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


    /**
    Why: Allow at most k zeros → shrink window when exceeded
    DS: Sliding window
    TC: O(n) | SC: O(1)

    Approach:
    1. Use a sliding window with two pointers (left and right)
    2. Traverse the array using the right pointer
    3. Count number of zeros in the current window
    4. Allow at most k zeros in the window
    5. If zeros exceed k, shrink the window from the left until valid
    6. Continuously calculate window size (right - left + 1)
    7. Track the maximum length of valid window
    8. Return the maximum length found
     */
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


    /**
    Minimum Meeting Rooms

    Why: Track overlapping intervals
    DS: Two arrays + two pointers
    TC: O(n log n) | SC: O(n)

    Approach:
    1. Separated all start times and end times into two lists
    2. Sorted both lists independently
    3. Used two pointers to traverse start and end times
    4. Compared next meeting start with the earliest ending meeting
    5. If a meeting starts before another ends, increased room count
    6. If a meeting ends before next starts, freed a room (decreased count)
    7. Tracked the maximum number of rooms needed at any point
    8. Returned the maximum rooms required
     */
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0

        val start = intervals.map { it[0] }.sorted()
        val end = intervals.map { it[1] }.sorted()

        var rooms = 0
        var maxRooms = 0
        var i = 0
        var j = 0

        while (i < intervals.size) {
            if (start[i] < end[j]) {
                rooms++
                maxRooms = maxOf(maxRooms, rooms)
                i++
            } else {
                rooms--
                j++
            }
        }
        return maxRooms
    }


    /**
    Why: Count overlapping trains
    DS: Sorting + two pointers
    TC: O(n log n) | SC: O(1)

    Approach:
    1. Sorted arrival and departure times separately
    2. Used two pointers to track current arrival and departure
    3. Compared next train arrival with the earliest departure
    4. If a train arrives before or at the same time as departure, increased platform count
    5. If a train departs before next arrival, decreased platform count
    6. Tracked maximum platforms needed at any time
    7. Continued until all arrivals are processed
    8. Returned the maximum platforms required
     */
    fun minPlatforms(arrival: IntArray, departure: IntArray): Int {
        arrival.sort()
        departure.sort()

        var i = 0
        var j = 0
        var platforms = 0
        var maxPlatforms = 0

        while (i < arrival.size) {
            if (arrival[i] <= departure[j]) {
                platforms++
                maxPlatforms = maxOf(maxPlatforms, platforms)
                i++
            } else {
                platforms--
                j++
            }
        }

        return maxPlatforms
    }

    /**
    Non-overlapping Intervals

    Why: Keep interval with the smallest end → more room for others
    DS: Sorting
    TC: O(n log n) | SC: O(1)

    Approach:
    1. Sorted intervals based on their end time to prioritize the earliest finishing intervals
    2. Initialized end with the end time of the first interval
    3. Traversed remaining intervals one by one
    4. Compared current interval’s start with the tracked end
    5. If current start is less than end, overlap is detected → increment remove count
    6. If no overlap, updated end to current interval’s end
    7. Continued this process for all intervals
    8. Returned total number of intervals removed
     */
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.isEmpty()) return 0

        intervals.sortBy { it[1] } // sort by end time
        var end = intervals[0][1]
        var remove = 0

        for (i in 1 until intervals.size) {
            if (intervals[i][0] < end) {
                remove++
            } else {
                end = intervals[i][1]
            }
        }
        return remove
    }


    /**
     *
     * 🧠 Core Idea
     *
     * 👉 Binary Search works when:
     *
     * Array is sorted
     * Or can be converted to sorted logic
     *
     * ⚠️ Important Edge Cases
     * Empty array
     * Single element
     * Overflow → use left + (right - left)/2 ✅(“Find middle between left and right, not whole array”)
     * Duplicates
     * */
    /**
    Why: Divide search space by half
    DS: Array
    TC: O(log n) | SC: O(1)

    Approach:
    1. Initialized two pointers: left at start and right at end of array
    2. Repeated the process while left is less than or equal to right
    3. Calculated mid-index to divide the search space
    4. Compared target with middle element
    5. If equal, returned the index
    6. If target is greater, moved left pointer to mid + 1
    7. If target is smaller, moved right pointer to mid - 1
    8. Continued narrowing the search space
    9. Returned -1 if target not found
     */
    fun binarySearch(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2

            when {
                nums[mid] == target -> return mid
                nums[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return -1
    }


    /**
    Why: Need next greater element → monotonic decreasing stack
    DS: Stack (index-based)
    TC: O(n) | SC: O(n)

    Approach:
    1. Initialized an array to store result (days to wait)
    2. Used a stack to store indices of temperatures
    3. Traversed the array from left to right
    4. For each temperature:
    - While stack is not empty AND current temperature > temperature at stack top:
    - Pop index from stack
    - Calculate difference (current index - popped index)
    - Store it in result array
    5. Push current index onto stack
    6. Remaining indices in stack have no warmer days → default 0
    7. Return result array
     */
    fun dailyTemperatures(temp: IntArray): IntArray {
        val res = IntArray(temp.size)
        val stack = Stack<Int>() // store indices

        for (i in temp.indices) {
            while (stack.isNotEmpty() && temp[i] > temp[stack.peek()]) {
                val prevIndex = stack.pop()
                res[prevIndex] = i - prevIndex
            }
            stack.push(i)
        }
        return res
    }


    /**
    Why: Precompute next greater using stack
    DS: Stack + HashMap
    TC: O(n + m) | SC: O(n)

    Approach:
    1. Used a stack to track elements whose next greater is not found
    2. Traversed nums2:
    - While stack is not empty AND current number > stack top:
    - Pop element and map it to current number (next greater)
    3. Push current number to stack
    4. After traversal, assign -1 for remaining elements in stack
    5. For nums1:
    - Lookup each element in map
    - Return mapped value or -1 if not found
    6. Return result array
     */
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val map = HashMap<Int, Int>()
        val stack = Stack<Int>()

        for (num in nums2) {
            while (stack.isNotEmpty() && num > stack.peek()) {
                map[stack.pop()] = num
            }
            stack.push(num)
        }

        while (stack.isNotEmpty()) {
            map[stack.pop()] = -1
        }

        return nums1.map { map[it] ?: -1 }.toIntArray()
    }


    /**
    Why: Collision depends on direction → simulate using stack
    DS: Stack
    TC: O(n) | SC: O(n)

    Approach:
    1. Used a stack to simulate asteroid movement
    2. Traversed each asteroid:
    - Assume current asteroid is alive
    3. While:
    - Current asteroid is moving left (negative)
    - Stack top is moving right (positive)
    → Collision happens
    4. Compare sizes:
    - If stack top is smaller → pop it
    - If equal → pop and mark current as destroyed
    - If stack top is larger → current gets destroyed
    5. If current asteroid survives → push into stack
    6. Return stack as array
     */
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()

        for (ast in asteroids) {
            var alive = true

            while (alive && ast < 0 && stack.isNotEmpty() && stack.peek() > 0) {
                val top = stack.peek()

                when {
                    top < -ast -> stack.pop()
                    top == -ast -> {
                        stack.pop()
                        alive = false
                    }

                    else -> alive = false
                }
            }

            if (alive) stack.push(ast)
        }

        return stack.toIntArray()
    }


    /**
    Why: Need previous + next smaller → monotonic stack
    DS: Stack
    TC: O(n) | SC: O(n)

    Approach:
    1. Used a stack to store indices of increasing heights
    2. Traversed array including one extra iteration (i = n)
    3. For each index:
    - Treat height as 0 when i == n (forces stack cleanup)
    4. While stack is not empty AND current height < height at stack top:
    - Pop index
    - Calculate height = popped value
    - Calculate width:
    - If stack empty → width = i
    - Else → width = i - stack.peek() - 1
    - Update max area
    5. Push current index into stack
    6. Return max area
     */
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = Stack<Int>()
        var maxArea = 0

        for (i in 0..heights.size) {
            val h = if (i == heights.size) 0 else heights[i]

            while (stack.isNotEmpty() && h < heights[stack.peek()]) {
                val height = heights[stack.pop()]
                val width = if (stack.isEmpty()) i else i - stack.peek() - 1
                maxArea = maxOf(maxArea, height * width)
            }
            stack.push(i)
        }

        return maxArea
    }

    /**
     * 💥 Interview Tip
     *
     * When you see:
     *
     * “next greater”
     * “nearest smaller”
     * “temperature”
     * “span”
     * “histogram”
     *
     * 👉 Immediately think: STACK
     * */


    /**
    Why: Avoid division → use prefix & suffix products
    DS: Array
    TC: O(n) | SC: O(1) (excluding output)

    Approach:
    1. Initialized result array
    2. Traverse left to right:
    - Store prefix product at each index
    3. Traverse right to left:
    - Multiply existing value with suffix product
    4. Maintain prefix and suffix variables separately
    5. Final result contains product of all elements except self
    6. Return result array
     */
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size)

        var prefix = 1
        for (i in nums.indices) {
            res[i] = prefix
            prefix *= nums[i]
        }

        var suffix = 1
        for (i in nums.indices.reversed()) {
            res[i] *= suffix
            suffix *= nums[i]
        }

        return res
    }


    /**
    Why: Smallest missing → check from 1 upward
    DS: HashSet
    TC: O(n) | SC: O(n)

    Approach:
    1. Insert all elements into a HashSet
    2. Start checking from number 1
    3. If current number is not present in set → return it
    4. Otherwise, increment and continue
    5. First missing positive number is returned
     */
    fun firstMissingPositive(nums: IntArray): Int {
        val set = nums.toHashSet()

        var i = 1
        while (true) {
            if (!set.contains(i)) return i
            i++
        }
    }


    /**
     * When to use Hashing?
     *
     * | Problem Type           | Use     |
     * | ---------------------- | ------- |
     * | Find pair (target sum) | HashMap |
     * | Frequency count        | HashMap |
     * | Uniqueness             | Set     |
     * | Missing element        | Set     |
     *
     * */


    /**
     * 🧠 Core Idea
     * Two Pointer → optimize from both ends
     * Sliding Window → optimize subarray/substring problems
     * */


    /**
    Why: At most 1 zero → simulate deletion
    DS: Sliding window
    TC: O(n) | SC: O(1)

    Approach:
    1. Used sliding window with left and right pointers
    2. Count number of zeros in current window
    3. Traverse using right pointer:
    - If element is 0 → increment zero count
    4. If zeros > 1:
    - Move left pointer forward
    - Reduce zero count if needed
    5. Calculate window size as (right - left)
    (since one element is deleted)
    6. Track maximum length
    7. Return max length
     */
    fun longestSubarray(nums: IntArray): Int {
        var left = 0
        var zeros = 0
        var maxLen = 0

        for (right in nums.indices) {
            if (nums[right] == 0) zeros++

            while (zeros > 1) {
                if (nums[left] == 0) zeros--
                left++
            }

            maxLen = maxOf(maxLen, right - left)
        }

        return maxLen
    }


    /**
    Why: Sorted + two pointer reduces complexity
    DS: Array
    TC: O(n log n) | SC: O(n)

    Approach:
    1. Sort the array
    2. Use two pointers:
    - Left at start
    - Right at end
    3. While left < right:
    - Calculate sum of both elements
    4. If sum == k:
    - Increment count
    - Move both pointers inward
    5. If sum < k → move left pointer
    6. If sum > k → move right pointer
    7. Return total count of valid pairs
     */
    fun maxOperations(nums: IntArray, k: Int): Int {
        val sorted = nums.sorted()
        var left = 0
        var right = sorted.lastIndex
        var count = 0

        while (left < right) {
            val sum = sorted[left] + sorted[right]

            when {
                sum == k -> {
                    count++
                    left++; right--
                }

                sum < k -> left++
                else -> right--
            }
        }
        return count
    }


    /**
     * When to use Sliding Window?
     *
     * | Problem Type         | Signal |
     * | -------------------- | ------ |
     * | Subarray / substring | ✅      |
     * | Max / Min length     | ✅      |
     * | Fixed size (k)       | ✅      |
     * | “At most k”          | ✅      |
     *
     * */


    /**
     * 💥 Interview Trick (SUPER IMPORTANT)
     *
     * When you see:
     *
     * “Longest substring”
     * “Maximum subarray”
     * “At most k”
     * “Exactly k window”
     *
     * 👉 Immediately think: Sliding Window
     * */


    /**
    Why: Shoot arrow at earliest end
    DS: Sorting
    TC: O(n log n) | SC: O(1)

    Approach:
    1. Sort intervals based on end points
    2. Initialize arrows = 1 and end = first interval end
    3. Traverse remaining intervals:
    - If current start > end:
    → Need new arrow
    → Increment arrows
    → Update end
    4. Else:
    - Current balloon can be burst with same arrow
    5. Return total arrows required
     */
    fun findMinArrowShots(points: Array<IntArray>): Int {
        if (points.isEmpty()) return 0

        points.sortBy { it[1] }

        var arrows = 1
        var end = points[0][1]

        for (i in 1 until points.size) {
            if (points[i][0] > end) {
                arrows++
                end = points[i][1]
            }
        }
        return arrows
    }


    /**
    Why: Merge overlapping intervals
    DS: Sorting + List
    TC: O(n log n) | SC: O(n)

    Approach:
    1. Sort intervals based on start time
    2. Initialize current interval as first interval
    3. Traverse remaining intervals:
    - If overlapping:
    → Merge by updating end = max(end, current end)
    - Else:
    → Add current interval to result
    → Update current interval
    4. Add last interval to result
    5. Convert list to array and return
     */
    fun mergeIntervals(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) return arrayOf()

        intervals.sortBy { it[0] }
        val result = mutableListOf<IntArray>()

        var current = intervals[0]

        for (i in 1 until intervals.size) {
            if (intervals[i][0] <= current[1]) {
                current[1] = maxOf(current[1], intervals[i][1])
            } else {
                result.add(current)
                current = intervals[i]
            }
        }

        result.add(current)
        return result.toTypedArray()
    }


    /**
    Why: Handle before, overlap, after cases
    DS: List
    TC: O(n) | SC: O(n)

    Approach:
    1. Initialize result list
    2. Add all intervals that end before new interval starts
    3. Merge overlapping intervals:
    - Update start = min(start)
    - Update end = max(end)
    4. Add merged interval to result
    5. Add remaining intervals after merge
    6. Convert list to array and return
     */
    fun insertInterval(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        var i = 0

        // before overlap
        while (i < intervals.size && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++])
        }

        // merge overlap
        var start = newInterval[0]
        var end = newInterval[1]

        while (i < intervals.size && intervals[i][0] <= end) {
            start = minOf(start, intervals[i][0])
            end = maxOf(end, intervals[i][1])
            i++
        }

        result.add(intArrayOf(start, end))

        // remaining
        while (i < intervals.size) {
            result.add(intervals[i++])
        }

        return result.toTypedArray()
    }

    /**
     * A greedy algorithm is an approach for solving a problem by selecting the best option available at the moment.
     * It doesn't worry whether the current best result will bring the overall optimal result.
     *
     * Most interval problems follow:
     *
     * Sort first
     * Then greedily pick/skip
     *
     * When to use Greedy?
     *
     * | Signal                      | Meaning |
     * | --------------------------- | ------- |
     * | Intervals                   | ✅       |
     * | Scheduling                  | ✅       |
     * | Minimum / Maximum selection | ✅       |
     * | Overlapping ranges          | ✅       |
     *
    * */


    /**
    Why: Move toward increasing slope
    DS: Array
    TC: O(log n) | SC: O(1)

    Approach:
    1. Used binary search approach
    2. Initialize left and right pointers
    3. While left < right:
    - Find mid
    4. Compare nums[mid] with nums[mid + 1]:
    - If increasing → move right (left = mid + 1)
    - Else → move left (right = mid)
    5. Continue until pointers meet
    6. Return index (peak element)
     */
    fun findPeakElement(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex

        while (left < right) {
            val mid = (left + right) / 2

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }

    /**
    Why: Frequency count comparison
    DS: HashMap
    TC: O(n) | SC: O(n)

    Approach:
    1. If lengths of both strings are not equal → return false
    2. Initialize a HashMap to store frequency of characters from string s
    3. Traverse string s:
    - Increment count of each character in map
    4. Traverse string t:
    - If character not present in map → return false
    - Decrement its count in map
    - If count becomes 0 → remove character from map
    5. After traversal, check if map is empty:
    - If empty → both strings have same frequency → return true
    - Else → return false
     */
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val map = HashMap<Char, Int>()

        for (ch in s) {
            map[ch] = map.getOrDefault(ch, 0) + 1
        }

        for (ch in t) {
            if (!map.containsKey(ch)) return false
            map[ch] = map[ch]!! - 1
            if (map[ch] == 0) map.remove(ch)
        }

        return map.isEmpty()
    }


    /**
    Why: Same characters → same sorted order
    DS: Array (sorting)
    TC: O(n log n) | SC: O(n)

    Approach:
    1. If lengths of both strings are not equal → return false
    2. Convert both strings into character arrays
    3. Sort both arrays
    4. Compare sorted arrays:
    - If equal → strings are anagrams
    - Else → not anagrams
    5. Return comparison result
     */
    fun isAnagram2(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        return s.toCharArray().sorted() == t.toCharArray().sorted()
    }

}



