public class NumArray {
    
    private int[] sum;
    
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int len = nums.length;
        sum = new int[len];
        sum[0] = nums[0];
        
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        
        return i > 0 ? sum[j] - sum[i-1] : sum[j];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);