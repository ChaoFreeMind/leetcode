import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of integers that might contain duplicates, nums, return all possible subsets.
//
//Note:
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//For example,
//If nums = [1,2,2], a solution is:
//
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//]
public class Solution {
    //Actually we do not need visited array
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if(nums == null || nums.length == 0) return resList;
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        backtrack(resList, res, nums, 0);
        return resList;
    }
    
    private void backtrack(List<List<Integer>> resList, List<Integer> res, int[] nums, int start) {
        
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;//Greater than start is important here
            res.add(nums[i]);
            resList.add(new ArrayList<>(res));
            backtrack(resList, res, nums, i + 1);
            res.remove(res.size() - 1);
        }
        
    }
    
}



//Visited can be removed!!
    // public List<List<Integer>> subsetsWithDup(int[] nums) {
    //     List<List<Integer>> resList = new ArrayList<>();
    //     resList.add(new ArrayList<>());//Empty set
    //     if(nums == null || nums.length == 0) return resList;
    //     Arrays.sort(nums);
    //     List<Integer> res = new ArrayList<>();
    //     boolean[] visited = new boolean[nums.length];
    //     backtrack(resList, res, nums, 0, visited);
    //     return resList;
    // }
    
    // private void backtrack(List<List<Integer>> resList, List<Integer> res, int[] nums, int start, boolean[] visited) {
        
    //     for(int i = start; i < nums.length; i++) {
    //         if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
    //         visited[i] = true;
    //         res.add(nums[i]);
    //         resList.add(new ArrayList<>(res));
    //         backtrack(resList, res, nums, i + 1, visited);
    //         visited[i] = false;
    //         res.remove(res.size() - 1);
    //     }
        
    // }