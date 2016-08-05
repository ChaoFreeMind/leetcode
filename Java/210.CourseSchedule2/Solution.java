public class Solution {
    //BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        buildGraph(adjList, numCourses, prerequisites);
    	int[] indegree = new int[numCourses];
    	int[] res = new int[numCourses];
    	
    	for(int i = 0; i < prerequisites.length; i++) {
    		indegree[prerequisites[i][0]]++;
    	}
    	int resIdx = 0;
    	Deque<Integer> queue = new ArrayDeque<>();
    	for(int i = 0; i < indegree.length; i++) {
    		if(indegree[i] == 0) {
    			queue.offer(i);
    			res[resIdx++] = i;
    		}
    	}
    	
    	while(!queue.isEmpty()) {
    		int base = queue.poll();
    		//Get all follow up courses from this base course.
    		for(int followup : adjList.get(base)) {
    			indegree[followup]--;
    			if(indegree[followup] == 0) {
    				res[resIdx++] = followup;
    				queue.offer(followup);
    			}
    		}
    	}
    	
    	return resIdx == numCourses ? res : new int[0];
    }
    
    private void buildGraph(List<List<Integer>> adjList, int numCourses, int[][] prerequisites) {
    	for(int i = 0; i < numCourses; i++)
    		adjList.add(new ArrayList<>());
    	
    	for(int i = 0; i < prerequisites.length; i++)
    		adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
    }
}