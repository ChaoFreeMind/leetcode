public class Solution {

	// First make sure int does not overflow, the MAX_INTEGER is 2xxxxxxxxx(10 digits)
	// And the biggest result possible is 20000 * 20000 + 20000 * 20000 which is 800000000(9 digits)
	// so integer is good here.
	private int getDistance(int[] p1, int[] p2) {
		int a = p1[0] - p2[0];
		int b = p1[1] - p2[1];
		return (a * a) + (b * b);
	}

    public int numberOfBoomerangs(int[][] points) {
    	// Mapping distance to current point to the number of points who has the same distance to current point.
   		Map<Integer, Integer> map = new HashMap<>();
   		int result = 0;
   		for (int i = 0; i < points.length; i++) {
   			for (int j = 0; j < points.length; j++) {
   				if (j == i) continue;
   				int dist = getDistance(points[i], points[j]);
   				map.put(dist, map.getOrDefault(dist, 0) + 1);
   			}
   			for (int val: map.values()) {
   				result += val * (val - 1);
   			}
   			map.clear();
   		}

   		return result;
    }
}