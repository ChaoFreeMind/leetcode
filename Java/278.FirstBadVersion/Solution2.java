/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

// Second attempt
public class Solution extends VersionControl {
    
    public int firstBadVersion(int n) {
    	
    	int res = 0;
    	int left = 1, right = n;
    	int mid = left + (right - left) / 2;
    		
    	while (left <= right) {
    		if(isBadVersion(mid)) {
    			// Go left and mid could potentially be the first bad version
    			right = mid - 1;
    			res = mid;
    		} else {
    			// Simply go right
    			left = mid + 1;
    		}
    		mid = left + (right - left) / 2;
    	}

    	return res;

    }

}