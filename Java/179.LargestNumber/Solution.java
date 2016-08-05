public class Solution {
    //Note that we have to get rid of leading zeros!!
    public String largestNumber(int[] nums) {
    	if(nums == null || nums.length == 0) return "";
    	List<String> strs = new ArrayList<>();
    	
    	//Add all nums as strings into strs
    	for(int i = 0; i < nums.length; i++) {
    		strs.add(String.valueOf(nums[i]));
    	}
    	
    	//It is important to write this line of code correctly in the interview without the help from IDE
    	Collections.sort(strs, new Comparator<String>() {
    		public int compare(String a, String b) {
    			String s1 = a + b;
    			String s2 = b + a;
    			return s1.compareTo(s2);
    		}
    	});
    	//Get rid of leading zeros. Like: [0,0,0,0]
    	if(strs.size() >= 1 && strs.get(strs.size() - 1).equals("0")) return "0"; 
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = strs.size() - 1; i >= 0; i--) {
    		sb.append(strs.get(i));
    	}
    	
    	
    	
    	return sb.toString();
    }
}