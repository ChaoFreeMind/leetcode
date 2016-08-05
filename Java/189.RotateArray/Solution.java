import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		new Solution().rotate(nums, 2);
		System.out.println(Arrays.toString(nums));
	}
	
	//Regular k % len space Easy to make mistake
    /*public void rotate(int[] nums, int k) {
    	k = k % nums.length;
    	int[] temp = new int[k];
    	//Backup first k % len in the front
    	System.arraycopy(nums, nums.length - k, temp, 0, k);
        //First n - k copy to the end
    	System.arraycopy(nums, 0, nums, k, nums.length - k);
    	//Copy first k % len back to the front
    	System.arraycopy(temp, 0, nums, 0, k);
    }*/
	
	//Reversal
    public void rotate(int[] nums, int k) {
    	k = k % nums.length;
    	reverse(nums, 0, nums.length - k - 1);
    	reverse(nums, nums.length - k, nums.length - 1);
    	reverse(nums, 0, nums.length - 1);
    }
    //Reverse elements in a range
    private void reverse(int[] nums, int from, int to) {
    	while(from < to) {
    		int temp = nums[from];
    		nums[from] = nums[to];
    		nums[to] = temp;
    		from++;
    		to--;
    	}
    }
}