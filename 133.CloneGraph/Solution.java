import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class Solution {
	//BFS using map
	/*public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null) return null;
		//Use a map to keep track of visited nodes and save cloned nodes
		Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();//Map origin node to newly cloned node
		
		//Use a queue to perform BFS
		Deque<UndirectedGraphNode> queue = new LinkedList<>();
		queue.offer(node);
		//Clone the root
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		visited.put(node, newNode);
		while(!queue.isEmpty()) {
			UndirectedGraphNode nd = queue.poll();
			//Handle the neighbors
			for(UndirectedGraphNode neighbor: nd.neighbors) {
				//Do not revisit nodes that are already visited
				if(!visited.containsKey(neighbor)) {
					visited.put(neighbor, new UndirectedGraphNode(neighbor.label));//Create new cloned node
					queue.offer(neighbor);
				}
				//Copy neighbors
				visited.get(nd).neighbors.add(visited.get(neighbor));
			}	
		}	
		return newNode;
	}*/
	private Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
	//DFS faster... why??
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null) return null;
		//If this node has already been visited, return the cloned node from map
		if(map.containsKey(node)) return map.get(node);
		//Clone the node
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		map.put(node, newNode);
		
		for(UndirectedGraphNode neighbor: node.neighbors) {
			newNode.neighbors.add(cloneGraph(neighbor));
		}
		
		return newNode;
	}
	
}