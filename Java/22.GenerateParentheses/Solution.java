import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(resList, n, 0, 0, sb);
        
        return resList;
    }
    
    private void backtrack(List<String> resList, int n, int left, int right, StringBuilder sb) {
        
        if(left + right == 2 * n) {
            resList.add(sb.toString());
            return;
        }
        
        if(left < n) {
            sb.append("(");
            backtrack(resList, n, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if(right < left) {
            sb.append(")");
            backtrack(resList, n, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
}