//Just see if there is cycle in the graph.
//TLE!!! Because there are duplicated checking!!! After a path has been checked without cycle, when they are revisited by other checking paths, they should not be checked again!!
public class Solution {

    private List<List<Integer>> graph = new ArrayList<>();//Directed graph

    public boolean canFinish(int numCourses, int[][] prerequisites) {
		buildGraph(numCourses, prerequisites);
		boolean[] visited = new boolean[numCourses];

		for(int i = 0; i < numCourses; i++) {
			if(hasCycle(i, visited)) return false;
		}

		return true;
	}

	private boolean hasCycle(int curCourse, boolean[] visited) {
		if(visited[curCourse]) return true;
		visited[curCourse] = true;
		for(int next: graph.get(curCourse)) {
			if(!dfs(next, visited)) return true;
		}
		visited[curCourse] = false;
		return false;
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