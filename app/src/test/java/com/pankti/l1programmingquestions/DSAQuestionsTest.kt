package com.pankti.l1programmingquestions

import com.google.gson.Gson
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals

/*class DSAQuestionsTest {

    private val dsaQuestions = DSAQuestions()

    @Test
    fun mergeAlternately_givenEqualLengthStrings_returnsMergedString() {
        assertEquals("apbqcr", dsaQuestions.mergeAlternately("abc", "pqr"))
    }

    @Test
    fun mergeAlternately_givenOneShorterString_returnsMergedWithRemaining() {
        assertEquals("abxy", dsaQuestions.mergeAlternately("a", "bxy"))
    }

    @Test
    fun reverseWords_givenSentenceWithSpaces_returnsReversedWords() {
        assertEquals("example good a", dsaQuestions.reverseWords("a good  example"))
    }

    @Test
    fun decodeString_givenNestedEncoding_returnsDecodedString() {
        assertEquals("accaccacc", dsaQuestions.decodeString("3[a2[c]]"))
    }

    @Test
    fun dailyTemperatures_givenTemperatureArray_returnsWaitDaysArray() {
        val input = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
        val expected = intArrayOf(1, 1, 4, 2, 1, 1, 0, 0)
        assertArrayEquals(expected, dsaQuestions.dailyTemperatures(input))
    }

    @Test
    fun twoSum_givenValidPair_returnsCorrectIndices() {
        assertArrayEquals(intArrayOf(0, 1), dsaQuestions.twoSum(intArrayOf(2, 7, 11, 15), 9))
    }

    @Test
    fun findFirstNonRepeatingCharIndex_givenStringWithRepeatingChars_returnsCorrectIndex() {
        assertEquals(0, dsaQuestions.findFirstNonRepeatingCharIndex("leetcode"))
    }

    @Test
    fun isValidParenthesesOrder_givenValidString_returnsTrue() {
        assertTrue(dsaQuestions.isValidParenthesesOrder("()[]{}"))
    }

    @Test
    fun isValidParenthesesOrder_givenInvalidString_returnsFalse() {
        assertFalse(dsaQuestions.isValidParenthesesOrder("(]"))
    }

    @Test
    fun nextGreaterElement_givenArray_returnsCorrectNextGreaterElements() {
        val expected = intArrayOf(-1, 3, -1)
        assertArrayEquals(expected, dsaQuestions.nextGreaterElement(intArrayOf(4, 1, 2), intArrayOf(1, 3, 4, 2)))
    }

    @Test
    fun binarySearch_givenElementExists_returnsCorrectIndex() {
        assertEquals(4, dsaQuestions.binarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 5))
    }

    @Test
    fun binarySearch_givenElementNotExists_returnsMinusOne() {
        assertEquals(-1, dsaQuestions.binarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 10))
    }

    @Test
    fun gcd_givenTwoNumbers_returnsCorrectGCD() {
        assertEquals(4, dsaQuestions.gcd(8, 36))
    }

    @Test
    fun kidsWithCandies_givenCandiesArray_returnsCorrectBooleanList() {
        assertEquals(listOf(true, true, true, false, true), dsaQuestions.kidsWithCandies(intArrayOf(2, 3, 5, 1, 3), 3))
    }

    @Test
    fun canPlaceFlowers_givenValidPlot_returnsTrue() {
        assertTrue(dsaQuestions.canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 1))
    }

    @Test
    fun canPlaceFlowers_givenInvalidPlot_returnsFalse() {
        assertFalse(dsaQuestions.canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 2))
    }

    @Test
    fun uniqueOccurrences_givenValidArray_returnsTrue() {
        assertTrue(dsaQuestions.uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3)))
    }

    @Test
    fun moveZeroes_givenArrayWithZeros_movesZerosToEnd() {
        assertArrayEquals(intArrayOf(1, 3, 12, 0, 0), dsaQuestions.moveZeroes(intArrayOf(0, 1, 0, 3, 12)))
    }

    @Test
    fun isSubsequence_givenValidSubsequence_returnsTrue() {
        assertTrue(dsaQuestions.isSubsequence("abc", "ahbgdc"))
    }

    @Test
    fun isSubsequence_givenInvalidSubsequence_returnsFalse() {
        assertFalse(dsaQuestions.isSubsequence("axc", "ahbgdc"))
    }

    @Test
    fun maxArea_givenHeightArray_returnsMaxWaterContainerArea() {
        assertEquals(49, dsaQuestions.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    }

    @Test
    fun findMaxAverage_givenSlidingWindowArray_returnsMaxAverage() {
        assertEquals(12.75, dsaQuestions.findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4))
    }
}*/


