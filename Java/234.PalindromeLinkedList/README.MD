# Problem

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

# Solution

## Naive

Add all elements of linked list into an array list, use double pointers to check if it is a palindrome. This is O(n) time complexity because we are traversing the list. O(n) space complexity because we are coping the list into a new array list.

## Improved (Follow up)

Find the mid way point of the linked list by fast slow pointers, reverse the second half of linked list, check if two lists are equal. This solution is O(n) space because we are traversing half of the list. O(1) space complexity. One drawback of this method is that we are not maintaining the structure of the original list.