//Reference: http://www.geeksforgeeks.org/union-find/
public class Solution {

    public boolean validTree(int n, int[][] edges) {
 		int[] parent = new int[n];
 		Arrays.fill(parent, -1);
 		for(int i = 0; i < edges.length; i++) {
 			int setX = find(parent, edges[i][0]);
 			int setY = find(parent, edges[i][1]);

 			if(setX == setY) return true;

 			parent[setX] = setY;

 			//Union 2 sets
 		}

 		return n-1 == edges.length;
    }

    /**
     * Find the root parent of i
     * @param parent An array stores the direct parent of a node
     * @param i node id
     */
    private int find(int[] parent, int i) {
    	if(i == -1) return i;
    	return find(parent, parent[i]);
    }

    /**
     * Union 2 nodes together
     * @param i, j Two nodes we need to union them together
     * @param parent Parent array which stores the direct parent of a node
     */
    private void union(int[] parent, int i, int j) {
    	int seti = find(parent, i);
    	int setj = find(parent, j);
    	parent[seti] = setj;
    }
}