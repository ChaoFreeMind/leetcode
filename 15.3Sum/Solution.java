public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> resList = new ArrayList<>();
		Arrays.sort(nums);
		
		for(int i = 0; i < nums.length - 2; i++) {
			if(i == 0 || i > 0 && nums[i] != nums[i-1]) {
				int first = nums[i];//Assume nums[i] is the first number
				int sum = -first;
				int low = i + 1, high = nums.length - 1;
				while(low < high) {
					if(nums[low] + nums[high] == sum) {
						int second = nums[low];
						int third = nums[high];
						List<Integer> res = new ArrayList<>();
						res.add(first);
						res.add(second);
						res.add(third);
						resList.add(res);
						//Pass duplicates!
						while(low < high && second == nums[low]) low++;
						while(low < high && third == nums[high]) high--;
						
					} else if(nums[low] + nums[high] < sum) {
						low++;
					} else {
						//nums[low] + nums[high] > sum
						high--;
					}
				}
			}
		}
		
		
		return resList;
    }
}