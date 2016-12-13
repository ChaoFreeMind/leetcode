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
}