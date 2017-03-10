public class Solution {
	//Will have to work on this problem again, did not have a clue as I first saw it.
    // This solution does not work!!!!
    public int nthSuperUglyNumber(int n, int[] primes) {
 		int[] uglyNums = new int[n];  
 		int[] idx = new int[primes.length];   

 		uglyNums[0] = 1;//The first number will always be 1

 		for(int i = 1; i < n; i++) {
 			for(int j = 0; j < primes.length; j++) {

 				uglyNums[i] = Math.min(uglyNums[idx[j]] * primes[j], uglyNums[i]);
 			}

 			//How to move idx??
 			for(int j = 0; j < primes.length; j++) {
 				while(primes[j] * uglyNums[idx[j]] <= uglyNums[i]) {
 					idx[j]++;
 				}
 			}

 		}

 		return uglyNums[n-1];
    }

}