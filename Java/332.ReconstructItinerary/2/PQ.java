public class Solution {
    private Map<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(String[][] tickets) {
        for(int i = 0; i < tickets.length; i++) {
            map.putIfAbsent(tickets[i][0], new PriorityQueue<>());
            map.get(tickets[i][0]).offer(tickets[i][1]);
        }

        List<String> route = new ArrayList<>();
        route.add("JFK");
        dfs(route, "JFK", tickets.length);
        return route;
    }

    private boolean dfs(List<String> route, String start, int ticketCount) {
        if(route.size() == ticketCount + 1) return true;
        if(!map.containsKey(start)) return false;
        PriorityQueue<String> dests = map.get(start);
        
        while(!dests.isEmpty()) {
            String dest = dests.poll();
            route.add(dest);
            if(dfs(route, dest, ticketCount)) return true;
            dests.offer(dest);
            route.remove(route.size() - 1);
        }
        
        return false;
    }

}