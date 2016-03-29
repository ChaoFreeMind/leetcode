import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * Same as Course Schedule, the only difference is we need to keep track of the course taking order in BFS
 * 
 */

public class Solution {
	
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		
		List<List<Integer>> adjList = new ArrayList<>();
		
		int[] indegrees = new int[numCourses];
		
		//Build up the adjacency list
		initAdjList(numCourses, prerequisites, adjList);
		
		for(int i = 0; i < prerequisites.length; i++) 
			indegrees[prerequisites[i][0]]++;
		
		Deque<Integer> queue = new ArrayDeque<>();
		
		int finishedCourses = 0;
		
		List<Integer> courseOrder = new ArrayList<>(); 
		
		for(int i = 0; i < indegrees.length; i++) {
			
			if(indegrees[i] == 0) { 
				queue.offer(i);
				courseOrder.add(i);
				finishedCourses++;
			}
			
		}
		
		while(!queue.isEmpty()) {
			
			int course = queue.poll();
			for(int followup: adjList.get(course)) {
				
				indegrees[followup]--;
				if(indegrees[followup] == 0) {
					courseOrder.add(followup);
					queue.offer(followup);
					finishedCourses++;
				}
			}
			
		}
		
		if(finishedCourses != numCourses) return new int[0];
		
		return listToArray(courseOrder);
    }
	
//	public static void main(String[] args) {
//		int[] arr = new int[0];
//	}
	
	private int[] listToArray(List<Integer> list) {
		int[] arr = new int[list.size()];
		int idx = 0;
		for(int val: list) {
			arr[idx++] = val;
		}
		
		return arr;
	}
	
	private void initAdjList(int numCourses, int[][] prerequisites, List<List<Integer>> adjList) {
		
		for(int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i = 0; i < prerequisites.length; i++) {
			
			adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
			
		}
		
	}
	
	
}