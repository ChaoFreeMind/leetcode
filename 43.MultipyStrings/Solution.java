public String multiply(String num1, String num2) {
		//Return empty string in case of invalid input
		if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
			return "";
		
		if(num1.equals("0") || num2.equals("0"))
		    return "0";
		
		int[] digits = new int[num1.length() + num2.length()];
		
		int len1 = num1.length(), len2 = num2.length();
		
		for(int i = len1 - 1; i >= 0; i--) {
			for(int j = len2 - 1; i >= 0; i--) {
				digits[len1-i-1 + len2-j-1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
			}
		}
		int carry = 0;
		for(int i = 0; i < digits.length; i++) {
			digits[i] += carry;
			carry = digits[i] / 10;
			digits[i] %= 10;
		}
		
		StringBuilder sb = new StringBuilder();
		//Reversely iterate through digits array and add to our result
		for(int i = digits.length - 1; i >= 0; i--) 
			sb.append(digits[i]);
		//Get rid of leading zeros
		while(sb.length() >= 1 && sb.charAt(0) == '0') {
		    sb.deleteCharAt(0);
		} 
		
		return sb.toString();
    }