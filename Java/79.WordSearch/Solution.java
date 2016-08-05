public class Solution {
    public boolean exist(char[][] board, String word) {
    	//Invalid board
    	if(board == null || board.length == 0 || board[0].length == 0) 
    		return false;
    	int m = board.length, n = board[0].length;
    	boolean[][] visited = new boolean[m][n]; 
    	for(int i = 0; i < m; i++) {
    		for(int j = 0; j < n; j++) {
    			if(dfs(board, word, visited, i, j, 0)) return true;
    		}
    	}
    	
    	return false;
    }
    
    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int pos) {
    	if(pos == word.length()) return true;
    	if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) return false;
    	
    	if(word.charAt(pos) == board[i][j]) {
    		visited[i][j] = true;
    		if(dfs(board, word, visited, i, j + 1, pos + 1) || dfs(board, word, visited, i, j - 1, pos + 1) 
    		|| dfs(board, word, visited, i + 1, j, pos + 1) || dfs(board, word, visited, i - 1, j, pos + 1)) 
    			return true;
    		visited[i][j] = false;
    	}
    	
    	
    	return false;
    }
}