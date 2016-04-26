//O(nlogn) looks like cheating~
    /*public int findKthLargest(int[] nums, int k) {
    	Arrays.sort(nums);
    	return nums[nums.length - k];
    }*/
    

	/* 
	 * Implementation note: this implementation provides O(log(n)) time for the enqueing and dequeing methods (offer, poll, remove() and  add); 
	 * linear time for the remove(Object) and contains(Object) methods; 
	 * and constant time for the retrieval methods (peek,  element, and size).
	 */
	//O(nlgK) time and O(K) space
    public int findKthLargest(int[] nums, int k) {
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	
    	for(int i = 0; i < nums.length; i++) {
    		pq.offer(nums[i]);
    		if(pq.size() > k) {
    			pq.poll();
    		}
    	}
    	
    	return pq.peek();
    }

    //Quick select algorithm