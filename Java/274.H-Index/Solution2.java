public class Solution {
    // nlg(n) solution. Sort in java would take at least lgn stack space.
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = n - 1; i >= 0; i--) {
            if (citations[n - 1 - i] >= (i + 1)) {
                return i + 1;
            }
        }
        return 0;
    }

    // O(n) time and O(n) space
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] map = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                map[n]++;
            } else {
                map[citations[i]]++;
            }
        }

        int prevSum = 0;
        for (int i = map.length - 1; i >= 0; i--) {
            if (map[i] + prevSum >= i) return i;
            prevSum += map[i];
        }
        return 0;
    }
}