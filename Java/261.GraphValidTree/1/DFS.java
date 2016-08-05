import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	
	//Detect cycle: (Note the corner case: an edge connecting vertex to itself which is a loop
	//All nodes are connected
	private List<Set<Integer>> graph = new ArrayList<>();
	
	
	public static void main(String[] args) {
		int[][] edges = {{0,1},{0,2},{2,3},{2,4}};
		boolean isValid = new Solution().validTree(5, edges);
		System.out.println(isValid);
	}
	
    public boolean validTree(int n, int[][] edges) 	{
    	//Build up the graph
    	buildGraph(n, edges);
    	boolean[] visited = new boolean[n];
    	if(hasCycle(0, -1, visited)) return false;

    	for(int i = 0; i < visited.length; i++) {
    		if(!visited[i]) return false;
    	}

    	return true;
    }

    /**
     * Detect is the graph starting from current node has a cycle using DFS
     * @param current Currently checking node
     * @param parent The parent node of current
     * @param visited An array that we can use to check if a node is visited.
	 */
 	private boolean hasCycle(int current, int parent, boolean[] visited) {
 	    Set<Integer> neighbors = graph.get(current);
 		visited[current] = true;
 		for(int neighbor: neighbors) {
 			if(visited[neighbor] && neighbor != parent || !visited[neighbor] && hasCycle(neighbor, current,visited)) return true;
 		}
 		return false;
 	}

    /**
     * Build the graph from edges
     * @param n number of nodes
     * @param edges edges stored in 2d array
     * @return void
     */
    private void buildGraph(int n, int[][] edges) {
    	for(int i = 0; i < n; i++) {
    		graph.add(new HashSet<>());
    	}

    	for(int i = 0; i < edges.length; i++) {
    		graph.get(edges[i][0]).add(edges[i][1]);
    		graph.get(edges[i][1]).add(edges[i][0]);
    	}
    }

}