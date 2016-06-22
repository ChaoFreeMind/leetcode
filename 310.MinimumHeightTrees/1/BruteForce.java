//Brute Force Solution
public class Solution {

	private List<List<Integer>> adjList = new ArrayList<>();
	// private List<Integer> leaves = new ArrayList<>();
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	buildGraph(adjList, n, int[][] edges);
        boolean visited = new boolean[n];//n is zero-based
        List<Integer> resList = new ArrayList<>();
        int minHeight = Integer.MAX_VALUE;
        //O(n^2)
        for(int i = 0; i < n; i++) {
        	int height = dfs(i, visited);
            if(height < minHeight) {
                minHeight = height;
                resList.clear();//O(n)
                resList.add(height);
            } else if(height == minHeight){
                resList.add(height);
            }
        }

        return resList;
    }

    //O(n) time
    //Return the height of the tree whose root is specified as root
    private int dfs(int root, boolean[] visited) {
        int max = 0;
        visited[root] = true;
        for(int neighbour: adjList.get(root)) {
            if(!visited[neighbour]) {
                max = Math.max(dfs(neighbour, visited), max);
            }
        }
        //unvisit root
        visited[root] = false;
        return max + 1;
    }

    //Build graph represented by adjacency list and collect all leaves into a list
    private void buildGraph(int n, int[][] edges) {
    	for(int i = 0; i < n; i++) {
    		adjList.add(new ArrayList<Integer>());
    	}

    	for(int i = 0; i < edges.length; i++) {
    		adjList.get(edges[i][0]).add(edges[i][1]);
    		adjList.get(edges[i][1]).add(edges[i][0]);
    	}

    	// for(int i = 0; i < edges.length; i++) {
    	// 	if(adjList.get(i).size() == 1) leaves.add(i);
    	// }
    }
}