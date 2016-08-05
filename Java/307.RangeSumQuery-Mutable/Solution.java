//Segment Tree
public class NumArray {

    private class SegmentNode {
        SegmentNode left;
        SegmentNode right;
        int start;
        int end;
        int sum;
        SegmentNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private SegmentNode root;

    public NumArray(int[] nums) {
        this.root = buildTree(nums, 0, nums.length - 1);
    }

    //Post order traversal
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
        //left and right will not be null
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    void update(int i, int val) {
        update(this.root, i, val);
    }

    void update(SegmentNode root, int i, int val) {
        if(root.start == i && root.end == i) {
            root.sum = val;
            return;
        }
        int mid = root.start + (root.start - root.end) / 2;
        if(i >= root.start && i <= mid) {
            update(root.left, i, val);
        } else if(i >= mid + 1 && i <= root.end) {
            update(root.right, i, val);
        }
        root.sum = root.left.sum + root.right.sum;//Update root sum
    }

    public int sumRange(int i, int j) {
        return sumRange(this.root, i, j);
    }

    private int sumRange(SegmentNode root, int i, int j) {
        if(root.start == i && root.end == j) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if(j <= mid) {
            return sumRange(root.left, i, j);
        } else if(i >= mid + 1) {
            return sumRange(root.right, i, j);
        } else {
            return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);