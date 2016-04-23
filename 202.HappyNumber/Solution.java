public class Solution {
    //Leverage a set to store all the generated numbers, everytime after we generated a new n, we try to add it into the set, 
	//if failed, that means we caught a loop, return false.
    public boolean isHappy(int n) {
    	Set<Integer> set = new HashSet<>();
    	while(set.add(n)) {
    		//Break n, compute next generated number
    		int newNum = 0;
    		while(n != 0) {
    			newNum += (n % 10) * (n % 10);
        		n/=10;
    		}
    		if(newNum == 1) return true;
    		n = newNum;
    	}
    	
    	return false;
    }
    
}