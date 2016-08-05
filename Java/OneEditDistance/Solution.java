public class Solution {
    //Insert Substitute Delete
    public boolean isOneEditDistance(String s, String t) {
		
		return canSubstitute(s, t) || canDelete(s, t);
	}
	
	public boolean canSubstitute(String s, String t) {
		
		if(s.length() != t.length()) return false;
		
		int editDist = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != t.charAt(i)) editDist++;
		}
		
		return editDist == 1 ? true : false;
	}
	//The same as insert just reversed
	private boolean canDelete(String s, String t) {
		
		//Identify the longer/shorter string
		int lenS = s.length(), lenT = t.length();
		if(Math.abs(lenS - lenT) != 1) return false;
		String longer = s.length() > t.length() ? s : t;
		String shorter = s.length() > t.length() ? t : s;
		
		for(int i = 0; i < shorter.length(); i++) {
			if(longer.charAt(i) != shorter.charAt(i)) {
				if(!longer.substring(i + 1).equals(shorter.substring(i))) return false;
			}
		}
		
		return true;
	}
}