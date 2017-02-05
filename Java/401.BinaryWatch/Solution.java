public class Solution {

	private String formatTime(int h, int m) {
		StringBuilder sb = new StringBuilder();
		sb.append(h + ":");
		sb.append((m < 10) ? ("0" + m) : m);
		return sb.toString();
	}

	// We are basically representing 0-11 using 4 bits and 0-59 using 6 bits
	// So we could just go through 0-11 and 0-59 and countBit of each number,
	// Add to result list if the sum of the number's bit count is num.
    public List<String> readBinaryWatch(int num) {
        for (int h = 0; h < 12; h++) {
        	for (int m = 0; m < 60; m++) {
        		if (Integer.countBit(h) + Integer.countBit(m) == num) {
        			resList.add(formatTime(h, m));
        		}
        	}
        }
        return resList;
    }

    // Method 2: Backtracking
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] nums1 = {1, 2, 4, 8};
        int[] nums2 = {1, 2, 4, 8, 16, 32};

        for (int i = 0; i <= num; i++) {
            if (i <= nums1.length && (num - i) <= nums2.length) {
                Set<Integer> list1 = generateDigits(nums1, i);
                Set<Integer> list2 = generateDigits(nums2, num - i);
                for (int hh: list1) {
                    if (hh >= 12) continue;
                    for (int ss: list2) {
                        if (ss >= 60) continue;
                        res.add(hh + ":" + (ss <= 9 ? "0" + ss : ss));
                    }
                }
            }
        }

        return res;
    }


    // Return a list of all possible sum of "count" numbers of elements from array nums.
    private Set<Integer> generateDigits(int[] nums, int count) {
        Set<Integer> res = new HashSet<>();
        generateDigitsHelper(res, nums, 0, 0, count);
        return res;
    }

    private void generateDigitsHelper(Set<Integer> res, int[] nums, int sum, int pos, int count) {
        if (count == 0) {
            res.add(sum);
            return ;
        }

        for (int i = pos; i < nums.length; i++) {
            generateDigitsHelper(res, nums, sum + nums[i], i + 1, count - 1);
        }
    }

}