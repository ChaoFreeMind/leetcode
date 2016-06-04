public class Solution {
	//Idea 1: Replacing the checked subtree by #!
    /*public boolean isValidSerialization(String preorder) {
    	//Null or empty string
        if(preorder == null || preorder.length() == 0) return false;
    	String[] sequence = preorder.split(",");
    	Deque<String> stack = new ArrayDeque<>();

    	for(int i = 0; i < sequence.length; i++) {
    		String cur = sequence[i];
    		while(cur.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
    			stack.pop();//pop the "#"
    			if(stack.isEmpty()) return false;
    			stack.pop();//pop the number node who is the parent of the # we just poped
    		}
    		stack.push(cur);
    	}

    	return stack.size() == 1 && stack.peek().equals("#");
    }*/
    
    public boolean isValidSerialization(String preorder) {
    	if(preorder == null || preorder.length() == 0) return false;
    	int indegree = -1;//Because root does not provide indegree
    	int outdegree = 0;
    	//During the process indegree should never be greater than outdegree at any point and time.
    	String[] sequence = preorder.split(",");
    	for(int i = 0; i < sequence.length; i++) {
    		String cur = sequence[i];
    		indegree++;
    		//There is no outdegree left to compensate the indegree of the current node.
    		if(indegree > outdegree) return false;
    		if(!cur.equals("#")) {
    			outdegree += 2;
    		}
    	}

    	return indegree == outdegree;
    }
}