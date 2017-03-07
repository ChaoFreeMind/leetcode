// Given a picture consisting of black and white pixels, and a positive integer N, find the number of black pixels located at some specific row R and column C that align with all the following rules:

// Row R and column C both contain exactly N black pixels.
// For all rows that have a black pixel at column C, they should be exactly the same as row R
// The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.

// Example:
// Input:                                            
// [['W', 'B', 'W', 'B', 'B', 'W'],    
//  ['W', 'B', 'W', 'B', 'B', 'W'],    
//  ['W', 'B', 'W', 'B', 'B', 'W'],    
//  ['W', 'W', 'B', 'W', 'B', 'W']] 

// N = 3
// Output: 6
// Explanation: All the bold 'B' are the black pixels we need (all 'B's at column 1 and 3).
//         0    1    2    3    4    5         column index                                            
// 0    [['W', 'B', 'W', 'B', 'B', 'W'],    
// 1     ['W', 'B', 'W', 'B', 'B', 'W'],    
// 2     ['W', 'B', 'W', 'B', 'B', 'W'],    
// 3     ['W', 'W', 'B', 'W', 'B', 'W']]    
// row index

// Take 'B' at row R = 0 and column C = 1 as an example:
// Rule 1, row R = 0 and column C = 1 both have exactly N = 3 black pixels. 
// Rule 2, the rows have black pixel at column C = 1 are row 0, row 1 and row 2. They are exactly the same as row R = 0.

// Note:
// The range of width and height of the input 2D array is [1,200].

// This problem is so damn confusing...
public class Solution {
    // First we could easily find out which B's satisfy rule 1. From those B's that satisfy rule 1, 
    // we can see that to satisfy rule 2, those rows that contains the answer would look exactly the
    // same and the number of those rows would be N. (From rule 1)
    // For example: 
    // WBWB
    // WBWB
    // WWBB
    // WWBB
    public int findBlackPixel(char[][] picture, int N) {
        int res = 0;
        int row = picture.length, col = picture[0].length;
        // The number of black pixels in each columns.
        int[] colBlacks = new int[col];
        // Map string representation of each row that has N black pixels to its frequency.
        Map<String, Integer> rowFreqMap = new HashMap<>();
        for (int i = 0; i < row; i++) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; j++) {
                if (picture[i][j] == 'B') {
                    count++;
                    colBlacks[j]++;
                }
                sb.append(picture[i][j]);
            }
            if (count == N) {
                rowFreqMap.put(sb.toString(), rowFreqMap.getOrDefault(sb.toString(), 0) + 1);
            }
        }

        // The map now contains the rows that satisfies half of rule 1. (Columns are not validated 
        // yet)
        for (String rowStr: rowFreqMap.keySet()) {
            if (rowFreqMap.get(rowStr) == N) {
                for (int i = 0; i < rowStr.length(); i++) {
                    if (rowStr.charAt(i) == 'B' && colBlacks[i] == N) {
                        res += N;
                    }
                }
            }
        }
        return res;
    }
}