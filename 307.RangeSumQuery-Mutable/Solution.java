public class NumArray {

	class SegmentNode {
		int start;
		int end;
		int sum;
		SegmentNode left;
		SegmentNode right;
		SegmentNode(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	private SegmentNode root;

	private SegmentNode buildTree(int[] nums, int start, int end) {
    	if(start > end) return null;
		SegmentNode root = new SegmentNode(start, end);
		if(start == end) {
			root.sum = nums[start];
			return root;
		}
		int mid = start + (end - start) / 2;
		root.left = buildTree(nums, start, mid);
		root.right = buildTree(nums, mid + 1, end);
		if(root.left != null) root.sum += root.left.sum;
		if(root.right != null) root.sum += root.right.sum;
		return root;
    }

	//Build up the segment tree
    public NumArray(int[] nums) {
    	this.root = buildTree(nums, 0, nums.length - 1);
    }

     void update(int i, int val) {
        update(root, i, val);
    }

    void update(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
           root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                 update(root.left, pos, val);
            } else {
                 update(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }
    

    // void update(int i, int val) {
    // 	update(this.root, i, val);
    // }

    // private void update(SegmentNode node, int i, int val) {
    // 	if(node.start == i && node.end == i) {
    // 		node.sum = val;
    // 	}
    // 	node.sum = 0;
    // 	if(node.left != null) {
    // 		if(node.left.start >= i && node.left.end <= i) {
    // 			update(node.left, i, val);
    // 			node.sum += node.left.sum;
    // 		}
    // 	}

    // 	if(node.right != null) {
    // 		if(node.right.start >= i && node.right.end <= i) {
    // 			update(node.right, i, val);
    // 			node.sum += node.right.sum;
    // 		}
    // 	}
    // }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }

    private int sumRange(SegmentNode root, int start, int end) {
    	if(root.start == start && root.end == end) return root.sum;
    	int mid = root.start + (root.end - root.start) / 2;
    	if(end <= mid) {
    		return sumRange(root.left, start, end);
    	} else if(start >= mid + 1) {
    		return sumRange(root.right, start, end);
    	} else {
    		return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
    	}
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);