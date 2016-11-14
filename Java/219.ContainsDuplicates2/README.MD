## Problem

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.

## Naive Way (HashMap)

The naive way that first came on me is to use a HashMap to keep track of nums[i] and its last occurance index. 

1. If map does not came across the current number, add it to map. 

2. If map already contains a key of nums[i], then we check the difference of last occurance and current index, if they are less than or equal to k, then we return true, if not, update the last occurance to current index.

3. In the end, if we did not find anything, return false.

The time complexity is O(n) because in worst case scenario we would have to exhaust all array.

The space complexity is O(n) too if there is no duplicates, which means we have to add all nums to map.

## Improved Way (HashSet Sliding Window)

Maintain a sliding window of size k using a HashSet by removing the (i-k-1)th element everytime we are checking a new element. This would reduce the space complexity to O(k).