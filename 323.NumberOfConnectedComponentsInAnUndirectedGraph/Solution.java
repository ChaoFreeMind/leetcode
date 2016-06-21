public class Solution {

    public int countComponents(int n, int[][] edges) {
    	int[] parents = new int[n];
    	//Arrays.fill(parents, -1); This is dangerous when there is cycle!!
    	for(int i = 0; i < parents.length; i++) {
    		parents[i] = i;
    	}
    	Set<Integer> set = new HashSet<>();//Store all the root representative of a connected component.
    	
    	for(int i = 0; i < edges.length; i++) {
    		union(parents, edges[i][0], edges[i][1]);
    	}

    	//Go through parents array, for each element, find its component representative, add it to a set.
    	for(int i = 0; i < parents.length; i++) {
    		set.add(find(parents, i));
    	}

    	return set.size();
    }

    /**
     * Find the root parent of a node
     * @param parents Parent array, each element stores the direct parent of a node.
     * @param i node id
     * @return 
     */
    private int find(int[] parents, int i) {
    	//Terminate when parents[i] == i
     	while(parents[i] != i) {
     		//Path compression, cutting down the path from i to root to half
     		//by pointing its parent to its grandparent
     		parents[i] = parents[parents[i]];
    		i = parents[i];
    	}
    	return i;
    }

    /**
     * Union two nodes along with the component they are in together.
     */
    private void union(int[] parents, int i, int j) {
    	int setX = find(parents, i);
    	int setY = find(parents, j);
    	parents[setX] = setY;
    }
}