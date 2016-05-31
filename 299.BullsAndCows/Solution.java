 public String getHint(String secret, String guess) {
    	int[] secArr = new int[10];
    	int[] gueArr = new int[10];
    	int len = secret.length();
    	int bull = 0, cow = 0;
    	for(int i = 0; i < len; i++) {
    		char sec = secret.charAt(i);
    		char gue = guess.charAt(i);
    		if(sec == gue) {
    			bull++;
    		} else {
    			secArr[sec - '0']++;
    			gueArr[gue - '0']++;
    		}
    	}
    	
    	for(int i = 0; i < 10; i++) {
    		cow += Math.min(secArr[i], gueArr[i]);
    	}
    	
    	return bull + "A" + cow + "B";
    }
    