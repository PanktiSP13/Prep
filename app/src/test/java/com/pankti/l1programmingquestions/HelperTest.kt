package com.pankti.l1programmingquestions

import org.junit.Test
import org.junit.jupiter.api.Assertions

class HelperTest {

    @Test
    fun testIsIntPalindrome() {
        Assertions.assertEquals(true, Helper().isPalindrome(1234321))
    }

    @Test
    fun testIsStringPalindrome() {
        Assertions.assertEquals(true, Helper().isPalindrome("pankti"))
    }
}