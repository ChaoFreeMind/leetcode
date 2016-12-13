// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

// Note:
// Each element in the result should appear as many times as it shows in both arrays.
// The result can be in any order.

// Follow up:
// What if the given array is already sorted? 
// How would you optimize your algorithm?
// Ans: Algorithm 2 would not need to sort anymore.

// What if nums1's size is small compared to nums2's size?
// Which algorithm is better?
// Ans: Because algorithm 2 is potentially to end early.

// What if elements of nums2 are stored on disk, 
// and the memory is limited such that you 
// cannot load all elements into the memory at once?

// Ans: Load one piece of nums2 at a time into a buffer, run algorithm multiple times.
public class Solution {
	// Method 1: HashMap
	private int[] listToArray(List<Integer> list) {
		int[] arr = new int[list.size()];
		int i = 0;
		for (int num: list) {
			arr[i++] = num;
		}
		return arr;
	}
	// // Time: O(n) Space: O(n)
 //    public int[] intersect(int[] nums1, int[] nums2) {
 //    	Map<Integer, Integer> map = new HashMap<>();
 //    	List<Integer> resultList = new ArrayList<>();

 //    	for (int num: nums1) {
 //    		map.put(num, map.getOrDefault(num, 0) + 1);
 //    	}

 //    	for (int num: nums2) {
 //    		if (map.containsKey(num)) {
 //    			resultList.add(num);
 //    			int newCount = map.get(num) - 1;
 //    			if (newCount == 0) {
 //    				map.remove(num);
 //    			} else {
 //    				map.put(num, newCount);
 //    			}
 //    		}
 //    	}

 //    	// Convert List to int list
 //    	return listToArray(resultList);
 //    }


	// Sort two arrays, use double pointers 
	// O(nlgn) and O(lgn) sorting space 
	public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int idx1 = 0, idx2 = 0;
        List<Integer> resList = new ArrayList<>();
        while (idx1 < nums1.length && idx2 < nums2.length) {
        	if (nums1[idx1] == nums2[idx2]) {
        		resList.add(nums1[idx1]);
        		idx1++;
        		idx2++;
        	} else if (nums1[idx1] < nums2[idx2]) {
        		idx1++;
        	} else if (nums2[idx2] < nums1[idx1]) {
        		idx2++;
        	}
        }
        return listToArray(resList);
    }
}