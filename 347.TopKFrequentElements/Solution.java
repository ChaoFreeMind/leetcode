public class Solution {
	//Bucket sort
    public List<Integer> topKFrequent(int[] nums, int k) {
    	Map<Integer, Integer> frequencyMap = new HashMap<>();
    	List<Map.Entry<Integer, Integer>> buckets = new List<Map.Entry<Integer, Integer>>[nums.length + 1];
 		List<Integer> resList = new ArrayList<>();

 		for(int num: nums) {
 			frequencyMap.putIfAbsent(num, 0);
 			frequencyMap.put(num, frequencyMap.get(num) + 1);
 		}
 		return resList;
    }
}