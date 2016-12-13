// shouldPrintMessage would cost O(1) time and the overall space complexity would be O(n)
// where n is the number of different messages. It would be reasonable to use this design
// when the message types are limited.
public class Logger {

	// Last message occurrence mapping to its last timestamp
	Map<String, Integer> map;

    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
    	if (map.containsKey(message)) {
    		int lastTimestamp = map.get(message);
    		if (timestamp - lastTimestamp < 10) {
    			return false;
    		}
    	}

    	// If not just put the message into the map
    	map.put(message, timestamp);
    	return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */