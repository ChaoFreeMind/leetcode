public class NumArray {

	int[] bit;//Binary indexed tree
	int[] nums;
    public NumArray(int[] nums) {
    	this.nums = new int[nums.length];
    	this.bit = new int[nums.length + 1];
    	for(int i = 0; i < nums.length; i++) {
    		this.nums[i] = nums[i];
    		update(i, nums[i]);
    	}
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        i++;//The BIT algorithm uses 1 based index
        while(i < bit.length) {
        	bit[i] += diff;
        	i = i + (i & -i);
        }
    }

    private int getSum(int i) {
    	int sum = 0;
    	while(i > 0) {
    		sum += bit[i];
    		i = i - (i & -i);
    	}
    	return sum;
    }

    public int sumRange(int i, int j) {
    	if(i == 0) return getSum(j);
   		return getSum(j) - getSum(i);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);