public void merge(int[] nums1, int m, int[] nums2, int n) {
		int last = m + n - 1;
		int i = m - 1, j = n - 1;//i is the index for nums1, j is the index for nums2
		
		while(i >= 0 && j >= 0) {
			
			if(nums1[i] > nums2[j]) {
				nums1[last] = nums1[i];
				i--;
			} else {
				nums1[last] = nums2[j];
				j--;
			}
			last--;
		}
		
		if(j >= 0) {
			System.arraycopy(nums2, 0, nums1, 0, j + 1);
		}
	}