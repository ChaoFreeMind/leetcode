public class PhoneDirectory {

    private Set<Integer> claimed;
    private Deque<Integer> numQueue;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        claimed = new HashSet<>();
        numQueue = new ArrayDeque<>();

        for (int i = 0; i < maxNumbers; i++) {
            numQueue.offer(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        boolean empty = numQueue.isEmpty();
        int res = -1;
        if (!empty) {
            res = numQueue.poll();
            claimed.add(res);
        }
        return res;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !claimed.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if (claimed.remove(number)) {
            numQueue.offer(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */