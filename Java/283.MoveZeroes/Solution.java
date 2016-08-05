opublic class Solution {
    //Sort of like the bubble sort.
    /*public void moveZeroes(int[] nums) {
        for(int i = nums.length - 1; i >= 0; i++) {
            if(nums[i] == 0) {
                for(int j = i; j < nums.length - 1; i++) {
                    if(nums[j] == 0 && nums[j+1] != 0) swap(nums, i, j);
                }
            }
        }
    }*/
    
    //Revised O(n)
    //Shift non-zero elements to the left, fill the rest with zeros
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) nums[insertPos++] = nums[i];
        }
        
        while(insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}