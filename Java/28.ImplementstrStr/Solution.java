public class Solution {
    // public int strStrStupid(String haystack, String needle) {
    //     return haystack.indexOf(needle);
    // }

	public int strStr(String haystack, String needle) {
		// StringBuilder sb = new StringBuilder();
		int needleLen = needle.length();
		int start = 0;
		while (start + needleLen <= haystack.length()) {
			String temp = haystack.substring(start, start + needleLen);
			if (temp.equals(needle)) return start;
			start++;
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		// Corner cases
		System.out.println("".indexOf(""));
		System.out.println(sol.strStr("", "a"));
		System.out.println(sol.strStr("abc", "c"));
		System.out.println(sol.strStr("abcaef", "cae"));
	}

}

