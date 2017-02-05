// First attempt
public class Solution {
	
	//Just a simulation function
	private boolean isBadVersion(int version) {
		return true;
	}
	//Binary search O(logN) n ranges from 1 to n
	//Assume there is at least one bad version
	public int firstBadVersion(int n) {
        int left = 1, right = n;
        int first = 1;
        while(left <= right) {
        	int mid = left + (right - left) / 2;
        	if(isBadVersion(mid)) {
        		first = mid;//First may be the first bad version, keep searching in the left part
        		right = mid - 1;
        	} else {//Search in the right part
        		left = mid + 1;
        	}
        }
        return first;
    }
}
