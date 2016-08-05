import java.util.ArrayList;
import java.util.List;
public class Solution {
    
    //Since we went through the nums array once the time complexity is O(n)
    //Space complexity is O(1)
    public List<String> summaryRanges(int[] nums) {
        List<String> resList = new ArrayList<>();
        if(nums == null || nums.length == 0) return resList;
        
        int from = nums[0], to = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - to == 1) {
                to = nums[i];//Expand the range by one
            } else {
                //Add previous range to result list
                String range = (from == to) ? String.valueOf(from) : from + "->" + to;
                resList.add(range);
                //update new range
                from = nums[i];
                to = nums[i];
            }
        }
        
        //Deal with last range!
        String range = (from == to) ? String.valueOf(from) : from + "->" + to;
        resList.add(range);
        
        return resList;
    }
    
}