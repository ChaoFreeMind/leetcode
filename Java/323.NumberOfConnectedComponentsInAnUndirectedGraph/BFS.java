public class Solution {
	private List<List<Integer>> graph = new ArrayList<>();

    public int countComponents(int n, int[][] edges) {
    	boolean[] visited = new boolean[n];
    	buildGraph(n, edges);
        
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i, visited);
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
    
    private void bfs(int curNode, boolean[] visited) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(curNode);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            for(int neighbor: graph.get(node)) {
                if(!visited[neighbor]) queue.offer(neighbor);
            }
        }       
    }
}