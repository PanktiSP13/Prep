package com.pankti.l1programmingquestions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class JavaPrograms {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(14);

        System.out.println(list);

        int a = 5, b = 7;

        //swap two number
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a: " + a + " b:" + b);

        // reverse list without using 3rd variable
        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(5, 2, 17, 8, 3, 6, 7, 1));
        System.out.println(ls);

        String str = "Pankti Prajapati";
        StringBuilder reversedStr = new StringBuilder();

        for (int i = str.length(); i > 0; i--) {
            reversedStr = new StringBuilder(reversedStr.toString().concat(String.valueOf(str.charAt(i - 1))));
        }

//        int i = str.length()-1;
//        while (i>0){
//            reversedStr.append(str.charAt(i));
//            i--;
//        }
//
        System.out.println(reversedStr);


        // palindrome
        String str1 = "namo namah", str2 = "Malayalam";
        System.out.println(str1 + " is palindrome: " + isPalindrome(str1));
        System.out.println(str2 + " is palindrome : " + isPalindrome(str2));

        int num1 = 4987894, num2 = 12345321;
        System.out.println("Find max : " + Math.max(num1, num2));
        System.out.println("Find min : " + Math.min(num1, num2));

        System.out.println(num1 + " is palindrome : " + isPalindrome(num1));
        System.out.println(num2 + " is palindrome : " + isPalindrome(num2));

        System.out.println("Real list : " + Arrays.asList(5, 2, 17, 8, 5, 6, 7, 1, 5, 3, 2));
        System.out.println("Distinct list : " + removeDuplicate(Arrays.asList(5, 2, 17, 8, 5, 6, 7, 1, 5, 3, 2)));
        System.out.println("Check duplicate in list : " + checkForDuplicates(Arrays.asList(5, 2, 17, 8, 6, 7, 1, 3)));


        System.out.println("Reverse an array : " + Arrays.toString(reverseArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13})));

        System.out.println("Check if number is prime or not : " + checkIfPrimeNumber(12));

        System.out.print("Fibonacci : ");
        fibonacci(12);

        System.out.println("GCD : " + gcd(4, 12));

        System.out.println("Factorial  : " + factorial(7));
        System.out.println("Factorial 1  : " + factorial1(7));

        System.out.println("Power : " + Math.pow(2, 5));
        System.out.println("Power : " + power(2, 5));

        int[] tempArray = new int[]{4, 2, 7, 3, 5, 42, 6, 1, 3};

        System.out.println("bubble sort  : " + Arrays.toString(bubbleSort(tempArray)));
        System.out.println("selection sort  : " + Arrays.toString(selectionSort(tempArray)));
        System.out.println("insertion sort  : " + Arrays.toString(insertionSort(new int[]{3, 6, 8, 5, 2, 1, 45})));


        int[] result = twoSum(tempArray, 10);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }

    static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.toLowerCase().charAt(i) != s.toLowerCase().charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrome(int number) {
        int givenNum = number;
        int reversedNumber = 0;

        while (givenNum > 0) {
            reversedNumber = (reversedNumber * 10) + (givenNum % 10);
            givenNum = givenNum / 10;
        }
        return number == reversedNumber;
    }

    static List<Integer> removeDuplicate(List<Integer> list) {
        // you can use hashset also but it will not preserve order of list item
        //to preserve list item order , we can use linkedHashSet
        Set<Integer> distinctList = new LinkedHashSet<>();
        for (int i = 0; i < list.size(); i++) {
            if (!distinctList.contains(list.get(i))) {
                distinctList.add(list.get(i));
            }
        }
        return new ArrayList<>(distinctList);
    }

    static boolean checkForDuplicates(List<Integer> list) {
        Set<Integer> distinctList = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            if (distinctList.contains(list.get(i))) {
                return true;
            } else {
                distinctList.add(list.get(i));
            }
        }
        return false;
    }


    public static int[] reverseArray(int[] list) {
        if (list.length == 1 || list.length == 0) return list;

        for (int i = 0; i < list.length / 2; i++) {
            int temp = list[i]; //1
            list[i] = list[list.length - 1 - i]; //13
            list[list.length - 1 - i] = temp; // 1
        }
        return list;
    }

    // Prime number is a number that is greater than 1 and divided by 1 or itself only.
    // For example 2, 3, 5, 7, 11, 13, 17
    // Note: 0 and 1 are not prime numbers.
    // The 2 is the only even prime number because all the other even numbers can be divided by 2.

    public static boolean checkIfPrimeNumber(int number) {
        if (number == 1 || number == 0) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void fibonacci(int n) {
        int n1 = 0, n2 = 1;
        System.out.print(n1 + " " + n2 + " ");

        for (int i = 1; i < n; i++) {
            int temp = n1 + n2;
            System.out.print(temp + " ");
            n1 = n2;
            n2 = temp;
        }
    }


    //Find Greatest Common Divisor (GCD)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static int factorial1(int n) {
        if (n == 0 || n == 1) return 1;
        int finalValue = 1;
        while (n > 0) {
            finalValue *= n;
            if (n == 1) System.out.print(n);
            else System.out.print(n + " * ");
            n--;
        }
        return finalValue;
    }

    public static int power(int base, int exp) {
        int result = 1;
        int i = 0;
        while (i < exp) {
            result *= base;
            i++;
        }
        return result;
    }


    private static int[] bubbleSort(int[] list) {

        // check adjacent element everytime and swap everytime
        // time complexity : O(n^2), best case : O(n)
        System.out.println("Real list before sort :" + Arrays.toString(list));
        //you don't need to check last item because after that no item to swap
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        return list;
    }

    private static int[] selectionSort(int[] list) {

        // find minimum in each iteration and swap it with i indexed item
        // time complexity : O(n^2), best case : O(n)
        System.out.println("Real list before sort :" + Arrays.toString(list));

        for (int i = 0; i < list.length - 1; i++) {
            int minItemIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[minItemIndex]) {
                    minItemIndex = j;
                }
            }
            //find max and swap with last unsorted index
            int temp = list[minItemIndex];
            list[minItemIndex] = list[i];
            list[i] = temp;
            System.out.println(Arrays.toString(list));
        }
        return list;
    }

    private static int[] insertionSort(int[] list) {

        // divide array in  sorted and unsorted array
        // consider first item as sorted : it will check first right side then sorted array
        // time complexity : O(n^2), best case : O(n)
        System.out.println("Real list before sort :" + Arrays.toString(list));

        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j;
            j = i - 1;
            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                System.out.println("During Iteration " + i + ": " + Arrays.toString(list));
                j--;
            }
            list[j + 1] = key;
        }
        return list;
    }

    // Given an array of integers, return the indices of the two numbers that add up to a specific target.
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement) && map.get(complement)!= null) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
