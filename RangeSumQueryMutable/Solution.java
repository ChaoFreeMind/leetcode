public class NumArray {

	private class SegmentNode {
		int start;
		int end;
		int sum;//sum of element from start to end
		
		SegmentNode left;
		SegmentNode right;
		
		SegmentNode(int start, int end) {
			this.start = start;
			this.end = end;
		    this.sum = 0;
			this.left = null;
			this.right = null;
		}
	}
	
	SegmentNode root;
	
    public NumArray(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length - 1);
    }

    public SegmentNode buildSegmentTree(int[] nums, int start, int end) {
    	if(start > end) return null;
    	
    	SegmentNode segNode = new SegmentNode(start, end);
    	if(start == end) {
    		segNode.sum = nums[start];
    	} else {
    		int mid = start + (end - start) / 2;
    		segNode.left = buildSegmentTree(nums, start, mid);
    		segNode.right = buildSegmentTree(nums, mid + 1, end);
    		
    		segNode.sum = segNode.left.sum + segNode.right.sum;
    	}
    	
    	return segNode;
    }
    
    void update(int i, int val) {
        update(this.root, i, val);
    }
    
    private void update(SegmentNode root, int i, int val) {
    	if(i == root.start && i == root.end) {
    	    root.sum = val;
    	    return;
    	}
    	int mid = root.start + (root.end - root.start) / 2;
    	if(i <= mid) {
    		//i sits to the left of mid point
    		update(root.left, i, val);
    	} else {
    		//i sits to the right of mid point
    		update(root.right, i, val);
    	}
    	
    	root.sum = root.left.sum + root.right.sum;
    }

    public int sumRange(int i, int j) {
        
    	return sumRange(this.root, i, j);
    	
    }
    
    private int sumRange(SegmentNode root, int start, int end) {
    	if(start == root.start && end == root.end) {
    		return root.sum;
    	}
    	
    	int mid = root.start + (root.end - root.start) / 2;
    	int sum = 0;
    	if(end <= mid) {
    		//To the left of mid point
    		sum = sumRange(root.left, start, end);
    	} else if(start >= mid + 1) {
    		//To the right of mid point
    		sum = sumRange(root.right, start, end);
    	} else {
    		//Overlap the mid point
    		sum = sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
    	}
    	
    	return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
