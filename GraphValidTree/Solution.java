// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

// For example:

// Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

// Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

// Hint:

// Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
// According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
// Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

public class Solution {
    public boolean validTree(int n, int[][] edges) {
		//Build an adjacent list
		List<List<Integer>> adjList = new ArrayList<>();
		//Init adjacency list
		for(int i = 0; i < n; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		//Build up adjacency list
		for(int i = 0; i < edges.length; i++) {
			adjList.get(edges[i][0]).add(edges[i][1]);
			adjList.get(edges[i][1]).add(edges[i][0]);
		}
		
		int[] visited = new int[n];//0:unvisited 1:In the queue(Being visited) 2:Visit complete
		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(0);
		visited[0] = 1;
		while(!queue.isEmpty()) {
			
			int node = queue.poll();
			
			
			for(Integer adjNode: adjList.get(node)) {
				if(visited[adjNode] == 1) return false;//Cycle detected.
				if(visited[adjNode] == 0)  {
					queue.add(adjNode);
					visited[adjNode] = 1;
				}
			}
			
			visited[node] = 2;
			
		}
		
		//Check if there is any nodes being left out
		
		for(int i = 0; i < n; i++) {
			if(visited[i] == 0) return false;
		}
		
        return true;
        
    }
}