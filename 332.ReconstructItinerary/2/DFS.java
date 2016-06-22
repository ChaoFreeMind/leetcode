public class Solution {
    private Map<String, List<String>> map = new HashMap<>();

    public List<String> findItinerary(String[][] tickets) {
        for(int i = 0; i < tickets.length; i++) {
            map.putIfAbsent(tickets[i][0], new ArrayList<>());
            map.get(tickets[i][0]).add(tickets[i][1]);
        }

        //Sort map
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            Collections.sort(entry.getValue());
        }

        List<String> route = new ArrayList<>();
        if(!map.containsKey("JFK")) return route;
        route.add("JFK");
        dfs(route, "JFK", tickets.length);
        return route;
    }

    private boolean dfs(List<String> route, String start, int ticketCount) {
        if(route.size() == ticketCount + 1) return true;
        if(!map.containsKey(start)) return false;
        List<String> dests = map.get(start);
        for(int i = 0; i < dests.size(); i++) {
            String next = dests.get(i);
            route.add(next);
            dests.remove(i);//Remove head
            if(dfs(route, next, ticketCount)) return true;
            route.remove(route.size() - 1);
            dests.add(i, next);//Add to head
        }
        
        return false;
    }

}