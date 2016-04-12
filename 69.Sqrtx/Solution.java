
public class Solution {

	// Implement int sqrt(int x).
	// Compute and return the square root of x.
	public int mySqrt(int x) {
		//if x is negative number, return -1;
		if(x < 0) return -1;
		if(x == 0) return 0;
		int res = 0;
		int left = 1, right = x;
		while(left <= right) {
			int mid = left + right - left / 2;
			if(mid == x / mid) {
				return mid;
			} else if(mid < x / mid) {
				left = mid + 1;
				res = mid;
			} else {//mid > x / mid
				right = mid - 1;
			}
		}
		
		return res;
	}

}
