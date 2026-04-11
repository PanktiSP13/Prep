package com.pankti.l1programmingquestions

import java.util.Stack

class DSA {

    /*
    Why: StringBuilder avoids O(n^2) string concat
    DS: StringBuilder
    TC: O(n + m) | SC: O(n + m)
    */
    fun mergeAlternately(word1: String, word2: String): String {
        // Input: word1 = "abc", word2 = "pqr"
        // Output: "apbqcr"
        var finalStr = StringBuilder()

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


    /*
   Why: Handles multiple spaces correctly
   DS: List + StringBuilder internally
   TC: O(n) | SC: O(n)
   */
    fun reverseWords(s: String): String {
        return s.trim().split("\\s+".toRegex()).reversed().joinToString(" ")
    }


    /*
   Why: In-place swap using 2 pointers
   DS: Array
   TC: O(n) | SC: O(1)
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


    /*
   Why: '*' removes previous → LIFO needed
   DS: Stack
   TC: O(n) | SC: O(n)
   */
    fun removeStars(s: String): String {
        val stack = Stack<Char>()

        for (ch in s) {
            if (ch == '*') stack.pop()
            else stack.push(ch)
        }

        return stack.joinToString("")
    }


    /*
       Why: Pattern repeats → string concatenation trick
       DS: Math (Euclid GCD)
       TC: O(n) | SC: O(1)
       */
    fun gcdOfStrings(str1: String, str2: String): String {
        if (str1 + str2 != str2 + str1) return ""

        val gcdLen = gcd(str1.length, str2.length)
        return str1.substring(0, gcdLen)
    }

    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }


    /*
   Why: Matching pairs → LIFO behavior
   DS: Stack
   TC: O(n) | SC: O(n)
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


    /*
   Why: Need next greater element → monotonic decreasing stack
   DS: Stack (index-based)
   TC: O(n) | SC: O(n)
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


    /*
    Why: Precompute next greater using stack
    DS: Stack + HashMap
    TC: O(n + m) | SC: O(n)
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


    /*
   Why: Collision depends on direction → simulate using stack
   DS: Stack
   TC: O(n) | SC: O(n)
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


    /*
        Why: Need previous + next smaller → monotonic stack
        DS: Stack
        TC: O(n) | SC: O(n)
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


    /*
    Why: Find complement in O(1) instead of nested loop
    DS: HashMap (value → index)
    TC: O(n) | SC: O(n)
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


    /*
   Why: Avoid division → use prefix & suffix products
   DS: Array
   TC: O(n) | SC: O(1) (excluding output)
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

    /*
    Why: Maintain position of non-zero elements
    DS: Array (in-place)
    TC: O(n) | SC: O(1)
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


    /*
    Why: Compare unique frequencies
    DS: HashMap + Set
    TC: O(n) | SC: O(n)
    */
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val freq = HashMap<Int, Int>()

        for (num in arr) {
            freq[num] = freq.getOrDefault(num, 0) + 1
        }

        return freq.values.toSet().size == freq.size
    }


    /*
    Why: Left sum = Right sum trick
    DS: Variables only
    TC: O(n) | SC: O(1)
    */
    fun pivotIndex(nums: IntArray): Int {
        var total = nums.sum()
        var left = 0

        for (i in nums.indices) {
            total -= nums[i]
            if (left == total) return i
            left += nums[i]
        }
        return -1
    }

    /*
    Why: Set difference operation
    DS: Set
    TC: O(n + m) | SC: O(n + m)
    */
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val set1 = nums1.toSet()
        val set2 = nums2.toSet()

        return listOf(
            (set1 - set2).toList(), (set2 - set1).toList()
        )
    }


    /*
    Why: Compare with max element
    DS: Array
    TC: O(n) | SC: O(1)
    */
    fun kidsWithCandies(candies: IntArray, extra: Int): List<Boolean> {
        val max = candies.maxOrNull()!!
        return candies.map { it + extra >= max }
    }


    /*
    Why: Smallest missing → check from 1 upward
    DS: HashSet
    TC: O(n) | SC: O(n)
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


    /*
    Container With Most Water

    Why: Move smaller height to maximize area
    DS: Two pointers
    TC: O(n) | SC: O(1)
     */
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.lastIndex
        var maxArea = 0

        while (left < right) {
            val area = minOf(height[left], height[right]) * (right - left)
            maxArea = maxOf(maxArea, area)

            if (height[left] < height[right]) left++
            else right--
        }
        return maxArea
    }


    /*
    Why: Fixed window → add new, remove old
    DS: Sliding window
    TC: O(n) | SC: O(1)
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


    /*
    Why: Allow at most k zeros → shrink window when exceeded
    DS: Sliding window
    TC: O(n) | SC: O(1)
    */
    fun longestOnes(nums: IntArray, k: Int): Int {
        var left = 0
        var zeros = 0
        var maxLen = 0

        for (right in nums.indices) {
            if (nums[right] == 0) zeros++

            while (zeros > k) {
                if (nums[left] == 0) zeros--
                left++
            }

            maxLen = maxOf(maxLen, right - left + 1)
        }

        return maxLen
    }


    /*
   Why: At most 1 zero → simulate deletion
   DS: Sliding window
   TC: O(n) | SC: O(1)
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


    /*
   Why: Maintain window sum instead of recalculating
   DS: Sliding window
   TC: O(n) | SC: O(1)
   */
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var sum = 0.0

        for (i in 0 until k) sum += nums[i]

        var maxAvg = sum / k

        for (i in k until nums.size) {
            sum += nums[i] - nums[i - k]
            maxAvg = maxOf(maxAvg, sum / k)
        }

        return maxAvg
    }


    /*
    Why: Match characters in order
    DS: Two pointers
    TC: O(n) | SC: O(1)
    */
    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0
        var j = 0

        while (j < t.length) {
            if (i < s.length && s[i] == t[j]) i++
            j++
        }

        return i == s.length
    }


    /*
    Max Number of K-Sum Pairs

    Why: Sorted + two pointer reduces complexity
    DS: Array
    TC: O(n log n) | SC: O(n)
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


    /*
    Non-overlapping Intervals

   Why: Keep interval with the smallest end → more room for others
   DS: Sorting
   TC: O(n log n) | SC: O(1)
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


    /*
    Minimum Meeting Rooms

   Why: Track overlapping intervals
   DS: Two arrays + two pointers
   TC: O(n log n) | SC: O(n)
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


    /*
        Why: Count overlapping trains
        DS: Sorting + two pointers
        TC: O(n log n) | SC: O(1)
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


    /*
    Minimum Number of Arrows to Burst Balloons

   Why: Shoot arrow at earliest end
   DS: Sorting
   TC: O(n log n) | SC: O(1)
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


    /*
    Why: Merge overlapping intervals
    DS: Sorting + list
    TC: O(n log n) | SC: O(n)
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


    /*
    Insert Interval

    Why: Handle before, overlap, after cases
    DS: List
    TC: O(n) | SC: O(n)
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
     * Overflow → use left + (right - left)/2 ✅
     * Duplicates
     * */

    /*
    Why: Divide search space by half
    DS: Array
    TC: O(log n) | SC: O(1)
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


    /*
   Why: Move toward increasing slope
   DS: Array
   TC: O(log n) | SC: O(1)
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



}



