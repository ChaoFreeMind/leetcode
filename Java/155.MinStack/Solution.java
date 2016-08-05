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
