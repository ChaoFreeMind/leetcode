// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]

// First of all we need to realize this is a backtracking problem.
// Second try to come up the restriction of the way we generate the parentheses:
// 1. When the number of left parentheses has not reached n yet, we add a left one
// 2. When the number of left parentheses is more than right, we add a right one
// Finally we need to know when to stop and collect the result that is when the 
// left + right == 2 * n
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> resList = new ArrayList<>();
        int leftCnt = 0, rightCnt = 0;
        StringBuilder sb = new StringBuilder();
        backtrack(sb, resList, n, leftCnt, rightCnt);
        return resList;
    }

    private void backtrack(StringBuilder sb, List<String> resList, int n, int leftCnt, int rightCnt) {
        if (leftCnt + rightCnt == 2 * n) {
            resList.add(sb.toString());
            return;
        }

        if (leftCnt < n) {
            // Add a left parenthese
            sb.append("(");
            backtrack(sb, resList, n, leftCnt + 1, rightCnt);
            // Backtrack
            sb.deleteCharAt(sb.length() - 1);
        }

        if (rightCnt < leftCnt) {
            sb.append(")");
            backtrack(sb, resList, n, leftCnt, rightCnt + 1);
            // Backtrack
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}