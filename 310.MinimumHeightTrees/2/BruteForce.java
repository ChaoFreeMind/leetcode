
public class Solution {

	private List<List<Integer>> graph = new ArrayList<>();
    //For each node in the graph, compute the height of the tree.
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	buildGraph(n, edges);
        Set<Integer> minSet = new HashSet<>();
        int min = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            int height = getHeight(i, visited);
            if(height == min) {
                minSet.add(i);
            } else if(height < min) {
                minSet.clear();
                minSet.add(i);
            }
        }
    	return new ArrayList<Integer>(minSet);
    }

    /*
     * Get the height of the tree via DFS
     */
    private int getHeight(int root, boolean[] visited) {
        int maxHeight = 0;
        visited[root] = true;
        List<Integer> neighbors = graph.get(root);
        for(int neighbor: neighbors) {
            if(!visited[neighbor]) {
                maxHeight = Math.max(maxHeight, getHeight(neighbor, visited));
            }
        }
        visited[root] = false;
        return maxHeight + 1;
    }

    /*
     * Build up the graph by edges
     * @param n number of nodes
     * @param edges edges represented by 2d array
     * @return void
     */
    private void buildGraph(int n, int[][] edges) {
    	//Initialize adjacency list
    	for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

    	for(int i = 0; i < edges.length; i++) {
    		graph.get(edges[i][0]).add(edges[i][1]);
    		graph.get(edges[i][1]).add(edges[i][0]);
    	}

    }
}