class DSAQuestionsTest {

    private val dsaQuestions = DSAQuestions()

    @Test
    fun mergeAlternately() {
        println("mergeAlternately : ${dsaQuestions.mergeAlternately("abc", "pqr")}")
    }

    @Test
    fun reverseWords() {
        println("reverseWords :  ${dsaQuestions.reverseWords("a good  example")}")
    }

    @Test
    fun decodeString() {
        println("decodeString :  ${dsaQuestions.decodeString("3[a]2[bc]")}")
    }


    @Test
    fun dailyTemperatures() {
        println("searchBST :  ${Gson().toJson(dsaQuestions.dailyTemperatures())}")
    }

    @Test
    fun twoSum() {
        println("twoSum :  ${Gson().toJson(dsaQuestions.twoSum())}")
    }

    @Test
    fun findFirstNonRepeatingCharIndex() {
        println("findFirstNonRepeatingCharIndex :  ${dsaQuestions.findFirstNonRepeatingCharIndex()}")
    }

    @Test
    fun findNonRepeatingCharIndex() {
        println("findNonRepeatingCharIndex : ${dsaQuestions.findNonRepeatingCharIndex()}")
    }

    @Test
    fun isValidParenthesesOrder() {
        val testList = listOf("()", "()[]{}", "(]", "{[()]}")
        testList.forEach {
            println("isValidParenthesesOrder : $it ----> " + dsaQuestions.isValidParenthesesOrder(it))
        }
    }

    @Test
    fun nextGreaterElement() {
        println("nextGreaterElement : ${Gson().toJson(dsaQuestions.nextGreaterElement())}")
    }

    @Test
    fun linkedListQ() {
        dsaQuestions.linkedListQ()
    }

    @Test
    fun binarySearch() {
        println("binarySearch : ${dsaQuestions.binarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 8)}")
    }


    @Test
    fun findDifference() {
        println("findDifference : ${dsaQuestions.findDifference()}")
    }

    @Test
    fun gcdOfStrings() {
        println("gcdOfStrings : ${dsaQuestions.gcdOfStrings()}")
    }

    @Test
    fun gcd() {
        println("gcd : ${dsaQuestions.gcd(8, 36)}")
        Assertions.assertEquals("4", "${dsaQuestions.gcd(8, 36)}")
    }

    @Test
    fun kidsWithCandies() {
        println("kidsWithCandies : ${dsaQuestions.kidsWithCandies(intArrayOf(2, 3, 5, 1, 3), 3)}")
    }

    @Test
    fun canPlaceFlowers() {
        println("canPlaceFlowers : ${dsaQuestions.canPlaceFlowers()}")
    }


    @Test
    fun reverseVowels() {
        println("reverseVowels : ${dsaQuestions.reverseVowels()}")
    }

    @Test
    fun productExceptSelf() {
        println("productExceptSelf : ${Gson().toJson(dsaQuestions.productExceptSelf())}")
    }

    @Test
    fun increasingTriplet() {
        println("[1,2,3,4,5] ---->" + dsaQuestions.increasingTriplet(intArrayOf(1, 2, 3, 4, 5)))
        println("[5,4,3,2,1] ---->" + dsaQuestions.increasingTriplet(intArrayOf(5, 4, 3, 2, 1)))
        println("[2,1,5,0,4,6] ---->" + dsaQuestions.increasingTriplet(intArrayOf(2, 1, 5, 0, 4, 6)))
    }

