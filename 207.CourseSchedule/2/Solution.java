public class Solution {
	//First find out all the basic courses(those without prerequisites), then run bfs on all of them, check visited array
    private List<List<Integer>> graph = new ArrayList<>();//Directed graph

    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	int[] preCounts = new int[numCourses];
    	for(int i = 0; i < prerequisites.length; i++) {
    		preCounts[prerequisites[i][0]]++;
    	}

    	Deque<Integer> queue = new ArrayDeque<>();
    	for(int i = 0; i < preCounts.length; i++) {
    		if(preCounts[i] == 0) queue.offer(i);
    	}

    	while(!queue.isEmpty()) {
    		int course = queue.poll();
    		for(int next: graph.get(course)) {
    			if(--preCounts[next] == 0) {
    				numCourses--;
    				queue.offer(next);
    			}
    		}
    	}

    	return numCourses == 0;
    }



    /**
     * Build up the graph represented by adjacency list
     * @return The set of basic courses
     */
    private void buildGraph(int numCourses, int[][] prerequisites) {

    	for(int i = 0; i < numCourses; i++) {
    		graph.add(new ArrayList<>());
    	}

    	for(int i = 0; i < prerequisites.length; i++) {
    		graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
    	}
    }
}