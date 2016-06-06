public class Solution {
	/*public boolean isPowerOfFour(int num) {
		if(num == 0) return false;//Do not be careless!!
		if(num == 1) return true;
		return num % 4 == 0 && isPowerOfFour(num / 4);
	}*/
	//First of all, power of 4 has one bit set to 1 and rest of those bits are set to 0.
	//The position of 1 bits are located at odd idx.(To distinguish from power of 2)
	public boolean isPowerOfFour(int num) {
		return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) > 0;
	}
}