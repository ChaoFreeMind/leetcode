public class Solution {
	//Naive solution
    /*public int addDigits(int num) {
    	
    	while(num >= 10) {
    		int temp = num;
    		num = 0;
    		while(temp != 0) {
    			num += temp % 10;
    			temp /= 10;
    		}
    	}
    	
    	return num;
    }*/
    
    //Follow up
    //Enumerate all numbers from 10 to 20, we found that the result starts from 1 to 9 and again repeats itself
	public int addDigits(int num) {
		if(num == 0) return 0;
		return num % 9 != 0 ? num % 9 : 9;
	}
	
}