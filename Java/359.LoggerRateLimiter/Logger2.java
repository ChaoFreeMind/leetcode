// Fast!! Beat 90%+;
class Log {

    int timestamp;
    String message;

    Log(int timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }
}

public class Logger {

    // Recent message queue and message dictionary
    Deque<Log> msgQueue;
    Set<String> msgDict; 

    /** Initialize your data structure here. */
    public Logger() {
        msgQueue = new LinkedList<>();
        msgDict = new HashSet<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {

        while (!msgQueue.isEmpty() && msgQueue.peek().timestamp + 10 <= timestamp) {
            // remove the old message from the recent message queue.
            Log logToRemove = msgQueue.poll();
            msgDict.remove(logToRemove.message);
        }

        if (!msgDict.contains(message)) {
            msgQueue.offer(new Log(timestamp, message));
            msgDict.add(message);
            return true;
        }

        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */