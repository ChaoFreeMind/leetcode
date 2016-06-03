public class Solution {
	public int minPatches(int[] nums, int n) {
		int covered = 0;
		int patches = 0;
		int i = 0;

		while(covered < n) {
			if(i >= nums.length || nums[i] > (covered + 1)) {
				//Apply patch number (covered + 1)
				patches++;
				covered += covered + 1;
			} else {
				covered += nums[i];
				i++;
			}
		}

		return patches;
	}

}