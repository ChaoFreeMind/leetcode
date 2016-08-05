public class Solution {
	
	public static void main(String[] args) {
		String s = "asdasdfuncziuxvjzxo";
		char[] carr = s.toCharArray();
		Arrays.sort(carr);
		String ss = new String(carr);
		System.out.println(ss);
	}
	//Time: O(n^2lgn) Space: O(n^2)
    public List<List<String>> groupAnagrams(String[] strs) {
    	Arrays.sort(strs);
    	List<List<String>> resList = new ArrayList<>();
    	Map<String, List<String>> map = new HashMap<>();
    	
    	for(int i = 0; i < strs.length; i++) {
    		char[] carr = strs[i].toCharArray();
    		Arrays.sort(carr);
    		String key = new String(carr);
    		if(!map.containsKey(key)) {
    			map.put(key, new ArrayList<>());
    		}
    		map.get(key).add(strs[i]);
    	}
    	//Iterate through our map add lists to resList
    	//for(Map.Entry<String, List<String>> entry: map.entrySet())
    		//resList.add(entry.getValue());
    	for(String k: map.keySet())
    		resList.add(map.get(k));
    	
    	return resList;
    }
    
}