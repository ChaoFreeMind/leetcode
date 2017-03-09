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
        Map<Integer, Boolean> map = new HashMap<>();

        // A 32-bit integer has 32 bits, the total number of integers we can choose from is 20, 
        // to we can just use a 32-bit integer instead of a boolean array.
        int state = 0;
        
        return play(maxChoosableInteger, state, desiredTotal, map);
    }

    private boolean play(int maxInt, int state, int target, Map<Integer, Boolean> map) {

        if (target <= 0) return false;

        if (!map.containsKey(state)) {

            for (int i = 1; i <= maxInt; i++) {
                if ((state & (1 << i)) == 0) {
                    // Opponent play
                    boolean opponentWin = play(maxInt, state|(1 << i), target - i, map);
                    if (!opponentWin) {
                        map.put(state, true);
                        return true;
                    }
                }
            }
            map.put(state, false);
        }
        return map.get(state);
    }

}