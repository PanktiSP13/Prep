package com.pankti.l1programmingquestions

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DSANewTest {
    private val dsa = DSA()

    @Test
    fun mergeAlternately() {
        assertEquals("apbqcr", dsa.mergeAlternately("abc", "pqr"))
        assertEquals("apbqrs", dsa.mergeAlternately("ab", "pqrs"))
        assertEquals("apbqcd", dsa.mergeAlternately("abcd", "pq"))
        assertEquals("", dsa.mergeAlternately("", ""))
        assertEquals("abc", dsa.mergeAlternately("abc", ""))
        assertEquals("xyz", dsa.mergeAlternately("", "xyz"))
        assertEquals("a", dsa.mergeAlternately("a", ""))
        assertEquals("b", dsa.mergeAlternately("", "b"))
        assertEquals("ab", dsa.mergeAlternately("a", "b"))
        assertEquals("axbxcxd", dsa.mergeAlternately("abcd", "xxx"))
    }

    @Test
    fun reverseWords() {
        assertEquals("world hello", dsa.reverseWords("hello world"))
        assertEquals("blue is sky the", dsa.reverseWords("the sky is blue"))
        assertEquals("a good example", dsa.reverseWords("example good a"))
        assertEquals("hello", dsa.reverseWords("hello"))
        assertEquals("", dsa.reverseWords(""))
        assertEquals("world hello", dsa.reverseWords("  hello   world  "))
        assertEquals("one", dsa.reverseWords("one"))
        assertEquals("c b a", dsa.reverseWords("a b c"))
        assertEquals("test unit kotlin", dsa.reverseWords("kotlin unit test"))
        assertEquals("java kotlin", dsa.reverseWords("kotlin java"))
    }

    @Test
    fun reverseVowels() {
        assertEquals("holle", dsa.reverseVowels("hello"))
        assertEquals("leotcede", dsa.reverseVowels("leetcode"))
        assertEquals("a", dsa.reverseVowels("a"))
        assertEquals("bcdf", dsa.reverseVowels("bcdf"))
        assertEquals("uoiea", dsa.reverseVowels("aeiou"))
        assertEquals("Aa", dsa.reverseVowels("aA"))
        assertEquals("racecar", dsa.reverseVowels("racecar"))
        assertEquals(" ", dsa.reverseVowels(" "))
        assertEquals("xyz", dsa.reverseVowels("xyz"))
        assertEquals("Euston saw I was not Sue.", dsa.reverseVowels("Euston saw I was not Sue."))
    }

    @Test
    fun removeStars() {
        assertEquals("lecoe", dsa.removeStars("leet**cod*e"))
        assertEquals("", dsa.removeStars("erase*****"))
        assertEquals("abc", dsa.removeStars("abc"))
        assertEquals("", dsa.removeStars("*"))
        assertEquals("a", dsa.removeStars("a"))
        assertEquals("", dsa.removeStars("a*"))
        assertEquals("ab", dsa.removeStars("abc*"))
        assertEquals("ac", dsa.removeStars("ab*c"))
        assertEquals("", dsa.removeStars("*****"))
        assertEquals("xy", dsa.removeStars("x*y*z*xy"))
    }

    @Test
    fun gcdOfStrings() {
        assertEquals("ABC", dsa.gcdOfStrings("ABCABC", "ABC"))
        assertEquals("AB", dsa.gcdOfStrings("ABABAB", "ABAB"))
        assertEquals("", dsa.gcdOfStrings("LEET", "CODE"))
        assertEquals("A", dsa.gcdOfStrings("AAAA", "AA"))
        assertEquals("XYZ", dsa.gcdOfStrings("XYZXYZ", "XYZ"))
        assertEquals("", dsa.gcdOfStrings("ABC", "DEF"))
        assertEquals("AB", dsa.gcdOfStrings("ABAB", "AB"))
        assertEquals("A", dsa.gcdOfStrings("A", "A"))
        assertEquals("", dsa.gcdOfStrings("ABCD", "AB"))
        assertEquals("AA", dsa.gcdOfStrings("AAAAAA", "AA"))
    }

    @Test
    fun gcd() {
        assertEquals(2, dsa.gcd(4, 2))
        assertEquals(1, dsa.gcd(7, 3))
        assertEquals(5, dsa.gcd(10, 5))
        assertEquals(6, dsa.gcd(54, 24))
        assertEquals(1, dsa.gcd(17, 13))
        assertEquals(3, dsa.gcd(9, 6))
        assertEquals(4, dsa.gcd(8, 12))
        assertEquals(10, dsa.gcd(10, 0))
        assertEquals(7, dsa.gcd(0, 7))
        assertEquals(1, dsa.gcd(1, 1))
    }

    @Test
    fun moveZeroes() {
        assertArrayEquals(intArrayOf(1, 3, 12, 0, 0), dsa.moveZeroes(intArrayOf(0, 1, 0, 3, 12)))
        assertArrayEquals(intArrayOf(1, 2, 3), dsa.moveZeroes(intArrayOf(1, 2, 3)))
        assertArrayEquals(intArrayOf(0, 0), dsa.moveZeroes(intArrayOf(0, 0)))
        assertArrayEquals(intArrayOf(1, 0), dsa.moveZeroes(intArrayOf(0, 1)))
        assertArrayEquals(intArrayOf(4, 5, 0, 0), dsa.moveZeroes(intArrayOf(0, 4, 0, 5)))
        assertArrayEquals(intArrayOf(1), dsa.moveZeroes(intArrayOf(1)))
        assertArrayEquals(intArrayOf(0), dsa.moveZeroes(intArrayOf(0)))
        assertArrayEquals(intArrayOf(2, 1, 0), dsa.moveZeroes(intArrayOf(2, 1, 0)))
        assertArrayEquals(intArrayOf(3, 4, 5, 0), dsa.moveZeroes(intArrayOf(0, 3, 4, 5)))
        assertArrayEquals(intArrayOf(1, 2, 0, 0), dsa.moveZeroes(intArrayOf(1, 0, 2, 0)))
    }

    @Test
    fun isSubsequence() {
        assertTrue(dsa.isSubsequence("abc", "ahbgdc"))
        assertFalse(dsa.isSubsequence("axc", "ahbgdc"))
        assertTrue(dsa.isSubsequence("", "abc"))
        assertFalse(dsa.isSubsequence("abc", "ab"))
        assertTrue(dsa.isSubsequence("a", "a"))
        assertFalse(dsa.isSubsequence("b", "a"))
        assertTrue(dsa.isSubsequence("ace", "abcde"))
        assertFalse(dsa.isSubsequence("aec", "abcde"))
        assertTrue(dsa.isSubsequence("abc", "abc"))
        assertFalse(dsa.isSubsequence("abcd", "abc"))
    }

    @Test
    fun binarySearch() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        assertEquals(0, dsa.binarySearch(arr, 1))
        assertEquals(9, dsa.binarySearch(arr, 10))
        assertEquals(4, dsa.binarySearch(arr, 5))
        assertEquals(-1, dsa.binarySearch(arr, 11))
        assertEquals(-1, dsa.binarySearch(arr, -1))
        assertEquals(2, dsa.binarySearch(arr, 3))
        assertEquals(7, dsa.binarySearch(arr, 8))
        assertEquals(5, dsa.binarySearch(arr, 6))
        assertEquals(1, dsa.binarySearch(arr, 2))
        assertEquals(8, dsa.binarySearch(arr, 9))
    }

    @Test
    fun findMaxAverage() {
        assertEquals(12.75, dsa.findMaxAverage(intArrayOf(1,12,-5,-6,50,3), 4))
        assertEquals(5.0, dsa.findMaxAverage(intArrayOf(5), 1))
        assertEquals(-1.0, dsa.findMaxAverage(intArrayOf(-1,-2,-3,-4), 1))
        assertEquals(3.5, dsa.findMaxAverage(intArrayOf(1,2,3,4,5), 2))
        assertEquals(4.0, dsa.findMaxAverage(intArrayOf(4,4,4,4), 1))
        assertEquals(2.5, dsa.findMaxAverage(intArrayOf(1,2,3,4), 2))
        assertEquals(3.0, dsa.findMaxAverage(intArrayOf(3,3,3), 1))
        assertEquals(0.0, dsa.findMaxAverage(intArrayOf(0,0,0), 2))
        assertEquals(6.0, dsa.findMaxAverage(intArrayOf(6,6,6), 1))
        assertEquals(2.0, dsa.findMaxAverage(intArrayOf(2,2,2), 3))
    }

    @Test
    fun largestAltitude() {
        assertEquals(1, dsa.largestAltitude(intArrayOf(-5,1,5,0,-7)))
        assertEquals(0, dsa.largestAltitude(intArrayOf(-4,-3,-2)))
        assertEquals(10, dsa.largestAltitude(intArrayOf(2,3,5)))
        assertEquals(5, dsa.largestAltitude(intArrayOf(1,2,3,-1)))
        assertEquals(0, dsa.largestAltitude(intArrayOf(0,0,0)))
        assertEquals(3, dsa.largestAltitude(intArrayOf(1,1,1)))
        assertEquals(6, dsa.largestAltitude(intArrayOf(3,3,-2,2)))
        assertEquals(2, dsa.largestAltitude(intArrayOf(2,-1,1)))
        assertEquals(4, dsa.largestAltitude(intArrayOf(4,-2,-1,3)))
        assertEquals(7, dsa.largestAltitude(intArrayOf(3,4,-5,5)))
    }

    @Test
    fun pivotIndex() {
        assertEquals(3, dsa.pivotIndex(intArrayOf(1,7,3,6,5,6)))
        assertEquals(-1, dsa.pivotIndex(intArrayOf(1,2,3)))
        assertEquals(0, dsa.pivotIndex(intArrayOf(2,1,-1)))
        assertEquals(2, dsa.pivotIndex(intArrayOf(1,2,1)))
        assertEquals(-1, dsa.pivotIndex(intArrayOf()))
        assertEquals(0, dsa.pivotIndex(intArrayOf(0)))
        assertEquals(1, dsa.pivotIndex(intArrayOf(1,-1,0)))
        assertEquals(2, dsa.pivotIndex(intArrayOf(-1,-1,-1,0,1,1)))
        assertEquals(1, dsa.pivotIndex(intArrayOf(1,0,1)))
        assertEquals(-1, dsa.pivotIndex(intArrayOf(5,6,7)))
    }

    @Test
    fun rotate() {
        val arr1 = intArrayOf(1,2,3,4,5,6,7)
        dsa.rotate(arr1, 3)
        assertArrayEquals(intArrayOf(5,6,7,1,2,3,4), arr1)

        val arr2 = intArrayOf(1,2)
        dsa.rotate(arr2, 1)
        assertArrayEquals(intArrayOf(2,1), arr2)

        val arr3 = intArrayOf(1)
        dsa.rotate(arr3, 0)
        assertArrayEquals(intArrayOf(1), arr3)

        val arr4 = intArrayOf(1,2,3)
        dsa.rotate(arr4, 4)
        assertArrayEquals(intArrayOf(3,1,2), arr4)

        val arr5 = intArrayOf(1,2,3,4)
        dsa.rotate(arr5, 2)
        assertArrayEquals(intArrayOf(3,4,1,2), arr5)
    }

    @Test
    fun reverse() {
        val arr = intArrayOf(1,2,3,4,5)
        dsa.reverse(arr, 0, 4)
        assertArrayEquals(intArrayOf(5,4,3,2,1), arr)

        val arr2 = intArrayOf(1,2,3)
        dsa.reverse(arr2, 0, 1)
        assertArrayEquals(intArrayOf(2,1,3), arr2)

        val arr3 = intArrayOf(1)
        dsa.reverse(arr3, 0, 0)
        assertArrayEquals(intArrayOf(1), arr3)
    }

    @Test
    fun isValidParentheses() {
        assertTrue(dsa.isValidParentheses("()"))
        assertTrue(dsa.isValidParentheses("()[]{}"))
        assertFalse(dsa.isValidParentheses("(]"))
        assertFalse(dsa.isValidParentheses("([)]"))
        assertTrue(dsa.isValidParentheses("{[]}"))
        assertFalse(dsa.isValidParentheses("("))
        assertFalse(dsa.isValidParentheses("]"))
        assertTrue(dsa.isValidParentheses(""))
        assertTrue(dsa.isValidParentheses("((()))"))
        assertFalse(dsa.isValidParentheses("((())"))
    }

    @Test
    fun twoSum() {
        assertArrayEquals(intArrayOf(0,1), dsa.twoSum(intArrayOf(2,7,11,15), 9))
        assertArrayEquals(intArrayOf(1,2), dsa.twoSum(intArrayOf(3,2,4), 6))
        assertArrayEquals(intArrayOf(0,1), dsa.twoSum(intArrayOf(3,3), 6))
        assertArrayEquals(intArrayOf(), dsa.twoSum(intArrayOf(1,2,3), 7))
        assertArrayEquals(intArrayOf(2,3), dsa.twoSum(intArrayOf(1,2,3,4), 7))
    }

    @Test
    fun uniqueOccurrences() {
        assertTrue(dsa.uniqueOccurrences(intArrayOf(1,2,2,1,1,3)))
        assertFalse(dsa.uniqueOccurrences(intArrayOf(1,2)))
        assertTrue(dsa.uniqueOccurrences(intArrayOf(1)))
        assertTrue(dsa.uniqueOccurrences(intArrayOf(1,1,2,2,3,3)))
        assertFalse(dsa.uniqueOccurrences(intArrayOf(1,1,2,2)))
    }

    @Test
    fun kidsWithCandies() {
        assertEquals(listOf(true,true,true,false,true),
            dsa.kidsWithCandies(intArrayOf(2,3,5,1,3), 3))

        assertEquals(listOf(true,false,false,false,false),
            dsa.kidsWithCandies(intArrayOf(4,2,1,1,2), 1))

        assertEquals(listOf(true,true,true),
            dsa.kidsWithCandies(intArrayOf(1,1,1), 0))
    }

    @Test
    fun findDifference() {
        val result = dsa.findDifference(intArrayOf(1,2,3), intArrayOf(2,4,6))
        assertTrue(result[0].containsAll(listOf(1,3)))
        assertTrue(result[1].containsAll(listOf(4,6)))

        val result2 = dsa.findDifference(intArrayOf(1,2,3), intArrayOf(1,2,3))
        assertTrue(result2[0].isEmpty())
        assertTrue(result2[1].isEmpty())
    }

    @Test
    fun maxArea() {
        assertEquals(49, dsa.maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
        assertEquals(1, dsa.maxArea(intArrayOf(1,1)))
        assertEquals(16, dsa.maxArea(intArrayOf(4,3,2,1,4)))
        assertEquals(2, dsa.maxArea(intArrayOf(1,2,1)))
    }

    @Test
    fun maxVowels() {
        assertEquals(3, dsa.maxVowels("abciiidef", 3))
        assertEquals(2, dsa.maxVowels("aeiou", 2))
        assertEquals(2, dsa.maxVowels("leetcode", 3))
        assertEquals(0, dsa.maxVowels("rhythms", 2))
        assertEquals(1, dsa.maxVowels("a", 1))
    }

    @Test
    fun longestOnes() {
        assertEquals(6, dsa.longestOnes(intArrayOf(1,1,1,0,0,0,1,1,1,1,0), 2))
        assertEquals(3, dsa.longestOnes(intArrayOf(0,0,1,1,1,0,0), 0))
        assertEquals(4, dsa.longestOnes(intArrayOf(1,0,1,0,1,0,1), 2))
        assertEquals(7, dsa.longestOnes(intArrayOf(1,1,1,1,1,1,1), 1))
    }

    @Test
    fun minMeetingRooms() {
        assertEquals(2, dsa.minMeetingRooms(arrayOf(intArrayOf(0,30), intArrayOf(5,10), intArrayOf(15,20))))
        assertEquals(1, dsa.minMeetingRooms(arrayOf(intArrayOf(7,10), intArrayOf(2,4))))
        assertEquals(3, dsa.minMeetingRooms(arrayOf(intArrayOf(1,5), intArrayOf(2,6), intArrayOf(3,7))))
    }

    @Test
    fun minPlatforms() {
        assertEquals(3, dsa.minPlatforms(
            intArrayOf(900,940,950,1100,1500,1800),
            intArrayOf(910,1200,1120,1130,1900,2000)
        ))

        assertEquals(1, dsa.minPlatforms(
            intArrayOf(100,200,300),
            intArrayOf(150,250,350)
        ))
    }

    @Test
    fun eraseOverlapIntervals() {
        assertEquals(1, dsa.eraseOverlapIntervals(arrayOf(
            intArrayOf(1,2), intArrayOf(2,3), intArrayOf(3,4), intArrayOf(1,3)
        )))

        assertEquals(2, dsa.eraseOverlapIntervals(arrayOf(
            intArrayOf(1,2), intArrayOf(1,2), intArrayOf(1,2)
        )))

        assertEquals(0, dsa.eraseOverlapIntervals(arrayOf(
            intArrayOf(1,2), intArrayOf(2,3)
        )))
    }
}

