public class MovingAverage {

	Deque<Integer> queue;
	int sum;
	int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
    	queue.offer(val);
    	sum += val;
    	// At this point size of queue could be greater than size
    	if (queue.size() > size) {
    		// Dequeue the head of queue to maintian size
    		int front = queue.poll();
    		sum -= front;
    	}
    	return (sum * 1.0) / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */