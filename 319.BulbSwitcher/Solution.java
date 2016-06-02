public class Solution {
    //This problem is all about finding the perfect square number.
    public int bulbSwitch(int n) {
        int cnt = 0;
        for(int i = 1; i * i <= n; i++) {
            cnt++;
        }
        return cnt;
    }
}