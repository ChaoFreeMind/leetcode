public class NumArray {

	private int[] sum;

    public NumArray(int[] nums) {
    	if(nums == null || nums.length == 0) return;
    	//assert nums != null && nums.length > 0
    	sum = new int[nums.length+1];
    	sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
        	sum[i] = sum[i-1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
    	if(i >= 1) {
    		return sum[j] - sum[i-1];
    	}
    	//i < 1
    	return sum[j];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);