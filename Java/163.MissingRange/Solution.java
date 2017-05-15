// Given a sorted integer array where the range of elements are in the inclusive range 
// [lower, upper], return its missing ranges.

// For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, 
// return ["2", "4->49", "51->74", "76->99"].

// Be careful for the overflow!!
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            res.add(genRange(lower, upper));
            return res;
        }
        long prev = lower;
        for (int i = 0; i < nums.length; i++) {
            String range = genRange(prev, (long)nums[i] - 1);
            if (range != null) res.add(range);
            prev = (long)nums[i] + 1;
        }

        String lastRange = genRange((long)nums[nums.length-1] + 1, upper);
        if (lastRange != null) res.add(lastRange);

        return res;
    }

    private String genRange(long low, long high) {
        long diff = high - low;
        if (high == low) {
            return String.valueOf(low);
        } else if (high > low) {
            return String.valueOf(low) + "->" + String.valueOf(high);
        } else {
            return null;
        }
    }
}