// The original solution will have TLE, because there are many duplicated subproblems down the 
// recursive tree.

// Say the numbers we could choose from are 1, 2, 3 and the target is 4. For a specific 
// situation represented by the used array, if we draw the recursion tree, if player1 choose 1,
// player2 choose 2, player1 will win. Then if player1 choose 2, player2 choose 1, player1 will
// also win because these two cases are basically the same. 

public class Solution {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        
        // If the sum of 1...maxChoosableInteger is smaller than desiredTotal, return false
        // S = (a1 + an)*n/2
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (desiredTotal > sum) return false;
        
        // The meaning of an entry in this map is that: under current situation represented by the 
        // String, you will win or lose.
        Map<String, Boolean> map = new HashMap<>();

        int[] used = new int[maxChoosableInteger + 1];
        
        return play(maxChoosableInteger, used, desiredTotal, map);
    }

    private boolean play(int maxInt, int[] used, int target, Map<String, Boolean> map) {

        if (target <= 0) return false;
        // String key = Arrays.toString(used);
        String key = Arrays.toString(used);
        if (!map.containsKey(key)) {

            for (int i = 1; i <= maxInt; i++) {
                if (used[i] == 0) {
                    used[i] = 1;
                    // Opponent play
                    boolean opponentWin = play(maxInt, used, target - i, map);
                    used[i] = 0;
                    if (!opponentWin) {
                        map.put(key, true);
                        return true;
                    }
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }

}