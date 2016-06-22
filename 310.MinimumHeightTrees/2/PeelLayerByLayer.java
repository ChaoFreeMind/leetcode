public class Solution {

	private List<List<Integer>> graph = new ArrayList<>();

	//Peel all leaf nodes layer by layer
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        buildGraph(n, edges);

        Deque<Integer> leaves = new ArrayDeque<>();
        //Find out all leaves: Leaf's adjacency list only has one element.
        for(int i = 0; i < graph.size(); i++) {
        	if(graph.get(i).size() == 1) leaves.offer(i);
        }

        while(n > 2) {
        	int leafCount = leaves.size();
        	n -= leafCount;
        	//For each leaf node, delete itself in its neighbor's adjList.
        	for(int i = 0; i < leafCount; i++) {
        		int leaf = leaves.poll();
        		List<Integer> neighbors = graph.get(leaf);
        		Iterator<Integer> iter = neighbors.iterator();
        		while(iter.hasNext()) {
        			int neighbor = iter.next();
        			graph.get(neighbor).remove((Integer)leaf);
        			if(graph.get(neighbor).size() == 1) leaves.offer(neighbor);
        		}
        	}
        }

        return new ArrayList<>(leaves);
    }

    private void buildGraph(int n, int[][] edges) {
    	for(int i = 0; i < n; i++) {
    		graph.add(new ArrayList<>());
    	}

    	for(int i = 0; i < edges.length; i++) {
    		graph.get(edges[i][0]).add(edges[i][1]);
    		graph.get(edges[i][1]).add(edges[i][0]);
    	}
    }

}