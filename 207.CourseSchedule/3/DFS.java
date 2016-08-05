//prerequisites[0,1] means that if you want to finish course 0, you must take course 1. In our directed graph, there is an edge from 1 to 0

public class Solution {
	//Observation: If you want to finish the course, the dependancy graph must not have cycles
	//DFS detect cycles

	private List<List<Integer>> graph = new LinkedList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

    	buildGraph(numCourses, prerequisites);
    	int[] visited = new int[numCourses];
    	for(int i = 0; i < numCourses; i++) {
    		if(hasCycle(i, visited)) {
    			return false;
    		}
    	}

    	return true;
    }
    //Detect if there is a cycle starting from @param course.
    private boolean hasCycle(int course, int[] visited) {
    	visited[course] = 1;//Visited 
    	for(int next: graph.get(course)) {
    		if(visited[next] == 1) return true;//Cycle detected
    		if(visited[next] == 0 && hasCycle(next, visited)) return true;
    		//visited[next] == 2 no need to recheck it.
    	}
    	//Must unvisit current course, in case of (0->1 2->3 3->1)
    	visited[course] = 2;//done checking, no cycle detected
    	return false;
    }

    //Build up our directed graph
    private void buildGraph(int numCourses, int[][] prerequisites) {
    	for(int i = 0; i < numCourses; i++) {
    		graph.add(new LinkedList<>());
    	}

    	for(int i = 0; i < prerequisites.length; i++) {
    		graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
    	}
    }


}