    @Test
    fun compress() {
        println("compress : ${dsaQuestions.compress(charArrayOf('a'))}")
        println("compress : ${dsaQuestions.compress(charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c'))}")
        println("compress : ${dsaQuestions.compress(charArrayOf('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'))}")
    }

    @Test
    fun uniqueOccurrences() {
        println("uniqueOccurrences : ${dsaQuestions.uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3))}")
        println("uniqueOccurrences : ${dsaQuestions.uniqueOccurrences(intArrayOf(1, 2))}")
        println("uniqueOccurrences : ${dsaQuestions.uniqueOccurrences(intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0))}")
    }

    @Test
    fun removeStars() {
        println("removeStars : ${dsaQuestions.removeStars()}")
    }

    @Test
    fun asteroidCollision() {
        println("asteroidCollision : ${Gson().toJson(dsaQuestions.asteroidCollision())}")
    }

    @Test
    fun firstSmallestRepeatingElement() {
        dsaQuestions.firstSmallestRepeatingElement()
    }


    @Test
    fun getPlatForms() {
        println("Platform:  ${(dsaQuestions.getPlatForms() == 3)}")
    }

    @Test
    fun minMeetingRooms() {
        println("Meeting room: ${dsaQuestions.minMeetingRooms() == 2}")
    }

    @Test
    fun moveZeroes() {
        println("Move Zero : ${intArrayOf(2, 4, 1, 3, 12, 0, 0, 0, 0).contentEquals(dsaQuestions.moveZeroes())}")
    }

    @Test
    fun isSubsequence() {
        println("removeStars : ${dsaQuestions.isSubsequence(" abc ", " ahbgdc ")}")
        println("removeStars : ${dsaQuestions.isSubsequence(" axc ", " ahbgdc ")}")
    }

    @Test
    fun maxArea() {
        println("maxArea : ${dsaQuestions.maxArea()}")
    }

    @Test
    fun maxOperations() {
        println("maxOperations : ${dsaQuestions.maxOperations()}")
    }

    @Test
    fun closeStrings() {
        println("closeStrings : ${dsaQuestions.closeStrings()}")
    }

