import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
	
	Deque<Integer> s1 = new ArrayDeque<>();
	Deque<Integer> s2 = new ArrayDeque<>();
	
    // Push element x to the back of queue.
    public void push(int x) {
    	s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!s2.isEmpty()) {
            s2.pop();
            return;
        }
        
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        
        s2.pop();
        //If both stacks are empty, then there is nothing to pop out
    }

    // Get the front element.
    public int peek() {
    	if(!s2.isEmpty()) return s2.peek();
    	while(!s1.isEmpty()) {
    	    s2.push(s1.pop());
    	}
    	
    	return s2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}