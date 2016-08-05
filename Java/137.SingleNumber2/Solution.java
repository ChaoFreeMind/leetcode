public int singleNumber(int[] nums) {
		int[] bitCount = new int[32];
		for(int i = 0; i < nums.length; i++)
			for(int j = 0; j < 32; j++)
				bitCount[j] += nums[i] >> j & 1;
		int res = 0;
		for (int i = 0; i < bitCount.length; i++) 
			res += bitCount[i] % 3 << i;
		return res;
	}