//Delete leaves layer by layer util there is only one or two nodes left.
public class Solution {
	private List<List<Integer>> adjList = new ArrayList<>();

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		int[] degrees = new int[n];
		buildGraph(n, edges);
		Deque<Integer> leaves = new ArrayDeque<>();
		for(int i = 0; i < n; i++) {
			//Leaf or root node
			if(adjList.get(i).size() == 1 || adjList.get(i).size() == 0) {
				leaves.add(i);
			}
		}

		//For each leaf node, delete them and check their neighbors for leaves.
		while(n > 2) {
			int size = leaves.size();//Layer by layer
			n -= size;
			for(int i = 0; i < size; i++) {
				int leaf = leaves.poll();
				//Delete leaf in all its neighbors' adjList
				List<Integer> neighbors = adjList.get(leaf);
				Iterator<Integer> iter = neighbors.iterator();
				while(iter.hasNext()) {
					int neighbor = iter.next();
					adjList.get(neighbor).remove((Integer)leaf);//Tricky!! remove(int idx)/remove(Obj obj)
					//If the neighbor becomes a leaf after deleting the current leaf, 
					//add it to the next layer
					if(adjList.get(neighbor).size() == 1) {
						leaves.offer(neighbor);
					}
				}
			}
		}

		return new ArrayList(leaves);
	}
	//Build graph represented by adjacency list
	private void buildGraph(int n, int[][] edges) {
		for(int i = 0; i < n; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		for(int i = 0; i < edges.length; i++) {
			adjList.get(edges[i][0]).add(edges[i][1]);
			adjList.get(edges[i][1]).add(edges[i][0]);
		}
	}



}