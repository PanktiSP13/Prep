package com.pankti.l1programmingquestions

class Helper {

    fun isPalindrome(str : String) : Boolean = (str == str.reversed())

    fun isPalindrome(item : Int) : Boolean{
       var originalItem = item
        var finalItem = 0

        while (originalItem>0){
            finalItem  = ((finalItem*10) + (originalItem%10))
            originalItem /= 10
        }

        return  (item == finalItem)
    }

}