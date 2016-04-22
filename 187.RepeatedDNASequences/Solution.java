import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  
	//Keep track of two sets, all and res, iterate through the DNA sequence, try to add all of sequences of length of 10 to all, when add returns
	//false, it means the current sequence has been added previously, so we add it to the resSet.
	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> allSet = new HashSet<>();//Use to store all the DNA sequences we met
		Set<String> resSet = new HashSet<>();
		for(int i = 0; i <= s.length() - 10; i++) {
			String seq = s.substring(i, i + 10);
			if(!allSet.add(seq)) resSet.add(seq);
		}
		
		return new ArrayList<>(resSet);
	}
	
}