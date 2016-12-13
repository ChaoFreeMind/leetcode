public class Solution {
	// Greedy, not optimized to keep it more readable
    public int findContentChildren(int[] g, int[] s) {
    	// Two pointers
		int idxG = 0, idxS = 0;
		int counter = 0;
		Arrays.sort(g);
		Arrays.sort(s);
		while (idxG < g.length && idxS < s.length) {
			if (g[idxG] <= s[idxS]) {
				counter++;
				idxG++;
				idxS++;
			} else {
				idxS++;
			}
		}
		return counter;
    }
}