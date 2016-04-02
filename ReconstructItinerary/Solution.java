import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Solution {
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String[][] tickets = { {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}, {"JFK", "SFO"} };
		System.out.println(s.findItinerary(tickets));
	}
	
	public List<String> findItinerary(String[][] tickets) {
		Map<String, List<String>> map = new HashMap<>();
		
		for(int i = 0; i < tickets.length; i++) {
			String from = tickets[i][0];
			String to = tickets[i][1];
			
			if(!map.containsKey(from))
				map.put(from, new ArrayList<>());
			
			
			map.get(from).add(to);
		}
		
		for(Map.Entry<String, List<String>> entry: map.entrySet())
			Collections.sort(entry.getValue());
		
		List<String> path = new ArrayList<>();
		
		path.add("JFK");
		
		dfs(tickets.length, map, path, "JFK");
		
		return path;
    }
	
	private boolean dfs(int ticketNum, Map<String, List<String>> map, List<String> path, String start) {
		
		if(path.size() == ticketNum + 1) return true;
		if(!map.containsKey(start)) return false;
		List<String> destList = map.get(start);
		
		for(int i = 0; i < destList.size(); i++) {
			String dest = destList.get(i);
			path.add(dest);
			destList.remove(i);
			if(dfs(ticketNum, map, path, dest)) return true;
			destList.add(i, dest);
			path.remove(path.size() - 1);
		}
		
		return false;
		
	}
	
	
}