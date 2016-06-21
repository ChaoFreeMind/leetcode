import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
	//DFS
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adjList = new ArrayList<>();
		buildGraph(adjList, numCourses, prerequisites);
		boolean[] visited = new boolean[numCourses];
		
		for(int i = 0; i < adjList.size(); i++) {
			//If cycle detected return false
			if(!dfs(adjList, visited, i)) return false;
		}
		
		return true;
	}
	
	/*
	 * course: Currently visiting course
	 */
	private boolean dfs(List<List<Integer>> adjList, boolean[] visited, int course) {
		if(visited[course]) return false;
		
		visited[course] = true;
		for(int followup : adjList.get(course)) {
			if(!dfs(adjList, visited, followup)) return false; 
		}
		visited[course] = false;
		return true;
	}
	
	//BFS: Starting from all courses that has no prerequisites.
    /*public boolean canFinish(int numCourses, int[][] prerequisites) {
    	List<List<Integer>> adjList = new ArrayList<>();
    	buildGraph(adjList, numCourses, prerequisites);
    	int[] indegrees = new int[numCourses];//The number of prerequisites needed to be finished.
    	for(int i = 0; i < prerequisites.length; i++) {
    		indegrees[prerequisites[i][0]]++;
    	}
    	
    	Deque<Integer> queue = new ArrayDeque<>();
    	

    	int finishedCourses = 0;
    	for(int i = 0; i < indegrees.length; i++) {
    		if(indegrees[i] == 0) {
    			queue.offer(i);
    			finishedCourses++;
    		}
    	}
    	
    	while(!queue.isEmpty()) {
    		int course = queue.pop();
    		for(int followup: adjList.get(course)) {
    			indegrees[followup]--;
    			if(indegrees[followup] == 0) {
    				queue.offer(followup);
    				finishedCourses++;
    			}
    		}
    	}
    	
    	return finishedCourses == numCourses;
    }*/
    
    private void buildGraph(List<List<Integer>> adjList, int numCourses, int[][] prerequisites) {
    	for(int i = 0; i < numCourses; i++)
    		adjList.add(new ArrayList<>());
    	
    	for(int i = 0; i < prerequisites.length; i++) {
    		adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);//prerequisite points to its follow up course.
    	}
    }
    
}