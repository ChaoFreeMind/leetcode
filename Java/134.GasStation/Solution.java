public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	if(gas == null || cost == null || gas.length == 0 || cost.length == 0) return -1;
    	
    	//If the sum of all gas[i] - cost[i] is less than zero, then there is no solution
    	int sum = 0;
    	//If we start from point i and failed at point j, it means if we start from any
    	//point between i and j, we still can not reach j.
    	//Proof: 
    	int start = 0;
    	int tank = 0;
    	for(int i = 0; i < gas.length; i++) {
    		tank += gas[i] - cost[i];
    		sum += gas[i] - cost[i];
    		if(tank < 0) {
    			start = i + 1;
    			tank = 0;
    		}
    	}
    	
    	if(sum < 0) return -1;
    	
    	return start;
    }
}