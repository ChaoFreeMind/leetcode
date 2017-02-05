// With cache we can run in 26ms; 
// Without using cache, we could only achieve 260ms
public class Solution {

	private Map<String, Boolean> cache = new HashMap<>();

    public boolean canWin(String s) {
    	if (s == null || s.length() <= 1) {
    		return false;
    	}

    	// Try to come up with all valid move at current turn, and see if the opponent can win under each
    	// situations.
    	for (int i = 0; i < s.length() - 1; i++) {
    		if (s.startsWith("++", i)) {
    			// Replace "++" with "--"
    			String ns = s.substring(0, i) + "--" + s.substring(i + 2, s.length());

    			if (cache.containsKey(ns)) {
    				boolean res = cache.get(ns);
    				if (!res) return true;
    			} else {
    				boolean cw = canWin(ns);
    				if (!cw) return true;
    				cache.put(ns, cw);
    			}
    		}
    	}

    	return false;
    }
}