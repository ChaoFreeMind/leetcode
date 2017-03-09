// Given a non-empty array of integers, return the third maximum number in this array. If it does 
// not exist, return the maximum number. The time complexity must be in O(n).

// Example 1:
// Input: [3, 2, 1]

// Output: 1

// Explanation: The third maximum is 1.
// Example 2:
// Input: [1, 2]

// Output: 2

// Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
// Example 3:
// Input: [2, 2, 3, 1]

// Output: 1

// Explanation: Note that the third maximum here means the third maximum distinct number.
// Both numbers with value 2 are both considered as second maximum.
public class Solution {

    // Becareful about the original value of first, second and third, better initialize them with
    // Integer first = null...
    public int thirdMax(int[] nums) {
        long min = ((long)Integer.MIN_VALUE) - 1;
        // int will overflow, better be using long
        long first = min, second = min, third = min;

        for (int num: nums) {
            if (num == first || num == second || num == third) continue;
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num > third) {
                third = num;
            }
        }

        return (int)(third == min ? first : third);
    }    

    // Using PriorityQueue of size 3
    // Constructing a priority queue would take O(n), pulling value from it will take O(lgn)
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(3);
        int max = 0;
        for (int num: nums) {
            if (!set.add(num)) {
                max = Math.max(max, num);
                pq.offer(num);
                if (pq.size() > 3) {
                    pq.poll();
                }
            }
        }
        if (pq.size() == 2) pq.poll();
        return pq.poll();
    }

}