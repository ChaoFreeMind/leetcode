class MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
	//Push twice: first the number x, second the minimum element after pushing x
    public void push(int x) {
    	if(!stack.isEmpty()) {
    		int min = getMin();
            stack.push(x);
            if(x < min) {
            	stack.push(x);
            } else {
            	stack.push(min);
            }
    	} else {//Stack is empty
    		stack.push(x);
    		stack.push(x);
    	}
        
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
    	int min = stack.pop();
    	int top = stack.pop();
    	stack.push(top);
    	stack.push(min);
    	return top;
    }

    public int getMin() {
    	return stack.peek();
    }
}

// 2nd Way: PriorityQueue FTW
public class MinStack {

    private Deque<Integer> stack;
    private PriorityQueue<Integer> minQueue;
    /** initialize your data structure here. */
    // Find min again
    public MinStack() {
        stack = new LinkedList<>();
        minQueue = new PriorityQueue<>();
    }
    
    public void push(int x) {
            stack.push(x);
            minQueue.add(x);
    }
    
    public void pop() {
            int top = stack.pop();
            if (top == minQueue.peek()) {
                minQueue.poll();
            }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minQueue.peek();
    }
}
