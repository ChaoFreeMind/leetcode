public class HitCounter {

    private Deque<Integer> queue;

    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new ArrayDeque<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    // O(1)
    public void hit(int timestamp) {
        
        queue.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    // O(h) where h is the total number of hits 
    public int getHits(int timestamp) {
        // Remove hits that are not in 5 mins span.
        while (!queue.isEmpty() && (timestamp - queue.peek() >= 300)) {
            queue.poll();
        }

        return queue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */