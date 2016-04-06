public class Solution {
    //BORING
    public int removeDuplicates(int[] nums) {
        //Start with first position filled already.
        int empty = 1;//Next position to fill.
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[empty++] = nums[i];
            }
        }
        
        return empty;
    }
    
}