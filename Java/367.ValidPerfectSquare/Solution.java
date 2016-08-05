public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().isPerfectSquare(16));
	}

	public boolean isPerfectSquare(int num) {

		long left = 0, right = num;

		while(left <= right) {
			long mid = left + (right - left) / 2;
			long square = mid * mid;

			if(square < num) {
				left = mid + 1;
			} else if(square > num) {
				right = mid - 1;
			} else {//square == num
				return true;
			}
		}

		return false;
	}
	
}