

# 📘 DSA – Questions & Approach (Clean Notes)


*Check Time & Space Complexity* : https://www.bigocalc.com/

## 1. Merge Alternately

**Q:**
Given two strings, merge them by alternating characters.
If one string is longer, append remaining characters.
Example: `"abc"`, `"pqr"` → `"apbqcr"`

**Approach:**
Use single loop till max length.
Pick char from both strings if index valid.
Build result string step-by-step.

---

## 2. Reverse Words

**Q:**
Reverse the order of words in a string.
Ignore extra spaces.
Example: `"  hello world  "` → `"world hello"`

**Approach:**
1. Check if string is not empty
2. Split the string into words using space
3. Traverse the list from last to first (reverse order)
4. Add each word to result string
5. Add space between words (avoid extra space at end)
6. Trim and return final result

---

## 3. Reverse Vowels

**Q:**
Reverse only vowels in a string.
Keep other characters in same position.
Example: `"leetcode"` → `"leotcede"`

**Approach:**
Use two pointers from start and end.
Move until vowels found and swap.
Continue till pointers meet.

---

## 4. Remove Stars

**Q:**
Each `*` removes the previous character.
Return final string after all operations.
Example: `"leet**cod*e"` → `"lecoe"`

**Approach:**
Use stack to store characters.
Push normal chars, pop on `*`.
Convert stack to string.

---

## 5. GCD of Strings

**Q:**
Find largest string that divides both strings.
A string divides another if repeated forms it.

**Approach:**
Check if concatenations match.
Find GCD of lengths.
Return substring of that length.

---

## 6. Valid Parentheses

**Q:**
Check if brackets are valid and properly closed.
Example: `"()[]{}"` → valid

**Approach:**
Use stack to track opening brackets.
On closing, check matching pair.
Stack must be empty at end.

---

## 7. Daily Temperatures

**Q:**
For each day, find how many days to wait for warmer temperature.

**Approach:**
Use stack to store indices.
Compare current temp with previous.
Calculate distance when warmer found.

---

## 8. Next Greater Element

**Q:**
For each element, find next greater element in another array.

**Approach:**
Traverse second array and build mapping.
Use stack to find next greater.
Use map to answer queries.

---

## 9. Asteroid Collision

**Q:**
Asteroids move left/right, collide if opposite.
Return remaining asteroids.

**Approach:**
Use stack to simulate collisions.
Compare directions and sizes.
Keep only surviving asteroids.

---

## 10. Largest Rectangle in Histogram

**Q:**
Find the largest rectangle area in histogram bars.

**Approach:**
Use stack to track increasing heights.
Calculate area when smaller height appears.
Track max area.

---

## 11. Two Sum

**Q:**
Find indices where sum equals target.

**Approach:**
Check all pairs using loop OR store values.
Find complement for each element.
Return indices when found.

---

## 12. Product Except Self

**Q:**
Return array where each index = product of all except itself.

**Approach:**
Use prefix (left product).
Use suffix (right product).
Multiply both for result.

---

## 13. Move Zeroes

**Q:**
Move all zeroes to end, maintain order of others.

**Approach:**
Keep pointer for non-zero position.
Swap when non-zero found.
Push zeros automatically to end.

---

## 14. Unique Occurrences

**Q:**
Check if frequency of all elements is unique.

**Approach:**
Count frequency using map.
Store frequencies in set.
Compare sizes.

---

## 15. Pivot Index

**Q:**
Find index where left sum equals right sum.

**Approach:**
For each index, calculate left & right sum.
Compare both.
Return index if equal.

---

## 16. Find Difference of Arrays

**Q:**
Return elements present in one array but not in others.

**Approach:**
Convert arrays to sets.
Remove common elements.
Return remaining elements.

---

## 17. Kids With Candies

**Q:**
Check which kids can have max candies after adding extra.

**Approach:**
Find max candies.
Compare each with (value + extra).
Return boolean list.

---

## 18. First Missing Positive

**Q:**
Find the smallest missing positive number.

**Approach:**
Store elements in set.
Start checking from 1.
Return first missing.

---

## 19. Container With Most Water

**Q:**
Find max water between two lines.

**Approach:**
Use two pointers from both ends.
Calculate area and move smaller height.
Track max.

---

## 20. Max Vowels

**Q:**
Find max vowels in substring of size k.

**Approach:**
Use sliding window.
Add new char, remove old char.
Track max count.

---

## 21. Longest Ones

**Q:**
Find the longest subarray with at most k zeroes.

**Approach:**
Use sliding window.
Expand window, count zeros.
Shrink when limit exceeded.

---

## 22. Longest Subarray (Delete One)

**Q:**
Delete one element and find longest subarray of 1s.

**Approach:**
Allow at most 1 zero in window.
Use sliding window.
Track max length.

---

## 23. Max Average Subarray

**Q:**
Find max average of subarray of size k.

**Approach:**
Calculate initial window sum.
Slide window by adding/removing elements.
Track max average.

---

## 24. Is Subsequence

**Q:**
Check if string s is subsequence of t.

**Approach:**
Use two pointers.
Match characters sequentially.
If all matched → true.

---

## 25. Max K-Sum Pairs

**Q:**
Find max pairs whose sum = k.

**Approach:**
Sort array.
Use two pointers.
Move pointers based on sum.

---

## 26. Non-overlapping Intervals

**Q:**
Remove minimum intervals to avoid overlap.

**Approach:**
Sort by end time.
Check overlap with previous.
Count removals.

---

## 27. Minimum Meeting Rooms

**Q:**
Find minimum rooms required for meetings.

**Approach:**
Separate start & end times.
Sort both arrays.
Use two pointers to track overlaps.

---

## 28. Minimum Platforms

**Q:**
Find minimum platforms for trains.

**Approach:**
Sort arrival & departure.
Compare using two pointers.
Track max platforms needed.

---

## 29. Minimum Arrows (Balloons)

**Q:**
Burst all balloons with minimum arrows.

**Approach:**
Sort by end position.
Shoot arrow at earliest end.
Increase count when needed.

---

## 30. Merge Intervals

**Q:**
Merge overlapping intervals.

**Approach:**
Sort intervals by start.
Merge if overlapping.
Store result.

---

## 31. Insert Interval

**Q:**
Insert new interval and merge overlaps.

**Approach:**
Add non-overlapping intervals first.
Merge overlapping ones.
Add remaining intervals.

---

## 32. Binary Search

**Q:**
Search element in sorted array.

**Approach:**
Use left and right pointers.
Check middle element.
Reduce search space.

---

## 33. Find Peak Element

**Q:**
Find element greater than neighbors.

**Approach:**
Use binary search.
Move toward increasing side.
Peak will exist.

---

## 34. Rotate Array (k times)

**Q:**
Rotate an array to the right by `k` steps.
Elements shifted from end move to front.
Example: `[1,2,3,4,5]`, k=2 → `[4,5,1,2,3]`

**Approach:**
First take `k = k % size` to handle large k.
Reverse full array, then reverse first k elements.
Finally reverse remaining elements.

---

## 35. Valid Anagram

**Q:**
Check if two strings are anagrams.
Anagram means same characters with same frequency.
Example: `"listen"`, `"silent"` → true

**Approach:**
Count frequency of each character in both strings.
Compare counts for all characters.
If all match → anagram.
