public class Solution {
    //0 XOR any number = that number. (a ^ b) ^ c = a ^ (b ^ c) 
	//Without extra space
	public int singleNumber(int[] nums) {
		int n = 0;
		for(int i = 0; i < nums.length; i++) {
			n ^= nums[i]; 
		}
		return n;
    }
}