public class Solution {
    //Hierholzer's algorithm
    //Euler Path: A path that visits all edges of the graph exactly once.

    //Starting from JFK, we either go out there and stuck where there are still tickets left, 
    //or we go through all tickets and finish the tour.
    private Map<String, PriorityQueue<String>> map = new HashMap<>();
    //oruvate Map<String, List<String>> map = new HashMap<>();
    private List<String> route = new LinkedList<>();
    /*    
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
    }*/

    //More general way
    public List<String> findItinerary(String[][] tickets) {
        for(int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            map.putIfAbsent(from, ;
            map.get(from).offer(to);
        }

        //Sort
        for(List<String> list: map.values()) {
            Arrays.sort(list);∏
        }

        route.add("JFK");
        dfs("JFK", tickets.length);

        return route;
    }
    //Go down the path, if we do not find a valid path, go backward, try to find another one.
    private boolean dfs(String airport, int ticketNum) {
        if(route.size() == ticketNum + 1) return true;//Found ourself a valid path
        if(!map.containsKey(airport)) return false;
        List<String> adjList = map.get(airport);
        
        for(int i = 0; i < adjList.size(); i++) {
            String dest = adjList.get(i);
            route.add(dest);
            //Remove from the adjList
            adjList.remove(i);
            if(dfs(dest, ticketNum)) return true;
            route.remove(route.size() - 1);
            adjList.add(i, dest);
        }

        return false;
    }


}