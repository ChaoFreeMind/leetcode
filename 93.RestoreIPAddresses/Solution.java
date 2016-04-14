import java.util.ArrayList;
import java.util.List;

//Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
//For example:
//Given "25525511135",
//
//return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
public class Solution {
    
    public static void main(String[] args) {
        String s = "10211";
        System.out.println(new Solution().restoreIpAddresses(s));
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> resList = new ArrayList<>();
        List<String> ipDigits = new ArrayList<>();      
        backtrack(s, resList, ipDigits, 0);
        return resList;
    }
    
    private void backtrack(String s, List<String> resList, List<String> ipDigits, int pos) {
        
        if(ipDigits.size() > 4 || pos > s.length()) return;
        
        if(pos == s.length()) {
            if(ipDigits.size() == 4)
                resList.add(generateIP(ipDigits));
            return;
        }
        
        for(int i = 1; i <= 3; i++) {
            if(pos + i > s.length()) return;
            String sdigits = s.substring(pos, pos + i);
            //Prevent cases like "02, 003" being added into the result
            if(sdigits.startsWith("0") && sdigits.length() > 1) continue;
            
            if(Integer.parseInt(sdigits) >= 0 && Integer.parseInt(sdigits) <= 255) {
                ipDigits.add(sdigits);
                backtrack(s, resList, ipDigits, pos + i);
                ipDigits.remove(ipDigits.size() - 1);
            }
            
        }
        
    }
    
    private String generateIP(List<String> ipDigits) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ipDigits.size(); i++) {
            sb.append(ipDigits.get(i));
            sb.append(".");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
}