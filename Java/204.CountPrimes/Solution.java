public class Solution {
	//Naive implementation
    public int countPrimes(int n) {
        
    }
    //Sieve of Eratosthenes
    public int countPrimes(int n) {
    	boolean[] composite = new boolean[n + 1];
    	int counter = 0;
    	for(int i = 2; i <= n; i++) {
    		if(!composite[i]) {
    			counter++;
    			for(int j = 2; i * j <= n; j++) {
    				composite[i * j] = true;
    			}
    		}
    	}

    	return counter;
    }
}