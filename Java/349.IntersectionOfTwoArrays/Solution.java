// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

// Note:
// Each element in the result must be unique.
// The result can be in any order.

//There are 3 ways of solving this problem!
public class Solution {

    // O(n) time O(n) space
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            setA.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (setA.contains(nums2[i])) setB.add(nums2[i]); 
        }

        setA.retainAll(setB);
        // setA is the intersection set
        int[] result = new int[setA.size()];
        int idx = 0;
        // Put all elements of setA in result array
        for (int num: setA) {
            result[idx++] = num;
        }
        return result;
    }

}