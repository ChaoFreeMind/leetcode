import java.util.Arrays;

public class Solution {
    //The possible values of h-index lies in [0, len]
    //Sort O(nlgn) time and O(1) space
    /*public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for(int i = 0; i < n; i++) {
            if(citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }*/
    //O(n) time, O(n) space
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] map = new int[len + 1];
        for(int i = 0; i < len; i++) {
            if(citations[i] >= len) map[len]++;
            else map[citations[i]]++;
        }
        //Iterate map array reversely
        int sum = 0;
        for(int i = len; i >= 0; i--) {
            sum += map[i];
            if(sum >= i) return i;
        }
        
        return 0;
    }
    
}