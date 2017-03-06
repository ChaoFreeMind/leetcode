// Given a picture consisting of black and white pixels, find the number of black lonely pixels.

// The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.

// A black lonely pixel is character 'B' that located at a specific position where the same row and same column don't have any other black pixels.

// Example:
// Input: 
// [['W', 'W', 'B'],
//  ['W', 'B', 'W'],
//  ['B', 'W', 'W']]

// Output: 3
// Explanation: All the three 'B's are black lonely pixels.
// Note:
// The range of width and height of the input 2D array is [1,500].

// Accepted 3 passes
public class Solution {
    // Original 3 passes O(n * m) time, O(n + m) space
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length, n = picture[0].length;
        int res = 0;
        // Number of black pixels on row i
        int[] row = new int[m];
        int[] col = new int[n];
        // Row by row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    row[i]++;
                    if (row[i] > 1) break;
                }
            }
        }

        // Col by col
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (picture[i][j] == 'B') {
                    col[j]++;
                    if (col[j] > 1) break;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && row[i] == 1 && col[j] == 1) {
                    res++;
                }
            }
        }

        return res;
    }

    // Improved 2 passes O(m * n) time and O(m + n) space
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length, n = picture[0].length;
        int res = 0;
        // Number of black pixels on row i
        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B') {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 'B' && row[i] == 1 && col[j] == 1) {
                    res++;
                }
            }
        }

        return res;
    }
}