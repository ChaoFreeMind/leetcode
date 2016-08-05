public int findCelebrity(int n) {
        
        int cand = 0;
        for(int i = 1; i < n; i++) {
            if(knows(cand, i)) {
                //This means 1.cand is not our celebrity. 2.i could be potential celebrity
                cand = i;
            }
        }
        
        for(int i = 0; i < n; i++) {
            
            if(i != cand && (!knows(i, cand) || knows(cand, i))) {
                return -1;
            }
            
        }
        
        return cand;
    }