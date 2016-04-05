import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public int reverse(int num) {
		
		long sum = 0;
		while(num != 0) {
			sum = sum * 10 + num % 10;
			if(sum < Integer.MIN_VALUE || sum > Integer.MAX_VALUE) return 0;
			num /= 10;
		}
		
		return (int)sum;
	}
	
	//Leveraging long to prevent overflow(STUPID)
//	public int reverse(int num) {
//		
//		if(num == 0) return 0;
//		
//		boolean negative = num < 0;
//		StringBuilder sb = new StringBuilder();
//		long longNum = num;
//		long abs = Math.abs(longNum);
//		while(abs != 0) {
//			sb.append(abs % 10);
//			abs /= 10;
//		}
//		
//		int ret = 0;
//		long reversedLong = Long.parseLong(sb.toString()) * (negative ? -1 : 1);
//		if(reversedLong > Integer.MAX_VALUE || reversedLong < Integer.MIN_VALUE) {
//			return ret;
//		}
//		
//		ret = (int)reversedLong;
//		
//		return ret;
//	}
	
}
