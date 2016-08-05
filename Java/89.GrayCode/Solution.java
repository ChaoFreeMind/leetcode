import java.util.ArrayList;
import java.util.List;

//The gray code is a binary numeral system where two successive values differ in only one bit.
//
//Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
//
//For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
//
//00 - 0
//01 - 1
//11 - 3
//10 - 2
//Note:
//For a given n, a gray code sequence is not uniquely defined.
//
//For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
//
//For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
public class Solution {
  
	// grayCode = 0 | grayCode(n-1) + reverse(1 | grayCode(n-1))
	public static void main(String[] args) {
		System.out.println(new Solution().grayCode(4));
	}
	
	public List<Integer> grayCode(int n) {
		List<Integer> resList = new ArrayList<>();
		grayCode(n, resList);
		return resList;
    }
	
	private void grayCode(int n, List<Integer> resList) {
		if(n == 0) {
			resList.add(0);
			return;
		}
		
		grayCode(n-1, resList);
		
		for(int i = resList.size() - 1; i >= 0; i--) {
			
			resList.add(resList.get(i) | 1 << (n-1));
			
		}
		
	}
	
}