// For a web developer, it is very important to know how to design a web page's size. So, given a 
// specific rectangular web page’s area, your job by now is to design a rectangular web page, whose 
// length L and width W satisfy the following requirements:

// 1. The area of the rectangular web page you designed must equal to the given target area.

// 2. The width W should not be larger than the length L, which means L >= W.

// 3. The difference between length L and width W should be as small as possible.
// You need to output the length L and the width W of the web page you designed in sequence.
// Example:
// Input: 4
// Output: [2, 2]
// Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1]. 
// But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not 
// optimal compared to [2,2]. So the length L is 2, and the width W is 2.
// Note:
// The given area won't exceed 10,000,000 and is a positive integer
// The web page's width and length you designed must be positive integers.

public class Solution {
    // Let's say the initial width / length are 1 / area, we increase width and see if we can get a 
    // valid length, if we do, then the new width / length would be better than the last because 
    // the diff is smaller
    public int[] constructRectangle(int area) {
        // length: res[0], width: res[1]
        int length = area, width = 1;
        int x = width;
        while (x <= area / x) {
            if (area % x == 0 ) {
                if (area / x >= x) {
                    length = area / x;
                    width = x;    
                } else {
                    break;
                }
            }
            x++;
        }

        return new int[]{length, width};
    }

    // Optimal, starting from the middle ((int)Math.sqrt(area))
    public int[] constructRectangle(int area) {
        int width = (int)Math.sqrt(area);

        while (area % width != 0) {
            width--;
        }

        int length = area / width;
        return new int[]{length, width};
    }
}