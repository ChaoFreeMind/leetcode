public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length - 1, j = num2.length - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
        	int d1 = i >= 0 ? num1.charAt(i) - '0' : 0;
        	int d2 = j >= 0 ? num2.charAt(j) - '0' : 0;
        	int sum = d1 + d2 + carry;
        	sb.insert(0, sum % 10);
        	carry = sum / 10;
        	i--;
        	j--;
        }
        if (carry == 1) sb.insert(0, '1');
        return sb.toString();
    }
}