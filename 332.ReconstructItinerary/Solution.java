public class Solution {
    //Hierholzer's algorithm
    //Euler Path: A path that visits all edges of the graph exactly once.
    private Map<String, PriorityQueue<String>> map = new HashMap<>();
    private List<String> route = new LinkedList<>();
        
    public List<String> findItinerary(String[][] tickets) {

        for(int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            map.putIfAbsent(from, new PriorityQueue<String>());
            map.get(from).offer(to);
        }
        dfs("JFK");
        return route;
    }

    private void dfs(String airport) {
        while(map.contains(airport && !map.get(airport).isEmpty()) {
            dfs(map.get(airport).poll());
        }
        route.addFirst(airport);
    }


}