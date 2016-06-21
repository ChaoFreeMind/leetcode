/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
	//BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
    	if(root == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();//Map original node to its copy.
       	Deque<UndirectedGraphNode> queue = new ArrayDeque<>();

       	queue.offer(root);
       	UndirectedGraphNode newRoot = new UndirectedGraphNode(root.label);
       	map.put(root, newRoot);

       	while(!queue.isEmpty()) {
       		UndirectedGraphNode node = queue.poll();

       		for(UndirectedGraphNode neighbor: node.neighbors) {
       			if(!map.containsKey(neighbor)) {
       				UndirectedGraphNode newNode = new UndirectedGraphNode(neighbor.label);
       				map.put(neighbor, newNode);
       				queue.offer(neighbor);
       			}
       			//Copy neighbors
       			map.get(node).neighbors.add(map.get(neighbor));
       		}
       	}

       	return newRoot;
    }
    private Set<UndirectedGraphNode> visited = new HashSet<>();
    //DFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
    	if(root == null) return null;
    	UndirectedGraphNode newRoot = new UndirectedGraphNode(root.label);
    	visited.add(root);
    	//For each neighbor of root, clone it and connect to newRoot
    	for(UndirectedGraphNode neighbor: root.neighbors) {
    		if(!visited.contains(neighbor)) {
    			UndirectedGraphNode newNeighbor = cloneGraph(neighbor);	
    		}
    		
    		newRoot.neighbors.add(newNeighbor);
    	}

    	return newRoot;
    }
}