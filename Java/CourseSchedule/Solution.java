public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
		
		List<List<Integer>> adjList = new ArrayList<>();
		for(int i = 0; i < numCourses; i++) {
			adjList.add(new ArrayList<>());
		}
		
//		Deque<Integer> queue = new LinkedList<Integer>();
		
		//1.Find all courses that do not need prerequisites.(whose indegree equals to 0)
		int[] indegrees = new int[numCourses];
		
		for(int i = 0; i < prerequisites.length; i++) {
			adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
			//[0,1]: prerequisites[i][1] is the prerequisite of prerequisites[i][0]
			indegrees[prerequisites[i][0]]++;
		}
		
		int finishedCourses = 0;
		
		Deque<Integer> queue = new LinkedList<>();
		
		for(int i = 0; i < indegrees.length; i++) {
			if(indegrees[i] == 0) {
				queue.add(i);
				finishedCourses++;
			}
		}
		
		
		while(!queue.isEmpty()) {
			
			int node = queue.poll();//Currently visiting node
			//Get the following up courses based on node
			for (int followup: adjList.get(node)){
				indegrees[followup]--;
				if(indegrees[followup] == 0) {
					//The followup course is finished!
					queue.offer(followup);
					finishedCourses++;
				}
			}
		}
		
		
		return finishedCourses == numCourses;
	}
}