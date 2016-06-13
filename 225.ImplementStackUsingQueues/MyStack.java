//The problem does not ask us to implement all operations in O(1), 
//First make it work, then make it better.
class MyStack {
    Deque<Integer> queue = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        for(int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}