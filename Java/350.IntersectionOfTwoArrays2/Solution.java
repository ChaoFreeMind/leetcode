// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

// Note:
// Each element in the result should appear as many times as it shows in both arrays.
// The result can be in any order.

//Wrong understanding of the problem note!!!!
//[1,2,2] [2] => [2]
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> resList = new ArrayList<>();
        int idx1 = 0, idx2 = 0;
        while(idx1 < nums1.length && idx2 < nums2.length) {
            if(nums1[idx1] == nums2[idx2]) {
                resList.add(nums1[idx1]);
                idx1++;
                idx2++;
            } else if(nums1[idx1] > nums2[idx2]) {
                idx2++;
            } else {//nums1[idx1] < nums2[idx2]
                idx1++;
            }   
        }

        return listToArray(resList);
    }

    /*public int[] intersect(int[] nums1, int[] nums2) {
    	Map<Integer, Integer> map1 = new HashMap<>();//Map number in nums1 to its frequency.
    	Map<Integer, Integer> map2 = new HashMap<>();
    	List<Integer> resultList = new ArrayList<>();
    	for(int i = 0; i < nums1.length; i++) {
    		map1.putIfAbsent(nums1[i], 0);
    		map1.put(nums1[i], map1.get(nums1[i]) + 1);
    	}

    	for(int i = 0; i < nums2.length; i++) {
    		map2.putIfAbsent(nums2[i], 0);
    		map2.put(nums2[i], map2.get(nums2[i]) + 1);
    	}

    	for(Map.Entry<Integer, Integer> entry: map1.entrySet()) {
    		int key = entry.getKey();
    		int val = entry.getValue();
    		if(map2.containsKey(key)) {
                int count = Math.min(map2.get(key), val);
    			for(int i = 0; i < count; i++) {
    				resultList.add(key);
    			}
    		}
    	} 

    	return listToArray(resultList);
    }*/

    private int[] listToArray(List<Integer> list) {
        int[] res = new int[list.size()];
        int pos = 0;
        for(int n: list) {
            res[pos++] = n;
        }
        return res;
    }
}