    @Test
    fun findMaxAverage() {
        //Time Complexity :  O(n) , Space Complexity : O(1)
        println(dsaQuestions.findMaxAverage().toString())
        assertEquals(12.75, dsaQuestions.findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4))
    }

    @Test
    fun maxVowels() {

        val case1 = dsaQuestions.maxVowels("abciiidef", 3)
        val case2 = dsaQuestions.maxVowels("aeiou", 2)
        val case3 = dsaQuestions.maxVowels("leetcode", 3)
        val case4 = dsaQuestions.maxVowels("weallloveyou", 7)

        println("case1 : $case1")
        assertEquals(3, case1)

        println("case2 : $case2")
        assertEquals(2, case2)

        println("case3 : $case3")
        assertEquals(2, case3)

        println("case4 : $case4")
        assertEquals(4, case4)
    }


    @Test
    fun longestOnes() {
        val case1 = dsaQuestions.longestOnes(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2)
        val case2 = dsaQuestions.longestOnes(intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3)

        println("case1 : $case1")
        assertEquals(6, case1)

        println("case2 : $case2")
        assertEquals(10, case2)

    }

    @Test
    fun longestSubarray() {

        //Time Complexity :  O(n^2) , Space Complexity : O(1)
        val case1 = dsaQuestions.longestSubarrayN2(intArrayOf(1, 1, 0, 1))
        val case2 = dsaQuestions.longestSubarrayN2(intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1))
        val case3 = dsaQuestions.longestSubarrayN2(intArrayOf(1, 1, 1))

        println("case1 : $case1")
        assertEquals(3, case1)

        println("case2 : $case2")
        assertEquals(5, case2)

        println("case3 : $case3")
        assertEquals(2, case3)

        val case11 = dsaQuestions.longestSubarrayN(intArrayOf(1, 1, 0, 1))
        val case22 = dsaQuestions.longestSubarrayN(intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1))
        val case33 = dsaQuestions.longestSubarrayN(intArrayOf(1, 1, 1))

        println("case11 : $case11")
        assertEquals(3, case11)

        println("case22 : $case22")
        assertEquals(5, case22)

        println("case33 : $case33")
        assertEquals(2, case33)
    }


    @Test
    fun eraseOverlapIntervals() {
        val case1 = dsaQuestions.eraseOverlapIntervals(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(1, 3)))
        val case2 = dsaQuestions.eraseOverlapIntervals(arrayOf(intArrayOf(1, 2), intArrayOf(1, 2), intArrayOf(1, 2)))
        val case3 = dsaQuestions.eraseOverlapIntervals(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3)))
        val case4 = dsaQuestions.eraseOverlapIntervals(arrayOf(intArrayOf(1, 4), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(1, 3)))

        assertEquals(1, case1)
        assertEquals(2, case2)
        assertEquals(0, case3)
        assertEquals(3, case4)
    }


    @Test
    fun findMinimumMeetingRooms() {

        val case1 = dsaQuestions.findMinimumMeetingRooms(arrayOf(intArrayOf(1, 4), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(1, 3)))
        assertEquals(3, case1)

        val case2 = dsaQuestions.findMinimumMeetingRooms(arrayOf(intArrayOf(0, 30), intArrayOf(5, 10), intArrayOf(15, 20)))
        assertEquals(2, case2)

        val case3 = dsaQuestions.findMinimumMeetingRooms(arrayOf(intArrayOf(1, 3), intArrayOf(4, 6), intArrayOf(7, 9)))
        assertEquals(1, case3)

        val case4 = dsaQuestions.findMinimumMeetingRooms(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(1, 3)))
        assertEquals(2, case4)

        val case5 = dsaQuestions.findMinimumMeetingRooms(arrayOf(intArrayOf(1, 2), intArrayOf(1, 2), intArrayOf(1, 2)))
        assertEquals(3, case5)

        val case6 = dsaQuestions.findMinimumMeetingRooms(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3)))
        assertEquals(1, case6)
    }


    @Test
    fun findMinArrowShots() {

        val case1 = dsaQuestions.findMinArrowShots(arrayOf(intArrayOf(10, 16), intArrayOf(2, 8), intArrayOf(1, 6), intArrayOf(7, 12)))
        assertEquals(2, case1)

        val case2 = dsaQuestions.findMinArrowShots(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6), intArrayOf(7, 8)))
        assertEquals(4, case2)

        val case3 = dsaQuestions.findMinArrowShots(arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(4, 5)))
        assertEquals(2, case3)

    }


    @Test
    fun largestAltitude() {
        val case1 = dsaQuestions.largestAltitude(intArrayOf(-5, 1, 5, 0, -7))
        val case2 = dsaQuestions.largestAltitude(intArrayOf(-4, -3, -2, -1, 4, 3, 2))

        assertEquals(1, case1)
        assertEquals(0, case2)
    }

    @Test
    fun pivotIndex() {

        val case1 = dsaQuestions.pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6))
        val case2 = dsaQuestions.pivotIndex(intArrayOf(1, 2, 3))
        val case3 = dsaQuestions.pivotIndex(intArrayOf(2, 1, -1))

        assertEquals(3, case1)
        assertEquals(-1, case2)
        assertEquals(0, case3)
    }

    @Test
    fun twoSum1() {
        val case1 = dsaQuestions.twoSumForSortedArray(intArrayOf(4, 2, 7, 3, 5, 42, 6, 1), 8)
        assertEquals("[{\"first\":2,\"second\":7}]", Gson().toJson(case1))
    }

}
