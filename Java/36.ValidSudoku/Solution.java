public class Solution {
    //The purpose of this problem is really for us to write concise code!!
	public boolean isValidSudoku(char[][] board) {
		
		for(int i = 0; i < board.length; i++) {
			Set<Character> seenRow = new HashSet<>();
			Set<Character> seenCol = new HashSet<>();
			Set<Character> seenCube = new HashSet<>();
			for(int j = 0; j < board[0].length; j++) {
				//Check row
				if(board[i][j] != '.' && !seenRow.add(board[i][j])) return false;
				//Check col
				if(board[j][i] != '.' && !seenCol.add(board[j][i])) return false;
				//check cube
				//Now i denotes which cube we are searching
				//Calculate the row and col index of first upper left point in current box
				int rowIdx = 3 * (i / 3);
				int colIdx = 3 * (i % 3);
				
				//Move from[rowIdx, colIdx] to search cube
				if(board[rowIdx + j/3][colIdx + j%3] != '.' && !seenCube.add(board[rowIdx + j/3][colIdx + j%3])) return false;
			}
		}
		return true;
	}
}