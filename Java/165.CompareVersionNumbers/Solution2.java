public class Solution {
	// Assume version1 and version2 are all valid
    public int compareVersion(String version1, String version2) {
        String[] parsed1 = version1.split("\\.");
        String[] parsed2 = version2.split("\\.");
        // Iterate through two versions at the same time, the shorter one compensate with 0.
        for (int i = 0; i < Math.max(parsed1, parsed2); i++) {
        	Integer num1 = i < parsed1.length ? Integer.parseInt(parsed1[i]) : 0;
        	Integer num2 = i < parsed2.length ? Integer.parseInt(parsed2[i]) : 0;
        	int res = num1.compareTo(num2);
        	if (res != 0) return res;
        }
        return 0;
    }
}