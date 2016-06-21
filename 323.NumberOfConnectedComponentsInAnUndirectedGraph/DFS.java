public class Solution {
	private List<List<Integer>> graph;

    public int countComponents(int n, int[][] edges) {
    	boolean[] visited = new int[n];
    	buildGraph(n, edges);
    	int count = 0;//Our result.
    	for(int i = 0; i < n; i++) {
    		if(!visited[i]) {
    			dfs(i, visited);
    			count++;
    		} 
    	}
    	return count;
    }

    private void buildGraph(int n, int[][] edges) {
    	for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
    	for(int i = 0; i < edges.length; i++) {
    		graph.get(edges[i][0]).add(edges[i][1]);
    		graph.get(edges[i][1]).add(edges[i][0]);
    	}
    }
 	
 	private void dfs(int curNode, boolean[] visited) {
 		//Assume curNode is not visited, make sure it's checked before it reaches here.
 		List<Integer> neighbors = graph.get(curNode);
 		visited[curNode] = true;
 		for(int neighbor: neighbors) {
 			if(!visited(neighbor)) {
 				dfs(neighbor, visited);
 			}
 		}
 	}   
}