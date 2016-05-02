public class Solution {
	//Assume citations is already sorted, we can try to apply binary search on it.
    public int hIndex(int[] citations) {
    	
    	int len = citations.length;
    	int left = 0, right = len - 1;
    	int hindex = 0;
    	while(left <= right) {
    		int mid = left + (right - left) / 2;
    		if(citations[mid] == len - mid) {
    			return len - mid;
    		} else if(citations[mid] > len - mid){
    			hindex = len - mid;//Could be a potential hindex but we have to keep searching for the maximum one.
    			right = mid - 1;
    		} else {
    			left = mid + 1;
    		}
    	}
    	
    	return hindex;
    }
    
}