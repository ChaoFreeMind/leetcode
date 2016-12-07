public class Solution {

	private void swap(int[] arr, int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	// public void moveZeroes(int[] nums) {
 //    	int len = nums.length;
 //    	int p = 0, q = 0; // p is the non-zero index and q is the zero index
 //        while (p < len && q < len) {
 //        	while (p < len && nums[p] == 0) {
 //        		p++;
 //        	}
 //        	while (q < len && nums[q] != 0) {
 //        		q++;
 //        	}

 //        	// After making sure p q are in place, swap if p > q
 //        	if (p < len && q < len && p > q) {
 //        		int temp = nums[p];
 //        		nums[p] = nums[q];
 //        		nums[q] = temp;
 //        		p++;
 //        		q++;
 //        	} else {
 //        		p++;
 //        	}
 //        }
 //    }

	// Merged
    public void moveZeroes(int[] nums) {
    	int len = nums.length;
    	int p = 0, q = 0; // p is the non-zero index and q is the zero index
        while (p < len && q < len) {
        	if (nums[p] == 0) {
        		p++;
        	} else if (nums[q] != 0) {
        		q++;
        	} else if (p > q) {
        		swap(nums, p++, q++);
        	} else {
        		p++;
        	}

        }
    }

    // Just move all non-zero elements to the left part of the array and pad with zeroes
    public void moveZeroes(int[] nums) {
    	int left = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] != 0) nums[left++] = num;
    	}

    	// Pad with zeros
    	while (left < nums.length) {
    		nums[left] = 0;
    	}
    }
}