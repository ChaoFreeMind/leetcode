public class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> resList = new ArrayList<>();
        
        if(s.length() > 12 || s.length() < 4) return resList;
        
        backtrack(resList, s, new ArrayList<>(), 0);
        
        return resList;
    }
    
    private void backtrack(List<String> resList, String str, List<String> ipList, int pos) {
        
        if(pos >= str.length()) {
            if(ipList.size() == 4) {
                resList.add(constructIp(ipList));
            }
            return;
        }
        
        for(int i = 1; i <= 3; i++) {
            if(pos + i > str.length()) break;
            
            String s = str.substring(pos, pos + i);
            
            if(s.length() > 1 && s.startsWith("0")) break;
            
            if(Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255) {
                ipList.add(s);
                backtrack(resList, str, ipList, pos + i);
                ipList.remove(ipList.size() - 1);
            }
        }
        
    }
    
    private String constructIp(List<String> ipList) {
        assert ipList.size() == 4;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ipList.size(); i++) {
            sb.append(ipList.get(i));
            sb.append(".");
        }
        sb.deleteCharAt(sb.length() - 1);
        
        return sb.toString();
    }
}